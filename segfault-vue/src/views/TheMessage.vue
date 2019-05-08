<template>
  <div class="messages">
    test
    <MessageItem v-bind:message="message"/>
  </div>
</template>

<script>
import MessageItem from "@/components/Message/MessageItem.vue";
import axios from "axios";

export default {
  name: "TheMessage",
  components: {
    MessageItem
  },
  data() {
    return {
      message: {
        messageId: 1,
        contenu: "Message de test",
        score: 30,
        MessageSet: []
      }
    };
  },
  mounted() {
    axios.get("http://localhost:8087/messages/1").then(response => {
      this.message = response.data;
    });
  },
  props: []
};
</script>

<style>
</style>
