/**
 * Ce fichier gère l'état Vuex dans l'app des discussions
 */

import axios from "axios";

// initial state
const state = {
  discussions: [
//    {
//      id: 1,
//      title: "Avez-vous déjà vu des discussions par défaut?",
//      tags: [
//        {
//          id: 404,
//          nom: "fake",
//          prioritaire: false,
//          rang: 1
//        },
//        {
//          id: 405,
//          nom: "offline",
//          prioritaire: false,
//          rang: 5
//        }
//      ]
//    },
//    {
//      id: 2,
//      title: "Est-ce que quelqu'un sait pourquoi la page ne charge pas?",
//      tags: [
//        {
//          id: 404,
//          nom: "fake",
//          prioritaire: false,
//          rang: 1
//        },
//        {
//          id: 405,
//          nom: "offline",
//          prioritaire: false,
//          rang: 5
//        }
//      ]
//    }
  ],
  currentPage: 0,
  totalPages: 0
};

// getters
const getters = {
  getAllDiscussions: state => state.discussions, // Fonction flêchée qui renvoie les discussions
  getTagsById: state => id => {
    return state.discussions.find(discussion => discussion.id === id).tags;
  },
  getNextPageNb: state => state.currentPage < state.totalPages - 1 ? state.currentPage+1 : null,
  getPrevPageNb: state => state.currentPage > 0 ? state.currentPage - 1 : null
};

// actions
const actions = {
  async fetchDiscussions({ commit, getters, dispatch }, page) {
    
    if (page === null)
      return
    
    await axios
      .get( getters.apiURL + "discussions/all?page=" + page)
      .then(response => {
        console.log(response.data)
        if (response.status == 200) {
//          commit("setDiscussions", response.data);
          commit ("clearDisc")
          commit("clearMsg")
          for (let disc of response.data.content) {
            commit("addDiscussion", {
              id: disc.msgracine.id,
              title: disc.sujet,
              tags: disc.tagList
            })
            commit("pushMsgFamily", disc.msgracine)
          }
          commit ("setDiscPage", {number: response.data.number, totalPages: response.data.totalPages})
          
        } else {
          dispatch("displayError", "error while fetching discussions.")
        }

      })
      .catch(error => {
        console.log(error);
      });
  }
};

// mutations
const mutations = {
  
  setDiscPage: (state, payload) => {
    state.currentPage = payload.number
    state.totalPages = payload.totalPages
  },
  // param: front format of attributes
  addDiscussion: (state, payload) => {state.discussions.push(payload)},
  clearDisc: (state) => state.discussions = []
  
};

export default {
  state,
  getters,
  actions,
  mutations
};
