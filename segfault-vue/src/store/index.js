import Vue from "vue";
import Vuex from "vuex";
import discussions from "./modules/discussions";
import tags from "./modules/tags";

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    discussions,
    tags
  }
});
