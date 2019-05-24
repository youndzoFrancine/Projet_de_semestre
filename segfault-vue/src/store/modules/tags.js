/**
 * Ce fichier gère l'état Vuex dans l'app des tags
 */

import axios from "axios";

// initial state
const state = {
  tags: []
};

// getters
const getters = {
  getAllTags: state => state.tags, // Fonction flêché qui renvoie les tags
  getActivatedTags: state => {
    let active = []
    for (let tag of state.tags)
      if (tag.isActive) 
        active.push(tag)
//    console.log("activated tags: "+active)
    return active
  }
};

// actions
const actions = {
  
  async fetchTags({ getters, commit, dispatch }) {
    await axios
      .get( getters.apiURL + "tags/all")
      .then(response => {
        if (response.status == 200) {
          commit("setTags", response.data);
        } else {
          dispatch("displayError", "error while fetching tags.")
        }
      })
      .catch(error => {
        console.log(error);
        dispatch("displayError", "error while fetching tags.")
      });
  },

  // method to add tags, they arrive as a string separated with #. Whites spaces are removed.
  async addTags ({ getters, commit, dispatch}, tags) {    
    
    const tagsTab = tags.replace(/\s/g,'').split('#')
    
    for (let newTag of tagsTab) {
      if (newTag != "")

        await axios.post( getters.apiURL + "tags/create", {
         nom: newTag,
         prioritaire: false,
         rang: 1
        })
        .then(response => {
//          console.log(response.data)
          if (response.status == 201) {
            commit("addTag", {name: newTag, id: response.data})
          } 
          else {
            dispatch("displayError", "tags could not be sent to backend.")
          }
        })
        .catch(error => {
          console.log(error);
          dispatch("displayError", "tags could not be sent to backend.")
        });
    }
  }
};

// mutations
const mutations = {
  setTags: (state, payload) => {
//    state.tags = payload
    state.tags = []
    for (let tag of payload)
      state.tags.push({id:tag.id, nom: tag.nom, prio:tag.prio, rank: tag.rank, isActive: false});
    state.tags.sort((a,b) => b.rank - a.rank || a.nom.localeCompare(b.nom) )
    state.nextNum = state.tags.length

  },
  //TODO: add tag only if not already present
  addTag: (state, tag) => {
    state.tags.push({id: tag.id, nom: tag.name, prio:false, rank: 1, isActive: true});
  },
  clicTag: (state, tag) => {
    tag.isActive = !tag.isActive;
  },
  resetActive: state => {for (let tag of state.tags) tag.isActive = false;}
  
};

export default {
  state,
  getters,
  actions,
  mutations
};
