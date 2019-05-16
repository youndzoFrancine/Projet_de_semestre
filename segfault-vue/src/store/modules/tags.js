/**
 * Ce fichier gère l'état Vuex dans l'app des tags
 */

import axios from "axios";

// initial state
const state = {
  tags: [
    { id: 1, nom: "tag", isActive: false },
    { id: 2, nom: "par", isActive: false },
    { id: 3, nom: "defaut", isActive: false },
    { id: 4, nom: "ruby", isActive: false },
    { id: 5, nom: "python", isActive: false },
    { id: 6, nom: "haskell", isActive: false }
  ]
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
  
  async fetchTags({ getters, commit }) {
    await axios
      .get( getters.apiURL + "tags/all")
      .then(response => {
        if (response.status == 200) {
          commit("setTags", response.data);
        }
      })
      .catch(error => {
        console.log(error);
      });
  },

  // method to add tags, they arrive as a string separated with #. Whites spaces are removed.
  async addTags ({ getters, commit, dispatch}, tags) {    
    
    const tagsTab = tags.replace(/\s/g,'').split('#')
    
    /*TODO: need to send tags as array with default values for prio & rank*/
    for (let newTag of tagsTab) {
      await axios.post( getters.apiURL + "tags/create", {
         nom: newTag,
         prioritaire: false,
         rang: 1
      })
      .then(response => {
        console.log(response.data)
        if (response.status == 201) {
          // TODO: send resp.from backend to get good tagId
          commit("addTags", newTag)
        } 
        else {
          dispatch("displayError", "tags could not be sent to backend.")
        }
      })
      .catch(error => {
        console.log(error);
      });
    }
  }
};

// mutations
const mutations = {
  //TODO: add tag only if not already present
  setTags: (state, payload) => {
//    state.tags = payload
    state.tags = []
    for (let tag of payload)
      state.tags.push({id:tag.tagId, nom: tag.nom, prio:tag.prioritaire, rank: tag.rang, isActive: false});
    state.tags.sort((a,b) => b.rank - a.rank)
    state.nextNum = state.tags.length
    console.log(state.tags)
  },

    // TODO prevent adding twice a tag
  addTags: (state, payload) => {
    let nextNum = state.tags.length;
    payload.forEach(newTag => state.tags.push({id: ++nextNum, nom: newTag, prio:false, rank: 0, isActive: true}) );
//      console.log(state.tags);
  },
  clicTag: (state, payload) => {
    let tag = state.tags.filter(tag =>tag.nom == payload.nom)[0];
    console.log(payload, tag)
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
