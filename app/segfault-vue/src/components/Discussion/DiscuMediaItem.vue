<template>
  <div>
    <article class="media">
      <figure class="media-left">
        <p>
          <span class="icon is-medium">
            <font-awesome-icon icon="arrow-up"/>
          </span>
        </p>
        <p class="icon is-medium">
          <span class="icon is-medium">
            <font-awesome-icon icon="arrow-down"/>
          </span>
        </p>
      </figure>
      <div class="media-content">
        <div class="content">
          <router-link to="/message">
            <p>{{post.sujet}}</p>
          </router-link>
          <p>
            <small>
              <strong>posté par @{{post.utilisateur.nomUtilisateur}}</strong>
              posté le {{post.msgracine.dateCreation}}
            </small>
          </p>
          <p>
            <Tag v-bind:tags="post.tagSet"/>
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
      </div>
      <div class="media-right">
        <div class="buttons">
          <button class="button purple is-small">10 réponses</button>
          <button class="button purle is-small is-outlined">score {{post.msgracine.score}}</button>
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
  computed: {}
};
</script>

<style lang="scss" scoped>
</style>
