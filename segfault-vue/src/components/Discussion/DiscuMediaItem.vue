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
        <div class="content" :class="this.baseMsg.author.role.roleID > 1 ? 'teacher':'' ">
          <router-link :to="{path: '/message/'+post.id}">
            <p>{{post.title}}</p>
          </router-link>
          <p>
            <small>
              <strong>posté par: @{{this.baseMsg.author.nomUtilisateur}}</strong>
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
  .teacher {background-color: rgba(0,200,0,0.1);}
</style>
