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
      return this.getAllDiscussions.find(disc => disc.id == this.id).title
    }
  },
  created() {
    
    if (this.getAllDiscussions.length == 0) {
      this.$store.dispatch("fetchMessage", this.id )
      this.$store.dispatch("fetchVotes" )
    }
  }
  /*
  ,
  data() {
    return {
      message: {
        messageId: 1,
        contenu: "Message en cours de chargement",
        score: 30,
        MessageSet: []
      }
    };
  },
  mounted() {
    axios.get("http://localhost:8087/messages/1").then(response => {
      this.message = response.data;
    });
  }*/
};
</script>

<style>
  h2 {margin: 2vw; color: mediumslateblue; font-size: 1.5em;}
</style>
