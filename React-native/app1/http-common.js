import axios from "axios";
export default axios.create({
  baseURL: "http://192.168.43.95:8080",
  headers: {
    "Content-type": "application/json",
    
  }
}); 