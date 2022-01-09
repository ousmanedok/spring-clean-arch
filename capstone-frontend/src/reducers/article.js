import {
  RETRIEVE_ARTICLES,
  API_ERROR
  } from "../actions/types";

  const initialState = {articles:[]};

  function articleReducer(state = initialState, action) {
    const { type, payload } = action;
  
    switch (type) {

      case RETRIEVE_ARTICLES:
        return {...state, articles:payload};
      case API_ERROR:
        return {...state, messageError:payload}
      default:
        return state;
    }
  };  

  export default articleReducer; 