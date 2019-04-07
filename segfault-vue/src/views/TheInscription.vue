<template>


 <div class="Insciption">
   <!--name-->
      <div class="columns">
        <div class="column is-1">
        </div>
        <div class="column is-7"  >
          <label class="label">Name</label>
          <div id="name" class="control">
            <input class="input" type="text" placeholder="name">
          </div>
        </div>
      </div>

 
    <!--username-->
<form
  id="username"
  @submit="checkForm"
  action="https://vuejs.org/"
  method="post"
>
    <div class="columns">
       <div class="column is-1">
        </div>
      <div id="username" class="column is-7"  >
        <label class="label">Username</label>
        <div class="control ">
          <input class="input is-success" id="user" type="text" placeholder="username">
        </div>
        <p v-if="errors" class="help is-success">
            errors
        </p>

        <p v-else class="help is-success">  test    </p>
      </div>
    </div>

 </form>


    <!--email-->
    <div class="columns">
       <div class="column is-1">
        </div>
      <div class="column is-7">
        <label class="label">Email</label>
        <div class="control has-icons-left has-icons-right">
          <input class="input is-danger" type="email" placeholder="Email input" value="@heig-vd.ch">
          <span class="icon is-small is-left">
            <i class="fas fa-envelope"></i>
          </span>
          <span class="icon is-small is-right">
            <i class="fas fa-exclamation-triangle"></i>
          </span>
         
        </div>
      

        <p class="help is-danger">This email is invalid</p>
      </div>
    </div>
 
 
 <!--mot de pass-->
    <div class="columns">
       <div class="column is-1">
        </div>
      <div class="column is-7">
        <label class="label">Mot de passe</label>
        <div class="control">
          <input class="input is-danger" type="email" placeholder="password">
        </div>
         <div class="control">
          <label class="label"> Retaper votre mot de passe</label>
          <input class="input is-danger" type="email" placeholder="password tcheck">
        </div>
        <p class="help is-danger">mot de passe différent</p>
      </div>
    </div>
 
 
  </div>   
</template>

<script>

const username = new Vue({
  el: '#username',
  data: {
    errors: null,
    user: null,
    
  },
  methods:{
    checkForm: function (e) {
      if (this.user) {
        return true;
      }

      this.errors = null;

      if (!this.user) {
        this.error ='This pseudo is already taken' ;
      }
      e.preventDefault();
    }
  }
})







</script>