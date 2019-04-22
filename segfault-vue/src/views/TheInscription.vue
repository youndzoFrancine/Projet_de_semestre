<template>
  <form id="username" @submit="UserInputControl" method="post">

    <div class="Inscription">
      <h1 class="title">Inscription</h1>
    </div>
      <!--username-->
       <div id="username" class="field">
       <label class="label">Nom d'utilisateur</label>
       <template v-if="errors">
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
         </div>
        <p class="help is-danger">{{errors}}</p>
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
         </div>
      </template>



      <!--email-->
      <div class="field">
        <label class="label">Email</label>
        <div class="control has-icons-left has-icons-right">
          <input class="input is-danger" type="email" placeholder="prenom.nom@heig-vd.ch">
          <span class="icon is-small is-left">
            <font-awesome-icon icon="envelope"/>
          </span>
          <span class="icon is-small is-right">
            <i class="fas fa-exclamation-triangle"></i>
          </span>

          <p class="help is-danger">This email is invalid</p>
        </div>
        <p class="help is-danger">Cet email est invalide</p>
      </div>

      <!--mot de pass-->
      <div class="field">
        <label class="label">Mot de passe</label>
        <div class="control">
          <input class="input is-danger" type="password" placeholder="password">
        </div>
        <div class="control">
          <label class="label">Retapez votre mot de passe</label>
          <input class="input is-danger" type="password" placeholder="password check">
        </div>
        <p class="help is-danger">mot de passe différent</p>
      </div>
      <p class="help is-danger">mot de passe différent</p>
    </div>
  </form>
</template>




<script>
export default {
  name: "theInscription",
  components: {},
  data: function() {
    return {
      errors: null,
      user: null
    };
  },
  methods: {
    UserInputControl: function(e) {
      console.log("call UserInputControl control");
      if (this.user=="Admin") {
        this.errors = "This pseudo is already taken";
      } else {
        this.errors = null;
      }
      e.preventDefault();
    }
  }
};
</script>