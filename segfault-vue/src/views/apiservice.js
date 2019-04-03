import axios from 'axios';
const API_URL = 'http://localhost:8080/';
export class APIService{

    constructor(){
    }
    
    getDiscussions() {
        const url = `${API_URL}/discussion/all`;
        return axios.get(url).then(response => response.data);
    }
}