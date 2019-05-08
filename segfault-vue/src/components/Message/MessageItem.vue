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
          <small>dernière réponse 14 avril</small>
        </p>
      </div>
      <nav class="level is-mobile">
        <div class="level-left">
          <a class="level-item">
            <span class="icon is-small">
              <i class="fas fa-reply"></i>
            </span>
          </a>
          <a class="level-item">
            <span class="icon is-small">
              <i class="fas fa-retweet"></i>
            </span>
          </a>
          <a class="level-item">
            <span class="icon is-small">
              <i class="fas fa-heart"></i>
            </span>
          </a>
        </div>
      </nav>
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
