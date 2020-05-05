<template>
  <div id="app">
    <section class="hero">
      <!-- Tête -->
      <div class="container has-background-white-bis">
        <div class="hero-head">
          <TheNavbar/>
        </div>
      </div>
      <!-- Corps -->
      <div class="container has-background-white-bis">
        <div class="hero-body is-fullheight">
          <div class="columns">
            <div class="column is-1">
              <TheSidemenu/>
            </div>
            <div class="column is-11">
              <router-view/>
            </div>
          </div>
        </div>
      </div>
      <!-- Pied de page -->
      <div class="hero-foot"></div>
    </section>
  </div>
</template>

<script>
import TheNavbar from "@/components/Navbar/TheNavbar.vue";
import TheSidemenu from "@/components/TheSidemenu.vue";
export default {
  name: "App",
  components: {
    TheNavbar,
    TheSidemenu
  }
};
</script>


<!-- Style gobale de l'app -->
<style lang="scss">
@import "~bulma/bulma.sass";
@import "@/assets/index.scss";
</style>