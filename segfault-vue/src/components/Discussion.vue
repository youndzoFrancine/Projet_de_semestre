<template>
  <div class="discussion">
    <h1>Dernières questions</h1>
    <div class="holder">
      <ul>
        <li v-for="(data, sujet) in discu" :key="sujet">{{sujet}}. {{data.sujet}}</li>
      </ul>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Discussion",
  data() {
    return {
      discu: []
    };
  },
  mounted() {
    axios
      .get("http://localhost:8087/discussions/all")
      .then(response => (this.discu = response.data))
      .catch(error => console.log(error));
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
