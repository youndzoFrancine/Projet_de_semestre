<template>
  <div class="navbar-end logzone">
    <div class="navbar-item">
      <div class="buttons">
        <router-link to="/connexion" class="button is-primary is-outlined">
          <strong>Connexion</strong>
        </router-link>
        <router-link to="/inscription" class="button is-primary">
          <strong>Inscription</strong>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "LogZone",
  components: {}
};
</script>

<style lang="scss" scoped>
</style>
