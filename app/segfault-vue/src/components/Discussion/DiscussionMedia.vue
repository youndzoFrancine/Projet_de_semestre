<template>
  <div class="discussions">
    <div v-bind:key="post.id" v-for="post in posts" class="discussion-media">
      <DiscuMediaItem v-bind:post="post"/>
    </div>
  </div>
</template>

<script>
import DiscuMediaItem from "@/components/Discussion/DiscuMediaItem.vue";
export default {
  name: "DiscussionMedia",
  props: ["posts"],
  components: { DiscuMediaItem }
};
</script>

<style lang="scss" scoped>
</style>
