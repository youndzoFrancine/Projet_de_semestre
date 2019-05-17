<template>
  <div class="discussions">
    <div v-bind:key="post.id" v-for="post in posts" class="discussion-media">
      <DiscuMediaItem v-bind:post="post"/>
    </div>
    <div class="buttons">
    <button v-if="getPrevPageNb !== null" class="button" @click="fetchDiscussions(getPrevPageNb)">previous page</button>
    <button v-if="getNextPageNb !== null" class="button" @click="fetchDiscussions(getNextPageNb)">next page</button>
    </div>
  </div>
</template>

<script>
import DiscuMediaItem from "@/components/Discussion/DiscuMediaItem.vue";
  import {mapActions, mapGetters} from "vuex"

export default {
  name: "DiscussionMedia",
  props: ["posts"],
  methods: {
    ...mapActions(["fetchDiscussions"])
  },
  components: { DiscuMediaItem },
  computed: mapGetters(["getNextPageNb","getPrevPageNb"])
  
};
</script>

<style lang="scss" scoped>
</style>
