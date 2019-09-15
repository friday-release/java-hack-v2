/**
 * Gets the repositories of the user from Github
 */

import {call, put, select, takeEvery,} from 'redux-saga/effects';
import {LOAD_TROPHIES} from 'containers/App/constants';
import {trophiesLoaded} from 'containers/App/actions';

import request from 'utils/request';
import {makeSelectUsername} from 'containers/HomePage/selectors';

/**
 * Github repos request/response handler
 */

export function* getTrophies() {
  const userId = yield select(makeSelectUsername());
  const requestURL = `http://localhost:8080/api/tenants/123/trophies`;
  try {
    const trophies = yield call(request, requestURL);
    yield put(trophiesLoaded(trophies));
  } catch(err) {
    //
  }
}

/**
 * Root saga manages watcher lifecycle
 */
export default function* data() {
  yield takeEvery(LOAD_TROPHIES, getTrophies);
}
