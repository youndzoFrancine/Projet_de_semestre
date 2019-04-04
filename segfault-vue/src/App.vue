<template>
  <div id="app">
    <section class="hero">
      <!-- Tête -->
      <div class="container has-background-white-bis">
        <div class="hero-head">
          <Navbar/>
        </div>
      </div>
      <!-- Corps -->
      <div class="container has-background-white-bis">
        <div class="hero-body is-fullheight">
          <div class="columns">
            <div class="column is-1">
              <Sidemenu/>
            </div>
            <div class="column">
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
import Navbar from "@/components/Navbar.vue";
import Sidemenu from "@/components/Sidemenu.vue";
export default {
  name: "App",
  components: {
    Navbar,
    Sidemenu
  }
};
</script>


<!-- Style gobale de l'app -->
<style lang="scss">
@import "~bulma/bulma.sass";
@import "@/assets/index.scss";
</style>
