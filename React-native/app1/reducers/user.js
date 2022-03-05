import {
    ADD_USER,
    SIGNIN
  } from "../actions/types";

  const initialState = {
      users:[
                {
                    "nom"         : "Cherif",
                    "prenom"      : "Amina",
                    "email"       : "amina@bahbahtech.com",
                    "motDePasse"  : "Azerty",
                    "pays"        : "Guinée",
                    "ville"       : "Conakry"
                },
                {
                    "nom"         : "Diallo",
                    "prenom"      : "Alpha",
                    "email"       : "alpha@bahbahtech.com",
                    "motDePasse"  : "Azerty",
                    "pays"        : "Guinée",
                    "ville"       : "Conakry"
                }
      ],
      isLoggedIn: false,
      isLogInFail: false
    };
 
    
    const checkUser = (user, users) =>{
        const foundUser = users.find(item => item.email == user.email);
        if(foundUser){
            if(foundUser.motDePasse == user.motDePasse){
                return true;
            }
        }
        return false ;
  }


  function userReducer(state = initialState, action) {
    const { type, payload } = action;

    switch (type) {
        case ADD_USER:
            const userState = [...state.users]; 
            userState.push(payload);
            return {...state , users: userState};
        case SIGNIN:
            const isLoggedIn = checkUser(payload, state.users);
            return {...state , 
                isLoggedIn: isLoggedIn , 
                isLogInFail: isLoggedIn ? false : true 
            };   
        default:
            return state;
    }
};
export default userReducer;