<template>
 <div>
  <label class="label">Username: </label>
  <div class="control has-icons-left">
    <input
      class="input"
      v-model="newName"
      id="newName"
      type="text"
      :readonly="!isProfile"
    >
    <!--      placeholder="userDispl.nomUtilisateur"-->
  </div>
  <div  v-if="isProfile">
  
    <label class="label">Change pass: </label>
    <div class="control has-icons-left">
      <input
        class="input"
        v-model="password"
        id="password"
        type="password"
        placeholder="password"
        @input="sha256(password)"
      >
    </div>
    
    <label class="label" >Repeat new pass: </label>
    <div class="control has-icons-left">
      <input
        class="input"
        v-model="passValid"
        id="passValid"
        type="password"
      >
    </div>
  </div>
  
  <label class="label">Role: </label>
  <div class="buttons">
    {{this.roles[userDispl.role.roleID-1].nomRole}}&nbsp;
    <span v-if="user.role && user.role.roleID > 1" class="button is-primary is-outlined" @click="upgradeRole"> upgrade role </span>
  </div>
  
  <div v-if="isProfile || (user.role && user.role.roleID > 1)" class="buttons">
    <span class="button is-primary" @click="saveUser">Save</span> 
  </div>
   <div v-if="isProfile" >
    <p>Saved discussions:</p>
    <div v-for="disc in savedDisc" :key="disc.id" :name="disc.id" >
      <router-link :to="{path: '/message/'+disc.id}">
        {{disc.title}}  
      </router-link> 
    </div>
   </div>
 </div>
</template>

<script>
//import MessageItem from "@/components/Message/MessageItem.vue";
import axios from "axios";
import { mapGetters, mapActions } from "vuex";

export default {
  name: "UserInfo",
  // this prop is coming from the url
  props: ["id"],
  data: function() {
    return {
      newName: "",
      password: "",
      passValid: "",
      userDispl: {utilisateurID: null, nomUtilisateur: "", role: {roleID: null, nomRole: ""}},
      roles: []
    };
  },
  methods: {
    ...mapActions(["sha256"]),
    upgradeRole: function() {
      // cannot upgrade to a role higher than the logged user
      if (this.userDispl.role.roleID < this.user.role.roleID) {
        this.userDispl.role.roleID ++
        this.$store.dispatch("displayError", "role upgraded")
      }
      else {
        // admins can downgrade when max role reached
        if (this.user.role.roleID == 4) {
          this.userDispl.role.roleID = 1
          this.$store.dispatch("displayError", "max role reached, set to student.")
        }
        else 
          this.$store.dispatch("displayError", "cannot upgrade more.")
      }
    },
    saveUser: async function() {
      if (this.password != this.passValid) {
        this.$store.dispatch("displayError", "error: pass are not the same.")
        this.password = this.passValid = ""
        this.$store.commit("resetHashedPass")
        return
      }
      const name = this.userDispl.nomUtilisateur === this.newName ? "" : this.newName
      axios.put( this.apiURL + "utilisateurs/" + this.id, {
        newUsername: name,
        newPass: this.hashedPass,
        newRoleId: this.userDispl.role.roleID
      })
      .then(response => {

        if (response.status == 200) {
          this.$store.dispatch("displayError", "user updated")
//          this.$router.go(-1)
        }
        else
          this.$store.dispatch("displayError", "error updating user.")

      })
      .catch(error => {
        console.log(error);
      });
    },
    fetchUser: async function() {
      
      if(this.isProfile) {
        this.userDispl = this.user
        this.newName = this.user.nomUtilisateur
        this.$store.commit("resetHashedPass")
      }
      else
        axios.get( this.apiURL + "utilisateurs/" + this.id)
        .then(response => {
  
          if (response.status == 200) {
            this.userDispl = response.data
            this.newName = this.userDispl.nomUtilisateur
          }
          else
            this.$store.dispatch("displayError", "error fetching user.")
        })
        .catch(error => {
          console.log(error);
        });
    }
  },
  computed: {
      ...mapGetters(["isAuthenticated", "user", "hashedPass", "apiURL"]),

    isProfile: function() {return this.id == this.user.utilisateurID},
    savedDisc: function() {return JSON.parse(localStorage.getItem('savedDisc'))}
//    getTitle: function () {
//      const disc = this.getAllDiscussions.find(disc => disc.id == this.id)
//      return disc ? disc.title : ""
//    }
  },
  created() {
      this.fetchUser()
      axios.get( this.apiURL + "roles/all")
        .then(response => {
  
          if (response.status == 200) {
            this.roles = response.data
          }
          else
            this.$store.dispatch("displayError", "error fetching roles.")
        })
        .catch(error => {
          console.log(error);
        });
  },
  watch: {
    id: function() {
        this.fetchUser()
      }
  }
  
};
</script>

<style>
/*  h2 {margin: 2vw; color: mediumslateblue; font-size: 1.5em;}*/
</style>
