import { ADD_USER , SIGNIN } from "./types";

export const addUser = (user) => async (dispatch) => {
    try {
           const res = user;
           dispatch({
            type: ADD_USER,
            payload: res,
          });
    } catch (err) {
      return console.log(err);
    }
  };

export const signin = (user) => {
  return {
    type: SIGNIN,
    payload: user
  }; 
}