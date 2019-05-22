<template>
  <div class="navbar-end logzone">
    <div class="navbar-item">
      <p class="buttons" v-if="isAuthenticated">Connecté en tant que {{user.nomUtilisateur}}&nbsp;&nbsp; 
        <router-link :to="{path: '/user/'+user.utilisateurID}" class="button is-primary">Profil</router-link>
        <span  class="button is-primary" @click="disconnect"> déco </span>
      </p>
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
    disconnect () {this.$store.commit("logout")}
  },
  computed: mapGetters(["isAuthenticated","user"])

};
</script>

<style lang="scss" scoped>
</style>
