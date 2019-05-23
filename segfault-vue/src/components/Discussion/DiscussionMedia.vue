<template>
  <div class="discussions">
    <div v-bind:key="post.id" v-for="post in sortedDisc" class="discussion-media">
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
  computed: {
    ...mapGetters(["getNextPageNb","getPrevPageNb", "sortBy"]),
     // makes a sorted copy of the table to display it, so the store is not modified, so beautiful.
    sortedDisc: function () {
      if (this.sortBy === "date")
        return this.posts
      const get = this.$store.getters
      return this.posts.map(a=>a).sort( (a,b) => 
          get.getOneMessage(b.id).score - get.getOneMessage(a.id).score 
       || get.getOneMessage(b.id).date.localeCompare(get.getOneMessage(a.id).date) )
    
    }
  }
  
};
</script>

<style lang="scss" scoped>
</style>
