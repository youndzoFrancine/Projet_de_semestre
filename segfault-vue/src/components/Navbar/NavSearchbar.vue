<template>
  <div class="searchbar">
    <div class="field is-fullwidth is-grouped">
      <div class="control is-expanded has-icons-left">
        <input class="input" type="text" placeholder="Chercher une réponse qui sauve la vie">
        <span class="icon is-small is-left">
          <font-awesome-icon icon="search"/>
        </span>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "NavSearchbar",
  components: {}
};
</script>

<style>
  .searchbar {min-width: 350px; margin: auto;}
</style>
