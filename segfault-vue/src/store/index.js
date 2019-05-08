import Vue from "vue";
import Vuex from "vuex";
import discussions from "./modules/discussions";

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    discussions
  }
});
