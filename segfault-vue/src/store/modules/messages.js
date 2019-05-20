/**
 * Ce fichier gère l'état Vuex dans l'app des messages
 */

import axios from "axios";

// initial state
const state = {
    // TODO: pour l'instant il y a plusieurs messages ici pour simuler la db, après on fetchera les messages d'une discussion à la fois maximum.
  messages: [],
  
  votes: [],
  
  // à dégager, c'est la db qui gère ça.
  lastId: 0
};

// getters
const getters = {
  // 
  getOneMessage: state => id => {return state.messages.find(msg => msg.id == id)},
  lastId: state => state.lastId,
  getVote: state => msgId => {return state.votes.find(vote => vote.messageID == msgId)}
};

// actions
const actions = {
  async fetchMessage ({commit, dispatch, getters}, msgNb) {
    await axios
      .get(getters.apiURL + "messages/" + msgNb)
      .then(response => {
        if (response.status == 200) {
          commit("setMessage", response.data);
        } else {
          dispatch("displayError", "error while fetching message.")
        }
      })
      .catch(error => {
        console.log(error);
      });
  },
    async newMessage ({commit, dispatch, getters}, payload) {
//      {newText, parentMsg, userId}
    await axios
      .post(getters.apiURL + "messages/create", {
        contenu: payload.newText,
        messageID: payload.parentMsg,
        utilisateurID: payload.user.utilisateurID
      })
      .then(response => {
        if (response.status == 201) {
          console.log(response.data)
          commit("addMessage", payload);
        } else {
          dispatch("displayError", "error while creating message.")
        }
      })
      .catch(error => {
        console.log(error);
      });
    },
      
    async fetchVotes ({commit, dispatch, getters}) {
      if (!getters.isAuthenticated)
        return
      await axios
      .get(getters.apiURL + "votes/" + getters.user.utilisateurID)
      .then(response => {
        if (response.status == 200) {
          commit("setVotes", response.data);
        } else {
          dispatch("displayError", "error while fetching votes.")
        }
      })
      .catch(error => {
        console.log(error);
      });
    }
};


// fonction dégueu qui parcourt tout l'arbre (sauf les descendants du message parent), mais ça marche ^^ 
// TODO: virer quand on a la db
function addMsgRec (newText, user, parentMsg, currentMsg, newId) {

  if (currentMsg.id == parentMsg) {

      currentMsg.childMsg.push({id: newId, author: user, date: new Date().getTime(), text: newText, score: 100, hasVoted: "no", childMsg: []})
  }
  else {
    for (let message of currentMsg.childMsg) {
      addMsgRec (newText, user, parentMsg, message, newId)
    }  
  }
}

//function sortChildMsgRec (childsTab) {
//  if (childsTab.length != 0) {
//    childsTab.sort((a,b) => { return b.score - a.score || a.date - b.date})
//    for (let child of childsTab)
//      sortChildMsgRec(child.childMsg)
//  }
//}

// mutations
const mutations = {
  setMessage: (state, payload) => (state.messages.push(payload)),
  addMessage: (state, {newText, user, parentMsg}) => {
//    if (parentMsg == null) // new discussion
//      state.messages.push({id: ++state.lastId, author: user, date: new Date().getTime() , text: newText, score: 0, hasVoted: "no", childMsg: []})
//    else // comment
      for (let message of state.messages)
        addMsgRec (newText, user, parentMsg, message, state.lastId)
    },

  
  
  // temporary method while discussions are sent entirely
  pushMsgFamily: (state, payload) => {
//    console.log(payload)
//    sortChildMsgRec (payload.childMsg)
    state.messages.push(payload)
  },
  clearMsg: (state) => state.messages = [],
  
  
  // payload format for votes: as in api response.
  setVotes: (state, payload) => state.votes = payload,
  
  checkAndAddVote: (state, payload) => {

    let vote = state.votes.find(vote => vote.messageID == payload.messageID)
    if (vote) 
      vote.upVote = payload.upVote  
    else 
      state.votes.push(payload)
    
  }
};

export default {
  state,
  getters,
  actions,
  mutations
};
