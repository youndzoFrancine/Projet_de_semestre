<template>
  <form id="Inscription">
    <div class="Inscription">
      <h1 class="title">Inscription</h1>
    </div>

      
      <!--email-->
      <div class="field">
              <label class="label">Email</label>
           <template v-if="emailInputErrors">
          <div class="field has-addons">
          <div class="control is-expanded  has-icons-left has-icons-right has-addons" type="email" >
               <input
            class="input is-danger"
            v-model="email"
            id="email"
            type="text"
            placeholder="prenom.nom"
            v-on:input="emailInputControl"       
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
    </a> -->
  </p>
  </div>
        <p class="help is-danger">{{emailInputErrors}}</p>
        </template>
      <template v-else>
                    <div class="field has-addons">
             <div class="control is-expanded has-icons-left has-icons-right" type="email" >
               <input
            class="input is-success"
            v-model="email"
            id="email"
            type="text"
            placeholder="prenom.nom"
            v-on:input="emailInputControl"
          >
          <!--C'est lors du focus sur email qu'on verifie l'username evite de faire trop d'appelle a la bd-->
          <span class="icon is-small is-left">
            <font-awesome-icon icon="envelope"/>
          </span>
         
           <span class="icon is-small is-right">
<font-awesome-icon icon="check"/>
       </span>
        </div>
        <!--
          <a class="button is-static">
     <font style="text-transform: lowercase;"> @heig-vd.ch</font>
    </a> -->
                    </div>
            </template>
      </div>

<!--username-->
       <div id="username" class="field">
       <label class="label">Nom d'utilisateur</label>
       <template v-if="UserInputErrors">
         <div class="control has-icons-left has-icons-right">
          <input
            class="input is-danger"
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
            <font-awesome-icon icon="exclamation"/>
          </span>
         </div>
        <p class="help is-danger">{{UserInputErrors}}</p>
       </template>

      <template v-else>
  <div class="control has-icons-left has-icons-right">
          <input
            class="input is-success"
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
<font-awesome-icon icon="check"/>
       </span>

         </div>
      </template>

      <!--mot de pass entrer-->
      <div class="field">
        <label class="label">Mot de passe</label>

          <template v-if="passwordInputErrors == null">
        <div class="control has-icons-left">
           <input
            class="input is-success"
            v-model="password"
            id="password"
            type="password"
            placeholder="password"
            v-on:input="passwordBasicTcheck"       
          >
          <span class="icon is-small is-left">
             <font-awesome-icon icon="lock"/>
           </span>
           
        </div>
          </template>
          <template v-else>
            <!-- non utiliser pour le moment (mdp trop court ou autre)-->
          <div class="control has-icons-left">
            <input
            class="input is-danger"
            v-model="password"
            id="password"
            type="password"
            placeholder="password"
            v-on:input="passwordBasicTcheck"       
          >
          <span class="icon is-small is-left">
             <font-awesome-icon icon="lock"/>
           </span>

        </div>
          </template>
        
        <div class="control">
       <!--mot de pass verification -->
        <label class="label">Retapez votre mot de passe</label>
        <template v-if="passwordInputErrors == null">
           <div class="control has-icons-left">
            <input
            class="input is-success"
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
        </template>
        <template v-else>
           <div class="control has-icons-left">
            <input
            class="input is-danger"
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
           <p class="help is-danger">{{passwordInputErrors}}</p>

        </template>

        <!-- terms and conditions-->
        <div class="field">
  <div class="control">
    <label class="checkbox">
      <input type="checkbox" v-model="terms">
      I agree to the <a href="#">terms and conditions</a>
    </label>
    <template v-if="termsErrors">
    <p class="help is-danger">Veuillez accepter les conditions</p>
    </template>
  </div>
</div>
<!--login-->
<div class="columns">
  <div class= "column">

  <p class="control">
    <button class="button is-success"
    v-on:click ="registration">
      register
    </button>
  </p>
  <template v-if="RegistrationFaillure">
    <p class="help is-danger">{{RegistrationFaillure}}</p>
  </template>
    </div>
  <div class= "column">
  <label class="label">Déjà un compte?</label>
  <p> <a href="Home"> se connecter </a></p>
  </div>
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
      UserInputErrors: null,
      user: new String(),
      emailInputErrors: null,
      email : null,
      password: new String(),
      passwordTcheck : new String(),
      passwordInputErrors: null,
      booleanChangeFocus: new Boolean(false),
      RegistrationFaillure: null,
      terms : null,
      termsErrors: null
    };
  },
  methods: {
    UserInputControl: function(e) {
      console.log("call UserInputControl function");
      //cancel auto-completion
      this.cancelAutoCompletion();
      let test;
      test = this.user.split(' ');
      if(test[1]){
        this.UserInputErrors ="espace blanc interdit";
      } else if (user.length <5){
        this.UserInputErrors= "plus de 5 caractères requis";
      } else if (this.user=="Admin") {
        /* appel a la bd*/
        this.UserInputErrors = "This pseudo is already taken";
      } else {
        this.UserInputErrors = null;
      }
      e.preventDefault();
    },
    emailInputControl: function(e){
      console.log("call emailInputcontrol function");
      let split = this.email.split('@');
      console.log(split[0]);
      console.log(split[1]);
      this.user = split[0];
      this.UserInputErrors = null;
      if (split[1]!="heig-vd.ch"){
        console.log("parse @");
        this.emailInputErrors = "Seul les adresses finnisant par @heig-vd.ch sont autorise";
      } else if (this.email == "root.admin@heig-vd.ch"){
        /* appel a la bd*/
        this.emailInputErrors = "cette adresse mail est déjà prise";
      } else {
        this.emailInputErrors = null;
      }
      e.preventDefault();
    },
    passwordInputControl: function(e){
      console.log("call passwordInputControl function");
      if(this.passwordTcheck != this.password){
        this.passwordInputErrors = "mot de passe different";
      } else {
        this.passwordInputErrors = null;
      }
    },
    passwordBasicTcheck:function(e){
      console.log("call passwordBasicTcheck");
      this.passwordTcheck.split(' ');
      if (this.password.length < 6 ){
        console.log("taille pas assez importante");
        this.passwordInputErrors = "plus de 6 caractères sont demander";
        
      } else {
        this.passwordInputControl();
      }
    },
    cancelAutoCompletion:function(e){
      console.log("call cancelAutoCompletion");
      this.booleanChangeFocus = true;
    },registration: function(e){
      console.log("call registration");
      let mistake = new Boolean(false);
 
      if ((this.passwordInputErrors==null && this.emailInputErrors==null && this.UserInputErrors==null)){
      if ( this.email==null){
        this.emailInputErrors = "champs non rempli";
        mistake = true;
      } 
       if (this.password==null){
        this.passwordInputErrors = "champs non rempli";
        mistake = true;
      } 
       if (this.user==null){
        this.UserInputErrors = "champs non rempli";
        mistake = true;
      }
      if (this.terms == null){
        this.termsErrors = "true";
        mistake = true;
      } else {
        this.termsErrors= null;
      }
      if (mistake==true){
        console.log("mistake");
          this.RegistrationFaillure = "tout les champs ne sont pas rempli correctement";

      } else {
          /*enregistrement dans la db*/
      this.RegistrationFaillure =null;
      return;
      }
   }
       else {
          this.RegistrationFaillure = "tout les champs ne sont pas rempli correctement";
      }

    }
  }
};
</script>