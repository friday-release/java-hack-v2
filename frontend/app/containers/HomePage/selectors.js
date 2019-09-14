import { createSelector } from 'reselect';

export const STATE = {
  AVAILABLE: 'AVAILABLE',
  COMPLETED: 'COMPLETED'
}
const selectHome = (state) => state.home;

const makeSelectUsername = () => createSelector(
  selectHome,
  (homeState) => homeState.username
);

const completedTrophies = () => createSelector(
  selectHome,
  (homeState) => homeState.trophies.filter(({state}) => state === STATE.COMPLETED)
);

const availableTrophies = () => createSelector(
  selectHome,
  (homeState) => homeState.trophies.filter(({state}) => state === STATE.AVAILABLE)
);

export {
  selectHome,
  makeSelectUsername,
  availableTrophies,
  completedTrophies
};
