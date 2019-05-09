<template>
  <article class="media">
    <figure class="media-left">
      <p class="image is-64x64">
        <img src="https://bulma.io/images/placeholders/128x128.png">
      </p>
    </figure>
    <div class="media-content">
      <div class="content">
        <p>{{message.contenu}}</p>
        <p>
          <strong>posté par @</strong>
        </p>
        <p>
          <small>
            <a>++Vote</a> ·
            <a>Vote--</a> ·
            <a>Répondre</a> · Dernière réponse le 14 Avril 2019
          </small>
        </p>
      </div>
      <MessageResponse
        v-bind:key="reponse.messageId"
        v-for="reponse in message.messageSet"
        v-bind:unereponse="reponse"
      />
    </div>
  </article>
</template>

<script>
import MessageResponse from "@/components/Message/MessageResponse.vue";

export default {
  name: "MessageItem",
  props: ["message"],
  components: { MessageResponse }
};
</script>

<style>
</style>
