import axios from "axios";
const API_URL = "http://localhost:8087/";

export class APIService {
  constructor() {}

  async getDiscussions() {
    const url = `${API_URL}/discussion/all`;
    const response = await axios.get(url);
    return response.data;
  }

  async getTags() {
    const url = `${API_URL}/tags/all`;

    const response = await axios.get(url);
    return response.data;
  }
}
// localhost:8087/tags/all
