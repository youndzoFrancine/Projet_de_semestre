<template>
  <div class="messages">
    <h2>{{getTitle}}</h2>
    <span class="button is-small" v-if="isAuthenticated && getById(id)" @click="saveMsg" style="margin-bottom: 20px;">
      {{saved? 'unsave':'save'}} discussion
    </span>
    <MessageItem v-bind:message="getOneMessage(id)"/>
  </div>
</template>

<script>
import MessageItem from "@/components/Message/MessageItem.vue";
// import axios from "axios";
import { mapGetters, mapActions } from "vuex";

export default {
  name: "TheMessage",
  // this prop is coming from the url
  props: ["id"],
  data: function() {
    return {saved: false}
  },
  components: {
    MessageItem
  },
  methods: {
    ...mapActions(["fetchMessage"]),
    
    saveMsg: function () {
      const disc = this.getById(this.id)
//      if (!disc) return  // -> button not visible if not a disc.
      let stored = JSON.parse(localStorage.getItem('savedDisc'))
      if (! stored)
        stored = []
    //console.log (stored)
      if (! this.saved) {
        stored.push( {id: disc.id, title: disc.title} )
        localStorage.setItem('savedDisc', JSON.stringify(stored))
        this.saved = true
      }
      else {
        for (let i = 0; i < stored.length; i++) 
          if (stored[i].id == this.id) {
            stored.splice(i,1)
            localStorage.setItem('savedDisc', JSON.stringify(stored))
            this.saved = false
            break
          }
      }
    }
  },
  computed: {
    ...mapGetters(["getOneMessage", "getAllDiscussions", "getById", "isAuthenticated"]),
    getTitle: function () {
      const disc = this.getById(this.id)
      return disc ? disc.title : ""
    }
  },
  created() {
    
  // replace by: if getOneMessage (this.id).id ==null -> fetch1disc (to create, does once the same as fetchDisc)
    (async() => {
      if (this.getAllDiscussions.length == 0 || ! this.getOneMessage(this.id).id) {
        await this.$store.dispatch("getDiscTitle", this.id )
        this.$store.dispatch("fetchMessage", this.id )
        this.$store.dispatch("fetchVotes" )
      }
    })().then( () => {
      // protection if a random message is called
        if (this.getById(this.id))
            if (localStorage.getItem('savedDisc')) 
              this.saved = !! JSON.parse(localStorage.getItem('savedDisc')).find(disc => disc.id == this.id)
      }
    )
  }
  
};
</script>

<style>
  h2 {margin: 2vw; color: mediumslateblue; font-size: 1.5em;}
</style>
