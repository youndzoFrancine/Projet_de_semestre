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
  // message is not fetched if not in store (when querying /message/id directly)
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
        dispatch("displayError", "error while fetching message.")
      });
  },
    async newMessage ({commit, dispatch, getters}, payload) {

      await axios
      .post(getters.apiURL + "messages/create", {
        contenu: payload.newText,
        messageID: payload.parentMsg,
        utilisateurID: getters.user.utilisateurID
      })
      .then(response => {
        if (response.status == 201) {
          response.data.childMsg = []
          commit("addMessage", {newMsg: response.data, parentId: payload.parentMsg});
        } else {
          dispatch("displayError", "error while creating message.")
        }
      })
      .catch(error => {
        console.log(error);
        dispatch("displayError", "error while creating message.")
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
        dispatch("displayError", "error while fetching votes.")
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
    },
    async deleteMsg ({commit, dispatch, getters}, msgId) {
      
        await axios
        .delete(getters.apiURL + "messages/"+ msgId)
        .then(response => {
          if (response.status == 202) {
            commit("deleteMsg", msgId)
          } else {
            dispatch("displayError", "error while deleting message.")
          }
        })
        .catch(error => {
          console.log(error);
          dispatch("displayError", "error while deleting message.")
        });
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

// fonction qui parcourt l'arbre pour supprimer le message localement, au lieu de refetcher tous les messages
function deleteMsgRec (msgId, currentMsg) {
  for (let i = 0; i < currentMsg.childMsg.length; i++) {
        // no check if message still has childs
        if (currentMsg.childMsg[i].id === msgId) {
          currentMsg.childMsg.splice(i,1)
          break
        }
        else
          deleteMsgRec(msgId, currentMsg.childMsg[i])
  }
}

// mutations
const mutations = {
  setMessage: (state, payload) => (state.messages.push(payload)),
  addMessage: (state, {newMsg, parentId}) => {

      for (let message of state.messages)
        addMsgRec (newMsg, message, parentId)
  },
  deleteMsg: (state, msgId) => state.messages.forEach(msg => deleteMsgRec (msgId, msg)),
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
