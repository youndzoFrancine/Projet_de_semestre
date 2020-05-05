/**
 * Ce fichier gère l'état Vuex dans l'app des discussions
 */

import axios from "axios";

// initial state
const state = {
  discussions: [
    {
      id: 1,
      sujet: "Avez-vous déjà vu des discussions par défaut?",
      utilisateur: { nomUtilisateur: "Shellmaster" },
      msgracine: { dateCreation: "January 1, 1995 01:02:03", score: 404 },
      tagSet: [
        {
          tagId: 404,
          nom: "fake",
          prioritaire: false,
          rang: 1
        },
        {
          tagId: 405,
          nom: "offline",
          prioritaire: false,
          rang: 5
        }
      ]
    },
    {
      id: 2,
      sujet: "Est-ce que quelqu'un sait pourquoi la page ne charge pas?",
      utilisateur: { nomUtilisateur: "Shellmaster" },
      msgracine: { dateCreation: "January 1, 1995 01:02:03", score: 404 },
      tagSet: [
        {
          tagId: 404,
          nom: "fake",
          prioritaire: false,
          rang: 1
        },
        {
          tagId: 405,
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
  getAllDiscussions: state => state.discussions, // Fonction flêché qui renvoie les discussions
  getTagsById: state => id => {
    return state.discussions.find(discussion => discussion.id === id).tagSet;
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
  setDiscussions: (state, payload) => (state.discussions = payload)
};

export default {
  state,
  getters,
  actions,
  mutations
};
