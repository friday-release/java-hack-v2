import { createSelector } from 'reselect';
import { initialState } from './reducer';
import {selectHome, STATE} from "../HomePage/selectors";

const selectGlobal = (state) => state.global || initialState;

const selectRoute = (state) => state.router;

const makeSelectCurrentUser = () => createSelector(
  selectGlobal,
  (globalState) => globalState.currentUser
);

const makeSelectLoading = () => createSelector(
  selectGlobal,
  (globalState) => globalState.loading
);

const makeSelectError = () => createSelector(
  selectGlobal,
  (globalState) => globalState.error
);

const makeSelectRepos = () => createSelector(
  selectGlobal,
  (globalState) => globalState.userData.repositories
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


export {
  selectGlobal,
  makeSelectCurrentUser,
  completedTrophies,
  availableTrophies
};
