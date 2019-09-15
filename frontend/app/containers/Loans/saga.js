/**
 * Gets the repositories of the user from Github
 */

import {call, put, select, takeEvery,} from 'redux-saga/effects';
import {GET_LOAN} from './constants';
import {loanLoaded} from './actions';
import request from 'utils/request';

/**
 * Github repos request/response handler
 */

export function* getLoan() {
  // const userId = yield select(makeSelectUsername());
  const requestURL = `http://localhost:8080/api/tenants/123/tasks/234/complete`;
  try {
    const status = yield call(request, requestURL);
    yield put(loanLoaded(status));
  } catch(err) {
    //
  }
}

/**
 * Root saga manages watcher lifecycle
 */
export default function* data() {
  yield takeEvery(GET_LOAN, getLoan);
}
