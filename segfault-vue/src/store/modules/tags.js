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
        active.push({nom: tag.nom})
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
    
  async addTags ({ getters}, tags) {
    
    await axios
      .post( getters.apiURL + "tags/add", {
        jwt: "20b0a876f1f3e",
        tags: tags
      })
      .then(response => {
        if (response.status != 200) {
          console.log("pas marche.")
        }
      })
      .catch(error => {
        console.log(error);
      });
  }
};

// mutations
const mutations = {
  //TODO: add tag only if not already present
  setTags: (state, payload) => (state.tags = payload),
    // TODO: edit to push tags to db (local for now)
  addTags: (state, payload) => {
    let nextNum = state.tags.length;
    const table = payload.trim().split(" ");
    table.forEach(newTag => state.tags.push({id: ++nextNum, nom: newTag, isActive: false}) );
//      console.log(state.tags);
  },
  clicTag: (state, payload) => {
    let tag = state.tags.filter(tag =>tag.nom == payload.nom)[0];
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
