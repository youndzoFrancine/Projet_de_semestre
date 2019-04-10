<template>
  <div class="home columns">
    <div class="column">
      <Discussion/>
    </div>
    <div class="column is-3">
      <TheTag/>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import Discussion from "@/components/Discussion/TheDiscussion.vue";
import TheTag from "@/components/Tag/TheTag.vue";

export default {
  name: "home",
  components: {
    Discussion,
    TheTag
  }
};
</script>
