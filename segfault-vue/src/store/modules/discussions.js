/**
 * Ce fichier gère l'état Vuex dans l'app
 */

import axios from "axios";

// initial state
const state = {
  discussions: [
    {
      id: 1,
      sujet: "Avez-vous déjà vu des discussions par défaut?",
      utilisateur: { nomUtilisateur: "Shellmaster" }
    },
    {
      id: 2,
      sujet: "Est-ce que quelqu'un sait pourquoi la page ne charge pas?",
      utilisateur: { nomUtilisateur: "Shellmaster" }
    }
  ]
};

// getters
const getters = {
  getAllDiscussions: state => state.discussions // Fonction flêché qui renvoie les discussions
};

// actions
const actions = {
  async fetchDiscussions({ commit }) {
    const response = await axios.get("http://localhost:8087/discussions/all");

    if (response.status == 200) {
      commit("setDiscussions", response.data);
    }
  }
};

// mutations
const mutations = {
  setDiscussions: (state, payload) => (state.discussions = payload)
};

export default {
  state,
  getters,
  actions,
  mutations
};
