<template>
  <form id="Connexion">
    <div class="Connexion">
      <h1 class="title">Connexion</h1>
    </div>

    <!--email-->
    <div class="field">
      <label class="label">Email ou nom d'utilisateur</label>
      <div class="field has-addons">
        <div class="control is-expanded has-icons-left has-icons-right has-addons" type="email">
          <input
            class="input is-success"
            v-model="email"
            id="email"
            type="text"
            placeholder="prenom.nom"
          >
          <span class="icon is-small is-left">
            <font-awesome-icon icon="envelope"/>
          </span>
          <span class="icon is-small is-right">
            <font-awesome-icon icon="exclamation"/>
          </span>
        </div>
        <p class="control">
          <!--
          <a class="button is-static">
     <font style="text-transform: lowercase;"> @heig-vd.ch</font>
          </a>-->
        </p>
      </div>
    </div>

    <!--mot de pass entrer-->
    <div class="field">
      <label class="label">Mot de passe</label>

      <div class="control has-icons-left">
        <input
          class="input is-success"
          v-model="password"
          id="password"
          type="password"
          placeholder="password"
        >
        <span class="icon is-small is-left">
          <font-awesome-icon icon="lock"/>
        </span>
      </div>

      <div class="control">
        <!--login-->
        <div class="columns">
          <div class="column">
            <p class="control">
              <button class="button is-success" v-on:click="connexion">connexion</button>
            </p>
            <template v-if="ConnexionError">
              <p class="help is-danger">{{ConnexionError}}</p>
            </template>
          </div>
          <div class="column">
            <label class="label">Pas encore de compte?</label>
            <router-link to="/inscription">
              <p>
                <a>s'inscrire</a>
              </p>
            </router-link>
          </div>
        </div>
      </div>
    </div>
  </form>
</template>


<script>
export default {
  name: "theInscription",
  components: {},
  data: function() {
    return {
      email: null,
      password: null,
      ConnexionError: null
    };
  },
  methods: {
    connexion: function() {
      /* debug console
      console.log("connexion");
      */
      const tentative = new Number(0);
      const sleep = ms => new Promise(res => setTimeout(res, ms));
      /*appel a la bd*/

      if (tentative > 3) {
        this.ConnexionError =
          "attention le nombre de tentative augmente le temps d'attente";
        sleep(200 * tentative);
      } else if (
        this.email === "Admin" ||
        (this.email === "Admin.root@heig-vd.ch" && this.password === "123456")
      ) {
        /* debug console
        console.log("connexion");*/
        /*attention a gerer après la connexion*/
        this.$store
          .dispatch("changeStatus") // Should pass the status in connected
          .then(this.$router.push({ name: "home" }));
      } else {
        ++this.tentative;
      }
    }
  }
};
</script>