import {
  RETRIEVE_ARTICLES,
  } from "../actions/types";
  
  const initialState = {articles:[]};

  function articleReducer(state = initialState, action) {
    const { type, payload } = action;
  
    switch (type) {

      case RETRIEVE_ARTICLES:
        console.log("articles" , payload);
        return {...state, articles:payload};
      default:
        return state;
    }
  };
  
  export default articleReducer;


  