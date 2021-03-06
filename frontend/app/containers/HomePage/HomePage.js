/*
 * HomePage
 *
 * This is the first thing users see of our App, at the '/' route
 */

import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import './style.scss';
import Trophies from 'components/Trophies';
import Tasks from 'components/Tasks';
import DetailInfo from 'components/DetailInfo';

const styles = theme => ({
  root: {
    padding: theme.spacing(3, 2),
    marginLeft: 80,
    height: '100%',
    width: '100%',
    display: 'flex',
  },

});

class HomePage extends React.PureComponent { // eslint-disable-line react/prefer-stateless-function
  componentDidMount() {
    const { fetchTrophies, fetchTasks, fetchDetailInfo} = this.props;
    fetchTrophies();
    fetchTasks();
    fetchDetailInfo()
  }

  render() {
    const {classes, detail, selectTrophy, onEffect, tasks, completedTrophies, availableTrophies } = this.props;
    return (
      <div className={classes.root}>
        <DetailInfo detail={detail}/>
        <Tasks onEffect={onEffect} tasks={tasks}/>
        <Trophies detail={detail} selectTrophy={selectTrophy} completedTrophies={completedTrophies} availableTrophies={availableTrophies}/>
     </div>
    );
  }
}

HomePage.propTypes = {
  classes: PropTypes.object.isRequired,
  detail: PropTypes.object,
  tasks: PropTypes.array,
  completedTrophies: PropTypes.array,
  availableTrophies: PropTypes.array,
  username: PropTypes.string,
  onChangeUsername: PropTypes.func,
  fetchTrophies: PropTypes.func,
  fetchTasks: PropTypes.func,
  fetchDetailInfo: PropTypes.func,
  onEffect: PropTypes.func,
  selectTrophy: PropTypes.func,
};

export default withStyles(styles)(HomePage);

