<template>
  <div class="home">
    <Discussion/>
  </div>
</template>

<script>
// @ is an alias to /src
import Discussion from "@/components/Discussion/TheDiscussion.vue";

export default {
  name: "home",
  components: {
    Discussion
  }
};
</script>
