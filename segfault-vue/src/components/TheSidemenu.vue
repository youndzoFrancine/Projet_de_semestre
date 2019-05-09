  <template>
  <div class="sidemenu">
    <aside class="menu">
      <p class="menu-label">Navigation</p>
      <ul class="menu-list">
        <li>
          <router-link to="/">Accueil</router-link>
        </li>
        <li>
          <router-link to="/">Tags</router-link>
          <!-- Ajouter le lien -->
        </li>
        <li>
          <router-link to="/about">À propos</router-link>
        </li>
      </ul>
    </aside>
  </div>
</template>

<script>
export default {
  name: "Sidemenu",
  components: {}
};
</script>

<style>
</style>
