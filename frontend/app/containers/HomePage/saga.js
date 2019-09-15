/**
 * Gets the repositories of the user from Github
 */

import {call, put, select, takeEvery,} from 'redux-saga/effects';
import {LOAD_TROPHIES, LOAD_TASKS, LOAD_DETAIL} from 'containers/App/constants';
import {trophiesLoaded, tasksLoaded,detailLoaded} from 'containers/App/actions';

import request from 'utils/request';
import {makeSelectUsername} from 'containers/HomePage/selectors';
import {effectsSended} from "./actions";
import { ON_EFFECT } from './constants';

/**
 * Github repos request/response handler
 */

export function* getTrophies() {
  const userId = yield select(makeSelectUsername());
  const requestURL = `http://134.209.134.214/api/tenants/123/trophies`;
  try {
    const trophies = yield call(request, requestURL);
    yield put(trophiesLoaded(trophies));
  } catch(err) {
    //
  }
}
export function* getTasks() {
  const userId = yield select(makeSelectUsername());
  const requestURL = `http://134.209.134.214/api/tenants/123/tasks`;
  try {
    const tasks = yield call(request, requestURL);
    yield put(tasksLoaded(tasks));
  } catch(err) {
    //
  }
}

export function* getDetailInfo() {
  const userId = yield select(makeSelectUsername());
  const requestURL = `http://134.209.134.214/api/tenants/123`;
  try {
    const detail = yield call(request, requestURL);
    yield put(detailLoaded(detail));
  } catch(err) {
    //
  }
}

export function* effects({id}) {
  const userId = yield select(makeSelectUsername());
  const requestURL = `http://134.209.134.214/api/tenants/123/tasks/${id}/complete`;
  try {
    debugger;
    const detail = yield call(request, requestURL,  {method: 'POST', // или 'PUT'
    headers:{
      'Content-Type': 'application/json'
    }});
    yield put(effectsSended(id));
  } catch(err) {
    //
  }
}

/**
 * Root saga manages watcher lifecycle
 */
export default function* data() {
  yield takeEvery(LOAD_TROPHIES, getTrophies);
  yield takeEvery(LOAD_TASKS, getTasks);
  yield takeEvery(LOAD_DETAIL, getDetailInfo);
  yield takeEvery(ON_EFFECT, effects);
}
