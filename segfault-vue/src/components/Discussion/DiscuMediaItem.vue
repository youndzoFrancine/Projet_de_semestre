<template>
  <div>
    <article class="media">
      <figure class="media-left">
        <p  v-if="isAuthenticated" @click="voteMsg({msg: baseMsg, type:'up'})" :class="{green: vote(baseMsg.id)=='up'}" >
          <span class="icon is-medium">
            <font-awesome-icon icon="arrow-up"/>
          </span>
        </p>
        <p v-if="isAuthenticated" @click="voteMsg({msg: baseMsg, type:'down'})" :class="{red: vote(baseMsg.id)=='down'}" >
          <span class="icon is-medium">
            <font-awesome-icon icon="arrow-down"/>
          </span>
        </p>
      </figure>
      <div class="media-content">
        <div class="content" :class="this.baseMsg.author.role.roleID > 1 ? 'teacher':'user' ">
          <router-link :to="{path: '/message/'+post.id}">
            <p>{{post.title}}</p>
          </router-link>
          <p>
            <small>
              <router-link  :to="{path: '/user/'+ this.baseMsg.author.utilisateurID}" >
                <strong>posté par: @{{this.baseMsg.author.nomUtilisateur}}</strong>
              </router-link>
               <span class="right">le: {{this.baseMsg.date}}</span>
            </small>
          </p>
    
          <Tag :tags="bindedTags"/>

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
          <div class="button is-small">{{this.baseMsg.childMsg.length}} réponses</div>
          <div class="button is-small is-outlined">score: {{this.baseMsg.score}}</div>
        </div>
      </div>
    </article>
  </div>
</template>

<script>
import Tag from "@/components/Tag/Tag.vue";
import { mapGetters, mapActions } from "vuex";

export default {
  name: "DiscuMediaItem",
  props: ["post"],
  components: {
    Tag
  },
  methods: {
    ...mapActions(["voteMsg"])
  },
  
  computed: { 
    ...mapGetters(["vote", "isAuthenticated", "getAllTags"]),
    baseMsg () {
      return this.$store.getters.getOneMessage(this.post.id)
    },
    bindedTags () {
      let tab = []
      for (let tag of this.post.tags) {
        const found = this.getAllTags.find(realTag => realTag.id == tag.id)
        if (found) tab.push(found)
      }
      return tab
    }
  }
};
</script>

<style lang="scss" scoped>
  .media-right {max-width: 100px;}
  .media-right > div > div {width: 90px;}
</style>
