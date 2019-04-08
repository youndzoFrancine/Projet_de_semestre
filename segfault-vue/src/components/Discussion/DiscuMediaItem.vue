<template>
  <div>
    <article class="media">
      <figure class="media-left">
        <p class="image is-64x64">
          <img src="https://bulma.io/images/placeholders/128x128.png">
        </p>
      </figure>
      <div class="media-content">
        <div class="content">
          <p>{{post.title}}</p>
          <p>
            <strong>posté par @shellmaster</strong>
          </p>
          <p>
            <small>dernière réponse 14 avril</small>
          </p>
        </div>
        <nav class="level is-mobile">
          <div class="level-left">
            <a class="level-item">
              <span class="icon is-small">
                <i class="fas fa-reply"></i>
              </span>
            </a>
            <a class="level-item">
              <span class="icon is-small">
                <i class="fas fa-retweet"></i>
              </span>
            </a>
            <a class="level-item">
              <span class="icon is-small">
                <i class="fas fa-heart"></i>
              </span>
            </a>
          </div>
        </nav>
      </div>
      <div class="media-right">
        <div class="buttons">
          <button class="button is-warning is-small is-fullwidth">10 réponses</button>
          <button class="button is-warning is-small is-outlined is-fullwidth">100 vues</button>
        </div>
      </div>
    </article>
  </div>
</template>

<script>
export default {
  name: "DiscuMediaItem",
  props: ["post"]
};
</script>

<style lang="scss" scoped>
</style>
