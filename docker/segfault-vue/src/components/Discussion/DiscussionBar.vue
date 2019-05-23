<template>
  <div class="discussion-bar">
    <div class="columns">
      <div class="column is-5">
        <h1 class="title">Questions du moment</h1>
      </div>
      <div class="column is-4">
        <Discussiontabs/>
      </div>
      <div v-if="isAuthenticated" class="column is-3">
        <router-link to="nouveau" class="button is-success">Nouv. Question</router-link>
      </div>
    </div>
  </div>
</template>

<script>
import Discussiontabs from "@/components/Discussion/DiscussionTabs.vue";
import { mapGetters } from "vuex";

export default {
  name: "Discussionbar",
  components: {
    Discussiontabs
  },
  computed: mapGetters(["isAuthenticated"])
};
</script>

<style lang="scss" scoped>
.discussion-bar {
  margin-bottom: 30px;
}
</style>
