<template>
  <div class="navbar-end logzone">
    <div class="navbar-item">
      <div v-if="isAuthenticated" class="buttons">
        <div>Connecté en tant que FAKE_USER</div>
        <router-link
          to="/"
          v-on:click="seDeconnecter"
          class="button is-primary is-outlined"
        >Se déconnecter</router-link>
      </div>
      <div v-else class="buttons">
        <router-link to="/connexion" class="button is-primary is-outlined">Connexion</router-link>
        <router-link to="/inscription" class="button is-primary">Inscription</router-link>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "LogZone",
  components: {},
  methods: {
    seDeconnecter: () => {
      this.$store.dispatch("changeStatus");
    }
  },
  computed: mapGetters(["isAuthenticated"])
};
</script>

<style lang="scss" scoped>
</style>
