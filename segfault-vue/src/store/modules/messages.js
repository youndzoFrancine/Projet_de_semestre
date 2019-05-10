/**
 * Ce fichier gère l'état Vuex dans l'app des messages
 */

import axios from "axios";

// initial state
const state = {
  message: {
    messageId: 404,
    contenu: "Message en cours de chargement...",
    score: 404,
    MessageSet: []
  }
};

// getters
const getters = {
  getOneMessage: state => state.message // Fonction flêché qui renvoie un message
};

// actions
const actions = {
  async fetchMessage({ commit }) {
    await axios
      .get("http://localhost:8087/messages/1")
      .then(response => {
        if (response.status == 200) {
          commit("setMessage", response.data);
        }
      })
      .catch(error => {
        console.log(error);
      });
  }
};

// mutations
const mutations = {
  setMessage: (state, payload) => (state.message = payload)
};

export default {
  state,
  getters,
  actions,
  mutations
};
