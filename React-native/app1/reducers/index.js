import { combineReducers } from "redux";
import articleReducer from "./article";
import apiErrorReducer from "./apiError";
import userReducer     from "./user";
export default combineReducers({
  articleReducer , apiErrorReducer , userReducer
});