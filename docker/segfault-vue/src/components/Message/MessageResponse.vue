<template>
  <article class="media">
    <figure class="media-left">
      <p class="image is-48x48">
        <img src="https://bulma.io/images/placeholders/96x96.png">
      </p>
    </figure>
    <div class="media-content">
      <div class="content">
        <p>
          <strong>Some user</strong>
          <br>
          {{unereponse.contenu}}
          <br>
          <small>
            <a>++Vote</a> ·
            <a>Vote--</a> ·
            <a>Répondre</a>
            ·
            Réponse
            <!-- {{message.dateCreation}} -->
          </small>
        </p>
      </div>
    </div>
  </article>
</template>

<script>
  
  // ce module sert à rien, on réutilise messageItem pour les réponses
export default {
  name: "MessageResponse",
  props: ["unereponse"],
  components: {}
};
</script>

<style>
</style>
