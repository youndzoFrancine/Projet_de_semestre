<template>
  <div class="tags">
    <div class="buttons are-small">
<!--      <TagItem v-bind:key="tag.id" v-for="tag in tags" v-bind:tag="tag"/>-->
      <div :key="tag.id" v-for="tag in tags">
        <a
          class="button is-info"
          v-on:click="clickTag(tag.nom)"
          v-bind:class="{'is-outlined':!tag.isActive}"
        >#{{tag.nom}}</a>
      </div>
    </div>
  </div>
</template>

<script>


export default {
  name: "Tag",
  props: ["tags"],
  methods: {
    clickTag(tagName) { this.$store.commit("clicTag", {nom: tagName} ) }
  }
};
</script>

<style lang="scss" scoped>
</style>
