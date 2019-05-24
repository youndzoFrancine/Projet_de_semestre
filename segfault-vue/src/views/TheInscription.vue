<template>
  <form id="Inscription">
    <div class="Inscription">
      <h1 class="title">Inscription</h1>
    </div>

    <!--email-->
    <div class="field">
      <label class="label">Email</label>

        <div class="field has-addons">
          <div class="control is-expanded has-icons-left has-icons-right has-addons" type="email">
            <input
              class="input"
              :class="{ 'is-success': !emailInputErrors, 'is-danger': emailInputErrors }"
              v-model="email"
              id="email"
              type="text"
              placeholder="prenom.nom@heig-vd.ch"
              v-on:input="emailInputControl"
              autofocus
            >
            <span class="icon is-small is-left">
              <font-awesome-icon icon="envelope"/>
            </span>
            <span class="icon is-small is-right">
              <font-awesome-icon :icon="emailInputErrors? 'exclamation' : 'check'"/>
            </span>
          </div>
          <p class="control">
            <!--
          <a class="button is-static">
     <font style="text-transform: lowercase;"> @heig-vd.ch</font>
            </a>-->
          </p>
        </div>
        <p v-if="emailInputErrors" class="help is-danger">{{emailInputErrors}}</p>
      
    </div>

    <!--username-->
    <div id="username" class="field">
      <label class="label">Nom d'utilisateur</label>
      <div class="control has-icons-left has-icons-right">
        <input
          class="input"
          :class="{ 'is-success': !userInputErrors, 'is-danger': userInputErrors }"
          v-model="user"
          id="user"
          type="text"
          placeholder="username"
          v-on:input="UserInputControl"
        >
        <span class="icon is-small is-left">
          <font-awesome-icon icon="user"/>
        </span>
        <span class="icon is-small is-right">
          <font-awesome-icon :icon="userInputErrors? 'exclamation' : 'check'"/>
        </span>
      </div>
      <p v-if="userInputErrors" class="help is-danger">{{userInputErrors}}</p>

      <!--mot de passe -->
      <div class="field">
        <label class="label">Mot de passe</label>

        <div class="control has-icons-left">
          <input
            class="input"
            :class="{ 'is-success': !passwordInputErrors, 'is-danger': passwordInputErrors }"
            v-model="password"
            id="password"
            type="password"
            placeholder="password"
            v-on:input="passwordBasicTcheck(); sha256(password)"
          >
          <span class="icon is-small is-left">
            <font-awesome-icon icon="lock"/>
          </span>
        </div>

        <div class="control">
          <!--mot de passe verification -->
          <label class="label">Retapez votre mot de passe</label>
          
          <div class="control has-icons-left">
            <input
              class="input"
              :class="{ 'is-success': !passwordInputErrors, 'is-danger': passwordInputErrors }"
              v-model="passwordTcheck"
              id="passwordTcheck"
              type="password"
              placeholder="password check"
              v-on:input="passwordInputControl"
            >
            <span class="icon is-small is-left">
              <font-awesome-icon icon="lock"/>
            </span>
          </div>
          <p v-if="passwordInputErrors" class="help is-danger">{{passwordInputErrors}}</p>

          <!-- terms and conditions-->
          <div class="field">
            <div class="control">
              <label class="checkbox">
                <input type="checkbox" v-model="terms">
                I agree to the
                <a href="#">terms and conditions</a>
              </label>
              <template v-if="termsErrors">
                <p class="help is-danger">Veuillez accepter les conditions</p>
              </template>
            </div>
          </div>
          <!--login-->
          <div class="columns">
            <div class="column">
              <p class="control">
                <button class="button is-success" v-on:click="registration">register</button>
              </p>
              <template v-if="registrationFailure">
                <p class="help is-danger">{{registrationFailure}}</p>
              </template>
            </div>
            <div class="column">
              <label class="label">Déjà un compte?</label>
              <router-link to="/connexion">
                <p>
                  <a href="TheConnexion">se connecter</a>
                </p>
              </router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
  </form>
