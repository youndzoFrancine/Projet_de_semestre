<template>
  <div class="discussion-bar">
    <div class="columns">
      <div class="column is-5">
        <h1 class="title">Questions du moment</h1>
      </div>
      <div class="column">
        <Discussiontabs/>
      </div>
      <div class="column">
        <a class="button is-success">Nouv. Question</a>
      </div>
    </div>
  </div>
</template>

<script>
import Discussiontabs from "@/components/Discussion/DiscussionTabs.vue";

export default {
  name: "Discussionbar",
  components: {
    Discussiontabs
  }
};
</script>

<style lang="scss" scoped>
</style>
