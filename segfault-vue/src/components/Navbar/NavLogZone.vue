<template>
  <div class="navbar-end logzone">
    <div class="navbar-item">
      <p v-if="isAuthenticated">Connecté en tant que FAKE_USER</p>
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
  methods: {},
  computed: mapGetters(["isAuthenticated"])
};
</script>

<style lang="scss" scoped>
</style>
