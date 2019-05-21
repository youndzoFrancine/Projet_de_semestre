/**
 * Ce fichier gère l'état Vuex dans l'app des discussions
 */

import axios from "axios";
// to get the router, not available via this.$router...
import {app} from "@/main"

// initial state
const state = {
  discussions: [],
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
            commit("setMessage", disc.msgracine)
          }
          commit ("setDiscPage", {number: response.data.number, totalPages: response.data.totalPages})
          
        } else {
          dispatch("displayError", "error while fetching discussions.")
        }

      })
      .catch(error => {
        console.log(error);
      });
  },
  async newDiscussion({ commit, getters, dispatch }, { title, text, tags, userId }) {
    
    await axios
      .post( getters.apiURL + "discussions/create", {
        sujet: title,
        contenu: text,
        utilisateurID: userId,
        tags: tags
      })
      .then(response => {
      
        console.log(response.data)
        
        if (response.status != 201) {
          dispatch("displayError", "error while creating discussions." )
        } else {
          commit("resetActive")
          app.$router.go(-1)
        }

      })
      .catch(error => {
        console.log(error);
      });
  },

async getDiscTitle({ commit, getters}, id) {
    
    await axios
      .get( getters.apiURL + "discussions/" + id)
      .then(response => {
      
        console.log(response.data)
        
        if (response.status == 200) {
          commit("addDiscussion", {id: id, title: response.data})
        } else {
          commit("addDiscussion", {id: id, title: ""})
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
