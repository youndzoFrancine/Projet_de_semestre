<template>
  <div class="home">
    <div class="colums">
      <div class="column is-9">
        <Discussion/>
      </div>
    </div>
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
