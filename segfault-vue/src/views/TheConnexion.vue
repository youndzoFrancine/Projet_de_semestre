<template>
  <form id="Connexion">
    <div class="Connexion">
      <h1 class="title">Connexion</h1>
    </div>

    <!--email-->
    <div class="field">
      <label class="label">Email</label>
      <div class="field has-addons">
        <div class="control is-expanded has-icons-left has-icons-right has-addons" type="email">
          <input
            class="input is-success"
            v-model="email"
            id="email"
            type="text"
            placeholder="email"
            autofocus
          >
          <span class="icon is-small is-left">
            <font-awesome-icon icon="envelope"/>
          </span>
          <span class="icon is-small is-right">
            <font-awesome-icon icon="exclamation"/>
          </span>
        </div>
        <p class="control">
          <!--
          <a class="button is-static">
     <font style="text-transform: lowercase;"> @heig-vd.ch</font>
          </a>-->
        </p>
      </div>
    </div>

    <!--mot de passe-->
    <div class="field">
      <label class="label">Mot de passe</label>

      <div class="control has-icons-left">
        <input
          class="input is-success"
          v-model="password"
          id="password"
          type="password"
          placeholder="password"
          @input="sha256(password)"
        >
        <span class="icon is-small is-left">
          <font-awesome-icon icon="lock"/>
        </span>
      </div>

      <div class="control">
        <!--login-->
        <div class="columns">
          <div class="column">
            <p class="control">
              <button class="button is-success" v-on:click="connexion">connexion</button>
            </p>
            <template v-if="ConnexionError">
              <p class="help is-danger">{{ ConnexionError }}</p>
            </template>
          </div>
          <div class="column">
            <label class="label">Pas encore de compte?</label>
            <router-link to="/inscription">
              <p>
                <a>s'inscrire</a>
              </p>
            </router-link>
          </div>
        </div>
      </div>
    </div>
  </form>
</template>


<script>
import axios from "axios";
import {mapActions} from "vuex"
  
export default {
  name: "theInscription",
  components: {},
  data: function() {
    return {
      email: null,
      password: null,
      ConnexionError: null,
      tentative: 0
    };
  },
  methods: {
    ...mapActions(["sha256"]),
    
    connexion: async function() {
      
      const sleep = ms => new Promise(res => setTimeout(res, ms));
      
      if (this.tentative > 3) {
        this.ConnexionError = "attention le nombre de tentative augmente le temps d'attente";
        sleep(200 * this.tentative);
      }

      await axios
      .post(this.$store.getters.apiURL + "utilisateurs/signin", {
        mailUtilisateur: this.email,
        motDePasse: this.$store.getters.hashedPass
      })
      .then(response => {
        if (response.status == 202) {
          
          this.$store.commit("login", {jwt: response.data.token, user: response.data.user});
          this.$store.dispatch("fetchVotes")
          
          this.$router.go(-1)
        }
        else {
          console.log("won't happen")
        }
      })
      .catch(error => {
        console.log("error: ", error.response);
        // debug shortcut only
//        if (this.password == "cc") {
//          this.$store.commit("login", {jwt: "7h1$iZaJw7", user: {"utilisateurID": 7,
//                            "nomUtilisateur": "M@X",
//                            "mailUtilisateur": "max@heig-vd.ch",
//                            "departementSet": [],
//                            "role": {
//                                "roleID": 4,
//                                "nomRole": "Admin"
//                            }}})
//          this.$store.dispatch("fetchVotes" )
//          this.$router.go(-1)
//        }
//        else {
          const data = error.response.data
          // return format is crap...
          this.$store.dispatch("displayError", "refused by backEnd: " + (data.errors ? data.errors[0].defaultMessage : data.error? data.error : data))
          ++ this.tentative;
//        }
      });
  
    }
  }
};
</script>