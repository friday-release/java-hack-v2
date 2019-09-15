/*
 * AppConstants
 * Each action has a corresponding type, which the reducer knows and picks up on.
 * To avoid weird typos between the reducer and the actions, we save them as
 * constants here. We prefix them with 'yourproject/YourComponent' so we avoid
 * reducers accidentally picking up actions they shouldn't.
 *
 * Follow this format:
 * export const YOUR_ACTION_CONSTANT = 'yourproject/YourContainer/YOUR_ACTION_CONSTANT';
 */

export const DEFAULT_LOCALE = 'en';

export const LOAD_TROPHIES = 'boilerplate/App/LOAD_TROPHIES';
export const LOAD_TROPHIES_SUCCESS = 'boilerplate/App/LOAD_TROPHIES_SUCCESS';

export const LOAD_TASKS = 'boilerplate/App/LOAD_TASKS';
export const LOAD_TASKS_SUCCESS = 'boilerplate/App/LOAD_TASKS_SUCCESS';

export const LOAD_DETAIL = 'boilerplate/App/LOAD_DETAIL';
export const LOAD_DETAIL_SUCCESS = 'boilerplate/App/LOAD_DETAIL_SUCCESS';
