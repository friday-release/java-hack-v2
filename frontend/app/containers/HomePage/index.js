import { connect } from 'react-redux';
import { compose } from 'redux';
import { createStructuredSelector } from 'reselect';
import injectReducer from 'utils/injectReducer';
import injectSaga from 'utils/injectSaga';
import {
  availableTrophies,
  completedTrophies,
  tasks,
  detail
} from 'containers/App/selectors';
import { loadTrophies, loadTasks, loadDetail } from 'containers/App/actions';
import { changeUsername, effect, selectTrophy } from './actions';
import { makeSelectUsername  } from './selectors';
import reducer from './reducer';
import saga from './saga';
import HomePage from './HomePage';

const mapDispatchToProps = (dispatch) => ({
  onChangeUsername: (evt) => dispatch(changeUsername(evt.target.value)),
  fetchTrophies: () => dispatch(loadTrophies()),
  fetchTasks: () => dispatch(loadTasks()),
  fetchDetailInfo: () => dispatch(loadDetail()),
  onEffect: (id) => dispatch(effect(id)),
  selectTrophy: (id) => dispatch(selectTrophy(id))
});

const mapStateToProps = createStructuredSelector({
  username: makeSelectUsername(),
  availableTrophies: availableTrophies(),
  completedTrophies: completedTrophies(),
  tasks: tasks(),
  detail: detail(),
});

const withConnect = connect(mapStateToProps, mapDispatchToProps);

const withReducer = injectReducer({ key: 'home', reducer });
const withSaga = injectSaga({ key: 'home', saga });

export default compose(withReducer, withSaga, withConnect)(HomePage);
export { mapDispatchToProps };