</template>




<script>
import axios from "axios"
import { mapGetters, mapActions } from "vuex";

export default {
  name: "theInscription",
  data: function() {
    return {
      userInputErrors: null,
      user: new String(),
      emailInputErrors: null,
      email: null,
      password: new String(),
      passwordTcheck: new String(),
//      hashedPass: new String(),
      passwordInputErrors: null,
      booleanChangeFocus: new Boolean(false),
      registrationFailure: null,
      terms: null,
      termsErrors: null
    };
  },
  computed: {...mapGetters(["apiURL"])},
  methods: {
    ...mapActions(["sha256"]),

    UserInputControl: function(e) {
      this.cancelAutoCompletion();
      let test;
      test = this.user.split(" ");
      if (test[1]) {
        this.userInputErrors = "espace blanc interdit";
      } else if (this.user.length < 5) {
        this.userInputErrors = "plus de 5 caractères requis";
      } else if (this.user == "Admin") {
        /* appel a la bd*/
        this.userInputErrors = "This pseudo is already taken";
      } else {
        this.userInputErrors = null;
      }
      e.preventDefault();
    },
    emailInputControl: function(e) {
      let split = this.email.split("@");
      this.user = split[0];
      this.userInputErrors = null;
      if (split[1] != "heig-vd.ch") {
        this.emailInputErrors =
          "Seul les adresses finnisant par @heig-vd.ch sont autorisées";
      } else if (this.email == "root.admin@heig-vd.ch") {
        /* TODO: call db to check before submiting*/
        this.emailInputErrors = "cette adresse mail est déjà prise";
      } else {
        this.emailInputErrors = null;
      }
      e.preventDefault();
    },
    passwordInputControl: function() {
      if (this.passwordTcheck != this.password) {
        this.passwordInputErrors = "mot de passe différents";
      } else {
        this.passwordInputErrors = null;
      }
    },
    passwordBasicTcheck: function() {
      this.passwordTcheck.split(" ");
      if (this.password.length < 6) {
        this.passwordInputErrors = "6 caractères ou plus sont demandés";
      } else {
        this.passwordInputControl();
      }
    },
    cancelAutoCompletion: function() {
      this.booleanChangeFocus = true;
    },
    registration: async function() {
      let mistake = new Boolean(false);

      if (
        this.passwordInputErrors == null &&
        this.emailInputErrors == null &&
        this.userInputErrors == null
      ) {
        if (this.email == null) {
          this.emailInputErrors = "champ non rempli";
          mistake = true;
        }
        if (this.password == null) {
          this.passwordInputErrors = "champ non rempli";
          mistake = true;
        }
        if (this.user == null) {
          this.userInputErrors = "champ non rempli";
          mistake = true;
        }
        if (this.terms == null) {
          this.termsErrors = "true";
          mistake = true;
        } else {
          this.termsErrors = null;
        }
        if (mistake == true) {
          this.registrationFailure =
            "tous les champs ne sont pas remplis correctement";
        } else {
          /*enregistrement dans la db*/
          await axios
            .post( this.apiURL + "utilisateurs/signup", {
              nomUtilisateur: this.user,
              mailUtilisateur: this.email,
              motDePasse: this.$store.getters.hashedPass,
            })
            .then(response => {
              if (response.status == 201) {
                this.registrationFailure = null;
                this.$store.commit("login", {jwt: response.data.token, user: response.data.user})
                this.$router.go(-1);
              }
              else {
                console.log( "this never happens.")
              }
            })
            .catch(error => {
              console.log(error.response);
              this.$store.dispatch("displayError", "error: " + error.response.data)
              this.registrationFailure = "pb d'accès à l'api."
            }
          );
          
        }
      } else {
        this.registrationFailure =
          "tous les champs ne sont pas remplis correctement";
      }
    }
  }
};
</script>