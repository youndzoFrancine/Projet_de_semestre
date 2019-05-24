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
        <div id=feedback :class="displErrMsg? 'visible' : 'hidden'">{{errorMessage}}</div>
      </div>
      <!-- Pied de page -->
      <div class="hero-foot"></div>
    </section>
  </div>
</template>

<script>
import TheNavbar from "@/components/Navbar/TheNavbar.vue";
import TheSidemenu from "@/components/TheSidemenu.vue";
import { mapGetters } from "vuex";

export default {
  name: "App",
  components: {
    TheNavbar,
    TheSidemenu
  },
  computed: mapGetters(["displErrMsg", "errorMessage"]),
  beforeCreate() {
    if (localStorage.getItem('jwt') != null) {
       // TODO: check validity of jwt, when we have a route to do it...
      // (method to do in auth.js)
      this.$store.commit("login", {user: JSON.parse(localStorage.getItem('user'))})
      this.$store.dispatch("fetchVotes")
    }
  }
};
</script>


<!-- Style gobale de l'app -->
<style lang="scss">
  @import "~bulma/bulma.sass";
  @import "@/assets/index.scss";
  #feedback {position:fixed; bottom: 10px; right: 10px; padding: 10px; border-radius: 20px; background: #000a; width: 25vw; box-shadow: 1px 2px 6px black; color: white; }
  .hidden {visibility: hidden; opacity: 0; transition: visibility 0s 2s, opacity 2s linear;}
  .visible {visibility: visible; opacity: 1; transition: opacity .2s linear;}
  .right {float: right;}
  .content{padding: 10px;}
  .teacher {background-color: rgba(0,200,0,0.1);}
  .user {background-color: rgba(150,150,200,0.1)}
  .green {background-color: rgba(0,200,0,0.5);}
  .red {background-color: rgba(200,0,0,0.5);}
</style>