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
  },
  computed:{
    getActivatedTags: function() {
      let active = []
      for (let tag of this.$children)
        if (tag.isActive) 
          active.push({nom: tag.tag.nom})
        
//      console.log("activated tags: "+active)
      return active
    }
  }
};
</script>

<style>
</style>
