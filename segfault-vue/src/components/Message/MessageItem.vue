<template>
  <article class="media">
    <figure class="media-left">
        <p v-if="isAuthenticated" @click="voteMsg('up')" :class="{green: vote=='up'}" >
          <span class="icon is-medium">
            <font-awesome-icon icon="arrow-up"/>
          </span>
        </p>
        score:<br />
        {{message.score}}
        <p v-if="isAuthenticated" @click="voteMsg('down')" :class="{red: vote=='down'}" >
          <span class="icon is-medium">
            <font-awesome-icon icon="arrow-down"/>
          </span>
        </p>
      </figure>
    <div class="media-content">
      <div class="content" :class="message.author.role.roleID > 1 ? 'teacher':'' ">
        <p>
          <router-link  :to="{path: '/user/'+ message.author.utilisateurID}" >
            <strong>posté par @{{message.author.nomUtilisateur}}</strong>
          </router-link>
        </p>
        <p>{{message.text}}</p>
        <p>
          <small>
            posté le: {{message.date}}
            <span v-if="isAuthenticated" @click="toggle" class="right"> · Répondre · </span>
          </small>
        </p>
      </div>
      <div>
        <AddMessage v-if="comment" :parent="message.id"/>
      </div>
      <MessageItem
        v-for="reponse in sortedMsg"
        :message="reponse"
        :key="reponse.id"
        :name="reponse.id"           
      />
    </div>
  </article>
</template>

<script>
import MessageItem from "@/components/Message/MessageItem.vue";
import AddMessage from "@/components/Discussion/AddMessage.vue";
import { mapGetters } from "vuex";
import axios from "axios"

export default {
  name: "MessageItem",
  data: function() {
    return {comment: false}
  },
  props: ["message"],
  methods: {
    toggle: function () {this.comment = !this.comment},
    
    voteMsg: async function(type) {
      if (type != this.vote) {
        const newVote = {
          upVote: type == "up" ? true : false,
          messageID: this.message.id,
          utilisateurID: this.$store.getters.user.utilisateurID
        }
        await axios
        .post(this.$store.getters.apiURL + "votes/create", newVote)
        .then(response => {
          if (response.status == 201) {
            const diff = this.vote == "no" ? 1 : 2
            this.message.score += (type == 'up' ? diff : -diff)
            this.$store.commit("checkAndAddVote", newVote)
          } else {
            this.$store.dispatch("displayError", "error while creating vote.")
          }
        })
        .catch(error => {
          console.log(error);
        });
      }
    }
  },
  components: { MessageItem, AddMessage },
  created() {
    this.$root.$on('msgSent', () => this.comment = false)
    //set 
  },
  computed: { 
    ...mapGetters(["isAuthenticated", "getVote"]),
    // makes a sorted copy of the table to display it, so the store is not modified, so beautiful.
    sortedMsg: function () {
      return this.message.childMsg.map(a=>a).sort((a,b) => b.score - a.score || a.date.localeCompare(b.date) )
    },
    vote: function () {
      const vote = this.getVote(this.message.id)
      if (vote == undefined)
        return 'no'
      return vote.upVote? 'up' : 'down'
    }
  }
};
</script>

<style>
  .teacher {background-color: rgba(0,200,0,0.1);}
  .green {background-color: rgba(0,200,0,0.5);}
  .red {background-color: rgba(200,0,0,0.5);}
  figure {text-align: center;}
</style>
