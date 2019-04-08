<template>
  <div class="side-tags">
    <h3 class="title is-5">Tags populaires</h3>
    <Tag/>
  </div>
</template>

<script>
import Tag from "@/components/Tag/Tag.vue";

export default {
  name: "TheTag",
  components: {
    Tag
  }
};
</script>

<style>
</style>
