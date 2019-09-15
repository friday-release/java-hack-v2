/*
 * HomePage
 *
 * This is the first thing users see of our App, at the '/' route
 */

import React from 'react';
import PropTypes from 'prop-types';
import { withStyles, makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import './style.scss';
import Trophies from 'components/Trophies';
import Tasks from 'components/Tasks';

const styles = theme => ({
  root: {
    padding: theme.spacing(3, 2),
  },
  heading: {
    fontSize: theme.typography.pxToRem(15),
    fontWeight: theme.typography.fontWeightRegular,
  },
  list: {
    width: '100%',
    maxWidth: 360,
    backgroundColor: theme.palette.background.paper,
  },
});

class HomePage extends React.PureComponent { // eslint-disable-line react/prefer-stateless-function
  /**
   * when initial state username is not null, submit the form to load repos
   */
  componentDidMount() {
    const { username, onSubmitForm, fetchTrophies } = this.props;
    if (username && username.trim().length > 0) {
      onSubmitForm();
    }
    fetchTrophies();
  }

  render() {
    const { classes, completedTrophies, availableTrophies } = this.props;
    const username = 'Рога и копыта';
    return (
      <div style={{display: 'flex', width: "100%", position: "relative", left: '80px', height: "500"}}>

        <Paper className={classes.root}>
              <div className="item_header">
                  <div className="item_header__content">
                    <div className="item_header__content-left-side">Карма</div>
                  </div>
                </div>
          <div><b>ИП</b>: <a> {username}</a></div>
               <div><b>Объём доступных средств</b>: 90000 p</div>
               <div><b>Расходы по картам</b>: 100000 p</div>
            </Paper>
        <Tasks tasks={availableTrophies} />
        <Trophies completedTrophies={completedTrophies}  availableTrophies={availableTrophies} />
     </div>
    );
  }
}

HomePage.propTypes = {
  classes: PropTypes.object.isRequired,
  completedTrophies: PropTypes.array,
  availableTrophies: PropTypes.array,
  loading: PropTypes.bool,
  repos: PropTypes.oneOfType([PropTypes.array, PropTypes.bool]),
  username: PropTypes.string,
  onChangeUsername: PropTypes.func,
  fetchTrophies: PropTypes.func,
};

export default withStyles(styles)(HomePage);

