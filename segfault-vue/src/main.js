import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store/index.js";

import { library } from "@fortawesome/fontawesome-svg-core";
import {
  faCheck,
  faEnvelope,
  faUser,
  faSearch,
  faCoffee,
  faLock,
  faExclamation,
  faArrowUp,
  faArrowDown
} from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";

library.add(
  faCoffee,
  faSearch,
  faEnvelope,
  faUser,
  faCheck,
  faLock,
  faExclamation,
  faArrowUp,
  faArrowDown
);

Vue.component("font-awesome-icon", FontAwesomeIcon);

Vue.config.productionTip = false;

export const app = new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");


