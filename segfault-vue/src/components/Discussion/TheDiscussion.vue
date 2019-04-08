<template>
  <div class="discussion">
    <Discussionbar/>
    <article class="media">
      <figure class="media-left">
        <p class="image is-64x64">
          <img src="https://bulma.io/images/placeholders/128x128.png">
        </p>
      </figure>
      <div class="media-content">
        <div class="content">
          <p>Pourquoi l'icône run de Intellij est griséee?</p>
          <p>
            <strong>posté par shellmaster</strong>
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
      </div>
      <div class="media-right">
        <button class="delete"></button>
      </div>
    </article>
    <div class="holder">
      <ul>
        <div class="sujet" v-for="(data, sujet) in discu" :key="sujet">{{data.sujet}}</div>
      </ul>
    </div>
  </div>
</template>

<script>
import Discussionbar from "@/components/Discussion/DiscussionBar.vue";
import axios from "axios";

export default {
  name: "Discussion",
  components: {
    Discussionbar
  },
  data() {
    return {
      discu: []
    };
  }
  /* ,
  mounted() {
    axios
      .get("http://localhost:8087/discussions/all")
      .then(response => (this.discu = response.data))
      .catch(error => console.log(error));
  } */
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.sujet {
  height: 2em;
}
</style>