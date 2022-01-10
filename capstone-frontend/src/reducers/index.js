import { combineReducers } from "redux";
import article from "./article";
import apiError from "./apiError";
export default combineReducers({
  article , apiError
});