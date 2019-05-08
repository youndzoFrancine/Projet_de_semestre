<template>
  <div class="discussion">
    <Discussionbar/>
    <DiscussionMedia v-bind:posts="posts"/>
  </div>
</template>

<script>
import Discussionbar from "@/components/Discussion/DiscussionBar.vue";
import DiscussionMedia from "@/components/Discussion/DiscussionMedia.vue";
import axios from "axios";

export default {
  name: "Discussion",
  components: {
    Discussionbar,
    DiscussionMedia
  },

  data() {
    return {
      posts: [
        {
          id: 1,
          sujet: "Angular, React et Vue.js, que choisir?",
          utilisateur: { nomUtilisateur: "Shellmaster" }
        },
        {
          id: 2,
          sujet: "Vous aussi vous arrivez pas à ...?",
          utilisateur: { nomUtilisateur: "Shellmaster" }
        },
        {
          id: 3,
          sujet: "Une question particulièrement compliqué",
          utilisateur: { nomUtilisateur: "Shellmaster" }
        }
      ]
    };
  },
  mounted() {
    axios.get("http://localhost:8087/discussions/all").then(response => {
      this.posts = response.data;
    });
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