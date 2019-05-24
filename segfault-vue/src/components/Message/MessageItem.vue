<template>
  <article class="media">
    <figure class="media-left">
        <p v-if="isAuthenticated" @click="voteMsg({msg: message, type:'up'})" :class="{green: vote(message.id)=='up'}" >
          <span class="icon is-medium">
            <font-awesome-icon icon="arrow-up"/>
          </span>
        </p>
        score:<br />
        {{message.score}}
        <p v-if="isAuthenticated" @click="voteMsg({msg: message, type:'down'})" :class="{red: vote(message.id)=='down'}" >
          <span class="icon is-medium">
            <font-awesome-icon icon="arrow-down"/>
          </span>
        </p>
      </figure>
    <div class="media-content">
      <div class="content" :class="message.author.role.roleID > 1 ? 'teacher':'user' ">
        <p>
          <router-link  :to="{path: '/user/'+ message.author.utilisateurID}" >
            <strong>posté par @{{message.author.nomUtilisateur}}</strong>
          </router-link>
          <span class="right button is-outlined is-small" v-if="canDelete" @click="deleteMsg(message.id)"> · Delete · </span>
          
        </p>
        <p>{{message.text}}</p>
        <p>
          <small >
            posté le: {{message.date}}
          </small>
            <span v-if="isAuthenticated" @click="toggle" class="right button is-outlined is-small">
              · Répondre · </span>
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
import { mapGetters, mapActions } from "vuex";
//import axios from "axios"

export default {
  name: "MessageItem",
  data: function() {
    return {comment: false}
  },
  props: ["message"],
  methods: {
    ...mapActions(["voteMsg", "deleteMsg"]),
    toggle: function () {this.comment = !this.comment},
  
  },
  components: { MessageItem, AddMessage },
  created() {
    this.$root.$on('msgSent', () => this.comment = false)
    //set 
  },
  computed: { 
    ...mapGetters(["isAuthenticated", "vote", "user", "getById"]),
    // makes a sorted copy of the table to display it, so the store is not modified, but new table still references other items, so beautiful.
    sortedMsg: function () {
      return this.message.childMsg.map(a=>a).sort((a,b) => b.score - a.score || a.date.localeCompare(b.date) )
    },
    canDelete: function () {
      // useless for now: DB deletes corresponding user when deleting a message...
      return false;
//      return (this.isAuthenticated && !this.message.childMsg.length && ! this.getById(this.message.id) &&
//          (this.user.role.roleID == 4 || this.message.author.utilisateurID == this.user.utilisateurID))
    },
    
  }
};
</script>

<style>
  figure {text-align: center;}
</style>
