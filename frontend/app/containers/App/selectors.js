import { createSelector } from 'reselect';
import { initialState } from './reducer';

export const STATE = {
  AVAILABLE: 'AVAILABLE',
  COMPLETED: 'COMPLETED'
};

const selectGlobal = (state) => state.global || initialState;

const selectRoute = (state) => state.router;

const makeSelectCurrentUser = () => createSelector(
  selectGlobal,
  (globalState) => globalState.currentUser
);

const makeSelectLocation = () => createSelector(
  selectRoute,
  (routeState) => routeState.location
);

const completedTrophies = () => createSelector(
  selectGlobal,
  (globalState) => globalState.trophies.filter(({state}) => state === STATE.COMPLETED)
);

const availableTrophies = () => createSelector(
  selectGlobal,
  (globalState) => globalState.trophies.filter(({state}) => state === STATE.AVAILABLE)
);

const tasks = () => createSelector(
  selectGlobal,
  (globalState) => globalState.tasks
);

const detail = () => createSelector(
  selectGlobal,
  (globalState) => globalState.detail
);

export {
  detail,
  tasks,
  selectGlobal,
  makeSelectCurrentUser,
  completedTrophies,
  availableTrophies
};
