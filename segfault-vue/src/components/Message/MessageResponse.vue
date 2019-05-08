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
            <a>Like</a> ·
            <a>Reply</a> · 2 hrs
          </small>
        </p>
      </div>
    </div>
  </article>
</template>

<script>
export default {
  name: "MessageResponse",
  props: ["unereponse"],
  components: {}
};
</script>

<style>
</style>
