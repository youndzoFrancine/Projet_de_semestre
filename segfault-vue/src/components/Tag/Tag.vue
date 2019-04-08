<template>
  <div class="tags">
    <div class="buttons">
      <TagItem v-bind:key="tag.id" v-for="tag in tags" v-bind:tag="tag"/>
    </div>
  </div>
</template>

<script>
import TagItem from "@/components/Tag/TagItem.vue";

export default {
  name: "Tag",
  components: {
    TagItem
  },
  data() {
    return {
      tags: [
        { id: 1, name: "java" },
        { id: 2, name: "cpp" },
        { id: 3, name: "c" },
        { id: 4, name: "ruby" },
        { id: 5, name: "python" },
        { id: 6, name: "haskell" }
      ]
    };
  }
};
</script>

<style>
</style>
