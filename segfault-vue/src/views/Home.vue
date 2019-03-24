<template>
  <div class="home">
    <h1>Home</h1>
    <Discussion/>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from "@/components/HelloWorld.vue";
import Discussion from "@/components/Discussion.vue";

export default {
  name: "home",
  components: {
    HelloWorld,
    Discussion
  }
};
</script>
