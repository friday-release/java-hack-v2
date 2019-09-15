/*
 * App Actions
 *
 * Actions change things in your application
 * Since this boilerplate uses a uni-directional data flow, specifically redux,
 * we have these actions which are the only way your application interacts with
 * your application state. This guarantees that your state is up to date and nobody
 * messes it up weirdly somewhere.
 *
 * To add a new Action:
 * 1) Import your constant
 * 2) Add a function like this:
 *    export function yourAction(var) {
 *        return { type: YOUR_ACTION_CONSTANT, var: var }
 *    }
 */

import {
  LOAD_TROPHIES, LOAD_TROPHIES_SUCCESS,
  LOAD_TASKS, LOAD_TASKS_SUCCESS,
  LOAD_DETAIL, LOAD_DETAIL_SUCCESS
} from './constants';

export function loadTrophies() {
  return {
    type: LOAD_TROPHIES
  };
}

export function trophiesLoaded(trophies) {
  return {
    type: LOAD_TROPHIES_SUCCESS,
    trophies
  }
}


export function loadTasks() {
  return {
    type: LOAD_TASKS
  };
}

export function tasksLoaded(tasks) {
  return {
    type: LOAD_TASKS_SUCCESS,
    tasks
  }
}

export function loadDetail() {
  return {
    type: LOAD_DETAIL
  };
}

export function detailLoaded(detail) {
  return {
    type: LOAD_DETAIL_SUCCESS,
    detail
  }
}
