import { connect } from 'react-redux';
import { compose } from 'redux';
import { createStructuredSelector } from 'reselect';
import injectReducer from 'utils/injectReducer';
import injectSaga from 'utils/injectSaga';
import {
  availableTrophies,
  completedTrophies,
  tasks
} from 'containers/App/selectors';
import { loadTrophies, loadTasks } from 'containers/App/actions';
import { changeUsername } from './actions';
import { makeSelectUsername  } from './selectors';
import reducer from './reducer';
import saga from './saga';
import HomePage from './HomePage';

const mapDispatchToProps = (dispatch) => ({
  onChangeUsername: (evt) => dispatch(changeUsername(evt.target.value)),
  fetchTrophies: () => dispatch(loadTrophies()),
  fetchTasks: () => dispatch(loadTasks())
});

const mapStateToProps = createStructuredSelector({
  username: makeSelectUsername(),
  availableTrophies: availableTrophies(),
  completedTrophies: completedTrophies(),
  tasks: tasks(),
});

const withConnect = connect(mapStateToProps, mapDispatchToProps);

const withReducer = injectReducer({ key: 'home', reducer });
const withSaga = injectSaga({ key: 'home', saga });

export default compose(withReducer, withSaga, withConnect)(HomePage);
export { mapDispatchToProps };
