<template>
  <nav class="navbar" role="navigation" aria-label="main navigation">
    <div class="navbar-brand">
      <a class="navbar-item" href>
        <h1 class="title is-2 logo">Segfault</h1>
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

    <div class="container">
      <NavSearchbar/>
    </div>

    <NavLogZone/>
  </nav>
</template>

<script>
import NavSearchbar from "@/components/Navbar/NavSearchbar.vue";
import NavLogZone from "@/components/Navbar/NavLogZone.vue";

export default {
  name: "Navbar",
  components: {
    NavSearchbar,
    NavLogZone
  }
};
</script>

<style lang="scss" scoped>
.logo {
  font-weight: 900;
  background: $gradient-sunrise;
  background-clip: text;
  -webkit-text-fill-color: transparent;
}

.navbar {
  padding: 10px;
}
</style>
