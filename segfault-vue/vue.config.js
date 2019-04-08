/* Permet de charger le scss globale */
module.exports = {
  css: {
    loaderOptions: {
      sass: {
        data: `@import "@/assets/index.scss";`
      }
    }
  }
};
