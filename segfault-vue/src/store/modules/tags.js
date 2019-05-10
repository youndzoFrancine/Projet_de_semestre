/**
 * Ce fichier gère l'état Vuex dans l'app des tags
 */

import axios from "axios";

// initial state
const state = {
  tags: [
    { id: 1, nom: "tag" },
    { id: 2, nom: "par" },
    { id: 3, nom: "defaut" },
    { id: 4, nom: "ruby" },
    { id: 5, nom: "python" },
    { id: 6, nom: "haskell" }
  ]
};

// getters
const getters = {
  getAllTags: state => state.tags // Fonction flêché qui renvoie les tags
};

// actions
const actions = {
  async fetchTags({ commit }) {
    await axios
      .get("http://localhost:8087/tags/all")
      .then(response => {
        if (response.status == 200) {
          commit("setTags", response.data);
        }
      })
      .catch(error => {
        console.log(error);
      });
  }
};

// mutations
const mutations = {
  setTags: (state, payload) => (state.tags = payload)
};

export default {
  state,
  getters,
  actions,
  mutations
};
