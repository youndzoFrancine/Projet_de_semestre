<template>
  <div class="messages">
    <h2>{{getTitle}}</h2>
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
  components: {
    MessageItem
  },
  methods: {
    ...mapActions(["fetchMessage"])
  },
  computed: {
    ...mapGetters(["getOneMessage", "getAllDiscussions"]),
    getTitle: function () {
      const disc = this.getAllDiscussions.find(disc => disc.id == this.id)
      return disc ? disc.title : ""
    }
  },
  created() {
    
  // replace by: if getOneMessage (this.id).id ==null -> fetch1disc (to create, does once the same as fetchDisc)
    if (this.getAllDiscussions.length == 0) {
      this.$store.dispatch("fetchMessage", this.id )
      this.$store.dispatch("getDiscTitle", this.id )
      this.$store.dispatch("fetchVotes" )
    }
  }
  
};
</script>

<style>
  h2 {margin: 2vw; color: mediumslateblue; font-size: 1.5em;}
</style>
