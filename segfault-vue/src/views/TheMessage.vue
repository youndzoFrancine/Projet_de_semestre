<template>
  <div class="messages">
    Page de test, il faut passer par une route avec argument pour
    avoir les réponses d'une discussion comme y faut
    <MessageItem v-bind:message="message"/>
  </div>
</template>

<script>
import MessageItem from "@/components/Message/MessageItem.vue";
import axios from "axios";

export default {
  name: "TheMessage",
  props: { idtofetch: 2 },
  components: {
    MessageItem
  },
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
  },
  props: []
};
</script>

<style>
</style>
