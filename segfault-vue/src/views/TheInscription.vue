<template>
<form
  id="username"
  @submit="checkForm"
  action="https://vuejs.org/"
  method="post"
>

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

    <div class="columns">
       <div class="column is-1">
        </div>
      <div id="username" class="column is-7"  >
        <label class="label">Username</label>
        <div class="control ">
          <input class="input is-success"  v-model="user" id="user" type="text" placeholder="username"  @change="checkForm">
        </div>
        <p v-if=errors class="help is-success"> {{errors}}</p>
        <p v-else class="help is-success">  test    </p>
      </div>
    </div>

    <!--email-->

 <div class="columns">
       <div class="column is-1">
        </div>
         <div class="column is-4">
        <label class="label">Email</label>
         </div>
 </div>
    <div class="columns">
       <div class="column is-1">
        </div>
      <div class="column is-4">
        <div class="control  has-icons-right">
          <input class="input is-danger" type="text" placeholder="your.heig-vd.mail">
          <span class="icon is-small is-left">
            <i class="fas fa-envelope"></i>
          </span>
          <span class="icon is-small is-right">
            <i class="fas fa-exclamation-triangle"></i>
          </span>
        </div>
  
        <p class="help is-danger">This email is invalid</p>
      </div>
      <div class="column is-2">
        <p>@heig-vd.ch</p>
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
 </form>


</template>
<script>
export default {
  name: "theInscription",
  components: {}, 
   data: function() {
  return {
    errors: null,
    user:null
  }
} , methods :{
checkForm: function (e) {
      console.log("passe par ici");
      this.errors ="bonnn";
      if (this.user=='papa') {
              console.log("papa");
        return true;
      }
      this.errors = null;
      if (!this.user) {
        this.errors='This pseudo is already taken';
      } 
      e.preventDefault();
    }
  }
}

</script>