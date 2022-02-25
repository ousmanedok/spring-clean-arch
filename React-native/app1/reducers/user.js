import {
    ADD_USER,
    RETRIEVE_USERS
  } from "../actions/types";

  const initialState = {users:[]};
  

  function userReducer(state = initialState, action) {
    const { type, payload } = action;

    switch (type) {
        case ADD_USER:
            return {...state , users:[...state.users , payload]};
        case RETRIEVE_USERS:
            return {...state, users:payload};
        default:
            return state;
    }
};
export default userReducer;