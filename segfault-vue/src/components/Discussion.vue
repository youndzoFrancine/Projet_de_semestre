<template>
  <div class="discussion">
    <h1>Dernières questions</h1>
    <div class="holder">
      <ul>
        <li v-for="(data, index) in questions" :key="index">{{index}}. {{data.question}}</li>
      </ul>

      <p>{{info}}</p>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Discussion",
  data() {
    return {
      questions: [{ question: "Comment?" }, { question: "Pourquoi?" }],
      info: null
    };
  },
  mounted() {
    axios
      .get("http://localhost:8080/discussions/all")
      .then(response => (this.info = response))
      .catch(error => console.log(error));
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
