/* fournit des methodes d'aide pour le front.*/

const state = {

  apiUrl: "http://localhost:8087/",
  
  displErrMsg: false,
  errorMessage: "",
  
  hashedPass: "",
  
  sortBy: "score"

};

// getters
const getters = {

  apiURL: state => state.apiUrl,
  displErrMsg: state => state.displErrMsg,
  errorMessage: state => state.errorMessage,
  hashedPass: state => state.hashedPass,
  sortBy: state => state.sortBy
};


const actions = {
  displayError: ({ commit }, errMsg) => {
    
    commit("setErrMsg", errMsg );
    setTimeout (()=>commit("hideErrMsg"), 3000)
  },
    sha256: async function ({commit}, password) {
//   console.log(password)
      const buffer = new TextEncoder("utf-8").encode(password);
      const hashBuffer = await crypto.subtle.digest("SHA-256", buffer);
      const hashArray = Array.from(new Uint8Array(hashBuffer));
      commit("setHashedPass", this.hashedPass = hashArray.map(b => ("00" + b.toString(16)).slice(-2)).join(""));
//    console.log(this.hashedPass)

		}
};

// mutations
const mutations = {
  setErrMsg: (state, payload) => {
    state.errorMessage = payload
    state.displErrMsg = true
  },
  hideErrMsg: (state) => state.displErrMsg = false,
  setHashedPass: (state, pass) => state.hashedPass = pass,
  resetHashedPass: (state) => state.hashedPass = "",
  setSortBy: (state, sort) => state.sortBy = sort

};

export default {
  state,
  getters,
  actions,
  mutations
};