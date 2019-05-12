<template>
  <div>
    <article class="media">
      <figure class="media-left">
        <p class="image is-64x64">
          <img src="https://bulma.io/images/placeholders/128x128.png">
        </p>
      </figure>
      <div class="media-content">
        <div class="content">
          <router-link :to="{path: '/message/'+post.id}">
            <p>{{post.title}}</p>
          </router-link>
          <p>
            <small>
              <strong>posté par: @{{this.baseMsg.author}}</strong>
               le: {{this.baseMsg.date}}
            </small>
          </p>
          <Tag :tags="post.tags"/>
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
      </div>
      <div class="media-right">
        <div class="buttons">
          <button class="button purple is-small">{{this.baseMsg.childMsg.length}} réponses</button>
          <button class="button purle is-small is-outlined">score: {{this.baseMsg.score}}</button>
        </div>
      </div>
    </article>
  </div>
</template>

<script>
import Tag from "@/components/Tag/Tag.vue";

export default {
  name: "DiscuMediaItem",
  props: ["post"],
  components: {
    Tag
  },
  computed: { 
    baseMsg () {
      return this.$store.getters.getOneMessage(this.post.id)
    }
  }
};
</script>

<style lang="scss" scoped>
</style>
