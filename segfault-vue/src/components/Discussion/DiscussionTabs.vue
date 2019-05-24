<template>
  <div class="discussion-tabs">
    <div class="buttons are-small has-addons">
      trier par:
      <div style="margin: auto;">
        <span class="button" :class="active=='score'? 'is-info':''" @click="clicked('score')">Score</span>
        <span class="button" :class="active=='date'? 'is-info':''" @click="clicked('date')">Date</span>
      </div>
    </div>
  </div>
</template>

<script>
import { mapMutations } from "vuex";

export default { 
  name: "Discussiontabs", 
  data: function () {
    return { active: "score" }
  },
  methods: {
    ...mapMutations(["setSortBy"]),
    clicked: function(type) {
      this.setSortBy(type)
      this.active = type
      if (this.$store.getters.getActivatedTags.length == 0)
        this.$store.dispatch("fetchDiscussions", "last" )
      else
        this.$store.dispatch("fetchByTags")
    }
  }
};
</script>

<style lang="scss" scoped>
</style>


