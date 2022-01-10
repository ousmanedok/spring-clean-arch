import { API_ERROR } from "../actions/types";

function apiErrorReducer(state = null ,action){
    const { type , payload } = action;
    switch(type){
        case API_ERROR :
            return {...state , messageError:payload}
        default :
            return state;    
    }
}

export default apiErrorReducer; 