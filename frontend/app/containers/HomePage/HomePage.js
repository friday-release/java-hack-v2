/*
 * HomePage
 *
 * This is the first thing users see of our App, at the '/' route
 */

import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import './style.scss';
import Trophies from 'components/Trophies';
import Tasks from 'components/Tasks';

const styles = theme => ({
  root: {
    padding: theme.spacing(3, 2),
  },
});

class HomePage extends React.PureComponent { // eslint-disable-line react/prefer-stateless-function
  /**
   * when initial state username is not null, submit the form to load repos
   */
  componentDidMount() {
    const { fetchTrophies, fetchTasks} = this.props;
    fetchTrophies();
    fetchTasks();
  }

  render() {
    const { classes, tasks, completedTrophies, availableTrophies } = this.props;
    const username = 'Рога и копыта';
    return (
      <div style={{display: 'flex', width: "100%", position: "relative", height: "500"}}>
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
        <Tasks tasks={tasks} />
        <Trophies completedTrophies={completedTrophies}  availableTrophies={availableTrophies} />
     </div>
    );
  }
}

HomePage.propTypes = {
  classes: PropTypes.object.isRequired,
  tasks: PropTypes.array,
  completedTrophies: PropTypes.array,
  availableTrophies: PropTypes.array,
  username: PropTypes.string,
  onChangeUsername: PropTypes.func,
  fetchTrophies: PropTypes.func,
  fetchTasks: PropTypes.func
};

export default withStyles(styles)(HomePage);

