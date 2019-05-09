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
          <router-link to="/message">
            <p>{{post.sujet}}</p>
          </router-link>
          <p>
            <small>
              <strong>posté par @{{post.utilisateur.nomUtilisateur}}</strong>
              dernière réponse 14 avril
            </small>
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
          <button class="button purple is-small">10 réponses</button>
          <button class="button purle is-small is-outlined">100 vues</button>
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
