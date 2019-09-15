import { LOAD_TROPHIES_SUCCESS, LOAD_TASKS_SUCCESS } from './constants';

// The initial state of the App
export const initialState = {
  loading: false,
  error: false,
  currentUser: false,
  userData: {
    repositories: false,
  },
  trophies: [],
  tasks: []
};

function appReducer(state = initialState, action) {
  switch(action.type) {
    case LOAD_TROPHIES_SUCCESS:
      return {...state, trophies: action.trophies};
    case LOAD_TASKS_SUCCESS:
      return {...state, tasks: action.tasks};
    default:
      return state;
  }
}

export default appReducer;
