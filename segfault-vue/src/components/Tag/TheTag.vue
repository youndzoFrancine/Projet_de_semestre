<template>
  <div class="side-tags">
    <h3 class="title is-5">Tags populaires</h3>
    <Tag v-bind:tags="getAllTags"/>
  </div>
</template>

<script>
import Tag from "@/components/Tag/Tag.vue";
import { mapGetters, mapActions } from "vuex";

export default {
  name: "TheTag",
  components: {
    Tag
  },
  methods: {
    ...mapActions(["fetchTags"])
  },
  computed: mapGetters(["getAllTags"]),
  created() { 
    this.fetchTags();
  }
};
</script>

<style>
</style>
