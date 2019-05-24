<template>
  <a
    class="button is-info"
    v-on:click="clickTag"
    v-bind:class="{'is-outlined':!isActive}"
  >#{{tag.nom}}</a>
</template>

<script>
export default {
  name: "TagItem",
  props: ["tag"],
  data: function() {
    return {
      isActive: false
    };
  },
  methods: {
    clickTag() {
      this.isActive = !this.isActive;
    }
  }
};
</script>

<style lang="scss" scoped>
</style>
