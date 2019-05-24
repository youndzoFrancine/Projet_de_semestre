/**
 * Ce fichier gère l'état Vuex dans l'app des messages
 */

import axios from "axios";

// initial state
const state = {
   
  messages: [],
  votes: [],  
};

// getters
const getters = {
  // message is not fetched if not in store (when querying /messages/id directly)
  // -> TODO: need to get disc containing it and set it.
  getOneMessage: state => id => {return state.messages.find(msg => msg.id == id) || {id: null, text: "", score: null, author: {role: {roleID: 0}}, childMsg: []}},
  lastId: state => state.lastId,
  vote: state => msgId => {
    const curVote = state.votes.find(vote => vote.messageID == msgId)
    if (curVote == undefined) return 'no'
    return curVote.upVote? 'up' : 'down'
  }
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
        utilisateurID: getters.user.utilisateurID
      })
      .then(response => {
        if (response.status == 201) {
          console.log(response.data)
          response.data.childMsg = []
          commit("addMessage", {newMsg: response.data, parentId: payload.parentMsg});
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
    },
    
    async voteMsg ({commit, dispatch, getters}, {msg, type}) {
      if (type != getters.vote(msg.id)) {
        const newVote = {
          upVote: type == "up" ? true : false,
          messageID: msg.id,
          utilisateurID: getters.user.utilisateurID
        }
        await axios
        .post(getters.apiURL + "votes/create", newVote)
        .then(response => {
          if (response.status == 201) {
            const diff = getters.vote(msg.id) == "no" ? 1 : 2
            // can change message...? othw do mutat°
            msg.score += (type == 'up' ? diff : -diff)
            commit("checkAndAddVote", newVote)
          } else {
            dispatch("displayError", "error while creating vote.")
          }
        })
        .catch(error => {
          console.log(error);
          dispatch("displayError", "error while creating vote.")
        });
      }
    }
};


// fonction qui parcourt l'arbre pour insérer le message localement, au lieu de refetcher tous les messages
function addMsgRec (newMsg, currentMsg, parentId) {

  if (currentMsg.id == parentId) {
      currentMsg.childMsg.push(newMsg)
  }
  else {
    for (let message of currentMsg.childMsg) {
      addMsgRec (newMsg, message, parentId)
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
  addMessage: (state, {newMsg, parentId}) => {

      for (let message of state.messages)
        addMsgRec (newMsg, message, parentId)
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
