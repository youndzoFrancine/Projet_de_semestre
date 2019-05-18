import Vue from "vue";
import Vuex from "vuex";
import discussions from "./modules/discussions";
import tags from "./modules/tags";
import message from "./modules/messages";
import auth from "./modules/auth";
import tools from "./modules/tools";

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    discussions,
    tags,
    message,
    auth,
    tools
  }
});
