<template>
  <form id="username" @submit="checkForm" method="post">
    <div class="Insciption">
      <h1 class="title">Inscription</h1>

      <!--name-->
      <label class="label">Name</label>
      <div id="name" class="control">
        <input class="input" type="text" placeholder="name">
      </div>

      <!--username-->

      <div id="username">
        <label class="label">Username</label>
        <div class="control">
          <input
            class="input is-success"
            v-model="user"
            id="user"
            type="text"
            placeholder="username"
            v-on:input="checkForm"
          >
        </div>
        <p v-if="errors" class="help is-danger">{{errors}}</p>
        <p v-else class="help is-success">test</p>
      </div>

      <!--email-->
      <label class="label">Email</label>

      <div class="field is-grouped">
        <div class="control has-icons-right">
          <input class="input is-danger" type="text" placeholder="your.heig-vd.mail">
          <span class="icon is-small is-left">
            <i class="fas fa-envelope"></i>
          </span>
          <span class="icon is-small is-right">
            <i class="fas fa-exclamation-triangle"></i>
          </span>

          <p class="help is-danger">This email is invalid</p>
        </div>
        <p>@heig-vd.ch</p>
      </div>

      <!--mot de pass-->
      <label class="label">Mot de passe</label>
      <div class="control">
        <input class="input is-danger" type="email" placeholder="password">
      </div>
      <div class="control">
        <label class="label">Retaper votre mot de passe</label>
        <input class="input is-danger" type="email" placeholder="password tcheck">
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
    checkForm: function(e) {
      console.log("call checkform control");
      this.errors = "bonnn";
      if (this.user == "papa") {
        console.log("papa");
        return true;
      }
      this.errors = null;
      if (!this.user) {
        this.errors = "This pseudo is already taken";
      }
      e.preventDefault();
    }
  }
};
</script>