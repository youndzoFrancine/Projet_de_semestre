<template>
  <article class="media">
    <figure class="media-left">
      <p class="image is-64x64">
        <img src="https://bulma.io/images/placeholders/128x128.png">
      </p>
    </figure>
    <div class="media-content">
      <div class="content">
        <p>
          <strong>posté par @{{message.author}}</strong>
        </p>
        <p>{{message.text}}</p>
        <p>
          <small>
            <a>++Vote</a> ·
            <a>Vote--</a> ·
            <span v-if="isAuthenticated" @click="toggle">Répondre · </span>
            posté le: {{message.date}}
          </small>
        </p>
      </div>
      <div>
        <AddMessage v-if="comment" :parent="message.id"/>
      </div>
      <MessageItem
        v-for="reponse in message.childMsg"
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


export default {
  name: "MessageItem",
  data: function() {
    return {comment: false}
  },
  props: ["message"],
  methods: {
      toggle: function () {this.comment = !this.comment}
  },
  components: { MessageItem, AddMessage },
  created() {this.$root.$on('msgSent', () => this.comment = false)},
  computed: mapGetters(["isAuthenticated"])
};
</script>

<style>
</style>
