import { connect } from 'react-redux';
import { compose } from 'redux';
import injectSaga from 'utils/injectSaga';
import injectReducer from 'utils/injectReducer';
import reducer from 'containers/App/reducer';
import { createStructuredSelector } from 'reselect';
import saga from './saga';
import {getLoan} from './actions';
import Loans from './Loans';

const mapDispatchToProps = (dispatch) => ({
    getLoan: () => dispatch(getLoan())
  });
  
const mapStateToProps = createStructuredSelector({  });
  const withConnect = connect(mapStateToProps, mapDispatchToProps);
  
  const withSaga = injectSaga({ key: 'loans', saga });
  const withReducer = injectReducer({ key: 'home', reducer });

  export default compose(withReducer, withSaga, withConnect)(Loans);
