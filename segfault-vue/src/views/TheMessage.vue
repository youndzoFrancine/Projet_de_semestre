<template>
  <div class="messages">
    <MessageItem v-bind:message="getOneMessage"/>
  </div>
</template>

<script>
import MessageItem from "@/components/Message/MessageItem.vue";
// import axios from "axios";
import { mapGetters, mapActions } from "vuex";

export default {
  name: "TheMessage",
  props: { idtofetch: 2 },
  components: {
    MessageItem
  },
  methods: {
    ...mapActions(["fetchMessage"])
  },
  computed: mapGetters(["getOneMessage"]),
  created() {
    this.fetchMessage();
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
</style>
