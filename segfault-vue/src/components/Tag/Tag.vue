<template>
  <div class="tags">
    <div class="buttons are-small">
<!--      <TagItem v-bind:key="tag.id" v-for="tag in tags" v-bind:tag="tag"/>-->
      <div class="button" :key="tag.tagId" v-for="tag in tags" :class="[{'is-outlined': !tag.isActive}, tag.prio ? 'is-link': 'is-info' ]" @click="clickTag(tag)">
        <span>#{{tag.nom}}</span>
      </div>
    </div>
  </div>
</template>

<script>


export default {
  name: "Tag",
  props: ["tags"],
  methods: {
    clickTag(tag) { 
      this.$store.commit("clicTag", tag)
      if (this.$store.getters.getActivatedTags.length == 0)
        this.$store.dispatch("fetchDiscussions", "last" )
      else
        this.$store.dispatch("fetchByTags")
    }
  }
};
</script>

<style lang="scss" scoped>
/*  .space-around {padding: 2px;}*/
/*  .prio {border: 3px solid;}*/
</style>
