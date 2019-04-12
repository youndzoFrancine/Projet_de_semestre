<template>
  <div class="discussion">
    <Discussionbar/>
    <DiscussionMedia v-bind:posts="posts"/>
  </div>
</template>

<script>
import Discussionbar from "@/components/Discussion/DiscussionBar.vue";
import DiscussionMedia from "@/components/Discussion/DiscussionMedia.vue";

export default {
  name: "Discussion",
  components: {
    Discussionbar,
    DiscussionMedia
  },

  data() {
    return {
      posts: [
        { id: 1, title: "Angular, React et Vue.js, que choisir?" },
        { id: 2, title: "Vous aussi vous arrivez pas à ...?" },
        { id: 3, title: "Une question particulièrement compliqué" }
      ]
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