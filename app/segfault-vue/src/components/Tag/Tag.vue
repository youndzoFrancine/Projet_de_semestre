<template>
  <div class="tags">
    <div class="buttons are-small">
      <TagItem v-bind:key="tag.id" v-for="tag in tags" v-bind:tag="tag"/>
    </div>
  </div>
</template>

<script>
import TagItem from "@/components/Tag/TagItem.vue";

export default {
  name: "Tag",
  props: ["tags"],
  components: {
    TagItem
  }
};
</script>

<style>
</style>
