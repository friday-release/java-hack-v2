import {LOAD_TROPHIES_SUCCESS, LOAD_TASKS_SUCCESS, LOAD_DETAIL_SUCCESS} from './constants';
import {EFFECTS_SENDED} from 'containers/HomePage/constants';
// The initial state of the App
export const initialState = {
  loading: false,
  error: false,
  currentUser: false,
  detail: {},
  trophies: [],
  tasks: []
};

function appReducer(state = initialState, action) {
  switch(action.type) {
    case LOAD_TROPHIES_SUCCESS:
      return {...state, trophies: action.trophies};
    case LOAD_TASKS_SUCCESS:
      return {...state, tasks: action.tasks};
    case EFFECTS_SENDED:
      return {...state, tasks: state.tasks.filter(task => action.id !== task.id)};
    case LOAD_DETAIL_SUCCESS:
      return {...state, detail: action.detail};
    default:
      return state;
  }
}

export default appReducer;
