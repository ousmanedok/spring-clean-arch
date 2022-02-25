import { ADD_USER , RETRIEVE_USERS } from "./types";

export const addUser = (user) => async (dispatch) => {
    try {
           const res = user;
           return {
            type: ADD_USER,
            payload: res,
          };
    } catch (err) {
      return console.log(err);
    }
  };

  export const retrieveUsers = (users) => async (dispatch) => {
    try {
      const res = users;
      dispatch({
        type: RETRIEVE_USERS,
        payload: res,
      });
    } catch (err) {
      const message = `Une erreur est survenue lors de la récupération des articles : ${err?.message}`;
      dispatch({
        type: API_ERROR,
        payload: message
      });
    }
  };