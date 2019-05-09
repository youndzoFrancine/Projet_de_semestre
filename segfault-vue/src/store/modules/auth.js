/**
 * Ce fichier gère l'état Vuex dans l'app de l'authentification
 */

// initial state
const state = {
  token: localStorage.getItem("user-token") || "",
  status: ""
};

// getters
const getters = {
  isAuthenticated: state => !!state.token,
  authStatus: state => state.status
};

// actions
const actions = {};

// mutations
const mutations = {};

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
