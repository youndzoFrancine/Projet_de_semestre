<template>
  <div class="discussion">
    <Discussionbar/>
    <DiscussionMedia v-bind:posts="getAllDiscussions"/>
  </div>
</template>

<script>
import Discussionbar from "@/components/Discussion/DiscussionBar.vue";
import DiscussionMedia from "@/components/Discussion/DiscussionMedia.vue";
//import axios from "axios";
import { mapGetters, mapActions } from "vuex";

export default {
  name: "Discussion",
  components: {
    Discussionbar,
    DiscussionMedia
  },
  methods: {
    ...mapActions(["fetchDiscussions"])
  },
  computed: mapGetters(["getAllDiscussions"]),
  created() {
    console.log("yollloo");
    this.fetchDiscussions();
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.sujet {
  height: 2em;
}
</style>