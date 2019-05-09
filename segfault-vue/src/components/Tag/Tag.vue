<template>
  <div class="tags">
    <div class="buttons are-small">
      <TagItem v-bind:key="tag.id" v-for="tag in getAllTags" v-bind:tag="tag"/>
    </div>
  </div>
</template>

<script>
import TagItem from "@/components/Tag/TagItem.vue";
// import axios from "axios";
import { mapGetters, mapActions } from "vuex";

export default {
  name: "Tag",
  components: {
    TagItem
  },
  methods: {
    ...mapActions(["fetchTags"])
  },
  computed: mapGetters(["getAllTags"]),
  created() {
    this.fetchTags();
  }
  /*,
  data() {
    return {
      tags: [
        { id: 1, nom: "java" },
        { id: 2, nom: "cpp" },
        { id: 3, nom: "c" },
        { id: 4, nom: "ruby" },
        { id: 5, nom: "python" },
        { id: 6, nom: "haskell" }
      ]
    };
  },
  mounted() {
    axios.get("http://localhost:8087/tags/all").then(response => {
      this.tags = response.data;
    });
  }
  */
};
</script>

<style>
</style>
