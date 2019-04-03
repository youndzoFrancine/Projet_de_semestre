<template>
  <nav class="navbar" role="navigation" aria-label="main navigation">
    <div class="navbar-brand">
      <a class="navbar-item" href>
        <h1 class="title is-1 logo">
          <strong>Segfault</strong>
        </h1>
      </a>

      <a
        role="button"
        class="navbar-burger burger"
        aria-label="menu"
        aria-expanded="false"
        data-target="navbarBasicExample"
      >
        <span aria-hidden="true"></span>
        <span aria-hidden="true"></span>
        <span aria-hidden="true"></span>
      </a>
    </div>

    <div class="field">
      <p class="control has-icons-left">
        <input class="input" type="text" placeholder="Chercher une réponse qui sauve la vie">
        <span class="icon is-small is-left">
          <font-awesome-icon icon="search"/>
        </span>
      </p>
    </div>

    <div id="navbarBasicExample" class="navbar-menu">
      <div class="navbar-start"></div>

      <div class="navbar-end">
        <div class="navbar-item">
          <div class="buttons">
            <a class="button is-light">Connexion</a>
            <a class="button is-primary">
              <strong>Inscription</strong>
            </a>
          </div>
        </div>
      </div>
    </div>
  </nav>
</template>

<script>
export default {
  name: "Navbar",
  components: {}
};
</script>

<style lang="scss" scoped>
.logo {
  background: linear-gradient(
    to top,
    $lighter-purple -10%,
    $fusion-red 25%,
    $orange-hibiscus 70%
  );
  background-clip: text;
  -webkit-text-fill-color: transparent;
}

.navbar {
  padding: 10px;
}
</style>
