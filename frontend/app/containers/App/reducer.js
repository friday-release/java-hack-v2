import { LOAD_TROPHIES_SUCCESS } from './constants';

// The initial state of the App
export const initialState = {
  loading: false,
  error: false,
  currentUser: false,
  userData: {
    repositories: false,
  },
  trophies: []
};

function appReducer(state = initialState, action) {
  switch(action.type) {
    case LOAD_TROPHIES_SUCCESS:
      return {...state, trophies: action.trophies};
    default:
      return state;
  }
}

export default appReducer;
