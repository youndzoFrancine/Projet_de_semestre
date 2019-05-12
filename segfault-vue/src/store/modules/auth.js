/**
 * Ce fichier gère l'état Vuex dans l'app de l'authentification
 */

// initial state
const state = {
  //token: localStorage.getItem("user-token") || "",
  //status: ""
  auth: false,
    // TODO: remettre à "" comme valeur init
  username: "test",
  role: ""
};

// getters
const getters = {
  //isAuthenticated: state => !!state.token,
  //authStatus: state => state.status
  isAuthenticated: state => state.auth,
  user: state => state.username
};

// actions
const actions = {
  changeStatus: ({ commit }) => {
    commit("setAuthStatus", !state.auth);
  }
};

// mutations
const mutations = {
  setAuthStatus: (state, payload) => (state.auth = payload)
};

export default {
  state,
  getters,
  actions,
  mutations
};

/**
 * source:
 * https://blog.sqreen.com/authentication-best-practices-vue/
 * https://stackblitz.com/edit/vue-vuex-jwt-authentication-example?file=_store%2Findex.js
 * https://scotch.io/tutorials/handling-authentication-in-vue-using-vuex
 */
