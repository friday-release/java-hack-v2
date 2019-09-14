import { CHANGE_USERNAME } from './constants';
import {STATE} from './selectors';

// The initial state of the App
const initialState = {
  username: '',
  trophies: [
      {id: '1d', title: 'Уменьшенная комиссия за перечисление средств на счета других кредитных организаций', state: 'AVAILABLE', description: 'тут рандомный текст', expirationDate: null, points: 100},
      {id: '2d', title: 'пустая', description: ' описание ', state: STATE.COMPLETED}
    ]
};

function homeReducer(state = initialState, action) {
  switch (action.type) {
    case CHANGE_USERNAME:
      // Delete prefixed '@' from the github username
      return { ...state, username: action.name.replace(/@/gi, '') };
    default:
      return state;
  }
}

export default homeReducer;
