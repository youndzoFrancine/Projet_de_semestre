/**
 * Ce fichier gère l'état Vuex dans l'app des discussions
 */

import axios from "axios";

// initial state
const state = {
  discussions: [
    {
      id: 1,
      title: "Avez-vous déjà vu des discussions par défaut?",
      tags: [
        {
          id: 404,
          nom: "fake",
          prioritaire: false,
          rang: 1
        },
        {
          id: 405,
          nom: "offline",
          prioritaire: false,
          rang: 5
        }
      ]
    },
    {
      id: 2,
      title: "Est-ce que quelqu'un sait pourquoi la page ne charge pas?",
      tags: [
        {
          id: 404,
          nom: "fake",
          prioritaire: false,
          rang: 1
        },
        {
          id: 405,
          nom: "offline",
          prioritaire: false,
          rang: 5
        }
      ]
    }
  ]
};

// getters
const getters = {
  getAllDiscussions: state => state.discussions, // Fonction flêchée qui renvoie les discussions
  getTagsById: state => id => {
    return state.discussions.find(discussion => discussion.id === id).tags;
  }
};

// actions
const actions = {
  async fetchDiscussions({ commit }) {
    await axios
      .get("http://localhost:8087/discussions/all")
      .then(response => {
        if (response.status == 200) {
          commit("setDiscussions", response.data);
        } else {
          commit();
        }
      })
      .catch(error => {
        console.log(error);
      });
  }
};

// mutations
const mutations = {
  setDiscussions: (state, payload) => {state.discussions = payload},
  
  addDiscussion: (state, payload) => {state.discussions.push(payload); console.log(state)}
  
  
};

export default {
  state,
  getters,
  actions,
  mutations
};
