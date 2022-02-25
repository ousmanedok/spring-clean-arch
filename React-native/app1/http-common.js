import axios from "axios";
const url = "http://192.168.43.95:8080";
export default axios.create({
  baseURL:url,
  headers: {
    "Content-type": "application/json",
    
  }
}); 