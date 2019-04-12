<template>
  <div class="logzone">
    <div id="navbarBasicExample" class="navbar-menu">
      <div class="navbar-start"></div>

      <div class="navbar-end">
        <div class="navbar-item">
          <div class="buttons">
            <a class="button is-primary is-outlined">Connexion</a>
            <router-link to="/TheInscription">
              <a class="button is-primary">
                <strong>Inscription</strong>
              </a>
            </router-link>
          </div>
        </div>
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
