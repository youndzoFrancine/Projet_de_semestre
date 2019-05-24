/**
 * Ce fichier gère l'état Vuex dans l'app de l'authentification
 */


// initial state
const state = {
  //token: localStorage.getItem("user-token") || "",

  auth: false,
  user: {}
  
};

// getters
const getters = {
  //isAuthenticated: state => !!state.token,
  //authStatus: state => state.status
  isAuthenticated: state => state.auth,
  user: state => state.user
};

// actions
const actions = {
  // TODO: this action should ~ check jwt, call login and fetch votes.
  // localstorage can be set only in connexion and here (called from app)
  // user is not needed in localStorage if we can validate the jwt api side...
//  getUserAndLogin: ({ commit }, jwt) => {
//
//  }
};

// mutations
const mutations = {
//  setAuthStatus: (state, payload) => (state.auth = payload),
  
  login: (state, {jwt, user}) => {

    if (jwt) {
      localStorage.setItem('jwt', jwt)
      localStorage.setItem('user', JSON.stringify(user))
    }
    state.user = user
    state.auth = true
  },
  logout: (state) => {

    state.auth = false
    state.user = {}
    localStorage.removeItem('jwt')
    localStorage.removeItem('user')
    localStorage.removeItem('savedDisc')
  }
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
