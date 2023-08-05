import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8080", // Replace with your API base URL
});

export default API;
