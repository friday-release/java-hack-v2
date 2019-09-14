/*
 * HomePage
 *
 * This is the first thing users see of our App, at the '/' route
 */

import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Typography from '@material-ui/core/Typography';
import List from '@material-ui/core/List';
import Divider from '@material-ui/core/Divider';
import ExpansionPanel from '@material-ui/core/ExpansionPanel';
import ExpansionPanelSummary from '@material-ui/core/ExpansionPanelSummary';
import ExpansionPanelDetails from '@material-ui/core/ExpansionPanelDetails';
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';
import './style.scss';

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
    const { username, onSubmitForm } = this.props;
    if (username && username.trim().length > 0) {
      onSubmitForm();
    }
  }

  render() {
    const {classes, completedTrophies, availableTrophies, error, repos, username, onChangeUsername, onSubmitForm} = this.props;
   
    return (
      <div style={{display: 'flex', width: "100%", position: "relative", height: "500"}}>
        <Paper className={classes.root}>
              <div className="item_header">
                  <div className="item_header__content">
                    <div className="item_header__content-left-side">Карма</div>
                  </div>
                </div>
               <div><b>ИП</b>: <a >Рога и копыта</a></div>
               <div><b>Объём доступных средств</b>: 90000 p</div>
               <div><b>Расходы по картам</b>: 100000 p</div>
            </Paper>
          <Paper className={classes.root}>
              <div className="item_header">
                  <div className="item_header__content">
                    <div className="item_header__content-left-side">Задания</div>
                  </div>
                </div>
               <div><b>ИП</b>: <a >Рога и копыта</a></div>
               <div><b>Объём доступных средств</b>: 90000 p</div>
               <div><b>Расходы по картам</b>: 100000 p</div>
          </Paper> 
          <Paper className={classes.root}>
                <Typography variant="h3" component="h2">
                  Награды
                </Typography>
                <Divider light />
                <Typography className="item_head__widget-line" variant="h5" component="h2">
                  Доступные
                </Typography>
                <Divider light />
                {availableTrophies.map(({id, title, description}) => {
                    return (
                      <ExpansionPanel key={id}>
                      <ExpansionPanelSummary
                        expandIcon={<ExpandMoreIcon />}
                        aria-controls="panel1a-content"
                        id="panel1a-header"
                      >
                        <Typography className={classes.heading}>{title}</Typography>
                      </ExpansionPanelSummary>
                      <ExpansionPanelDetails>
                        <Typography>
                          {description}
                        </Typography>
                      </ExpansionPanelDetails>
                    </ExpansionPanel>
                    );
                  })}
                  
                <Typography className="item_head__widget-line"  variant="h5" component="h2">
                  Полученные
                </Typography>
                <Divider light />
                {completedTrophies.map(({id, title, description}) => {
                    return (
                      <ExpansionPanel key={id}>
                      <ExpansionPanelSummary
                        expandIcon={<ExpandMoreIcon />}
                        aria-controls="panel1a-content"
                        id="panel1a-header"
                      >
                        <Typography className={classes.heading}>{title}</Typography>
                      </ExpansionPanelSummary>
                      <ExpansionPanelDetails>
                        <Typography>
                          {description}
                        </Typography>
                      </ExpansionPanelDetails>
                    </ExpansionPanel>
                    );
                  })}
          </Paper>
     </div>
    );
  }
}

HomePage.propTypes = {
  classes: PropTypes.object.isRequired,
  completedTrophies: PropTypes.array,
  availableTrophies: PropTypes.array,
  loading: PropTypes.bool,
  error: PropTypes.oneOfType([PropTypes.object, PropTypes.bool]),
  repos: PropTypes.oneOfType([PropTypes.array, PropTypes.bool]),
  onSubmitForm: PropTypes.func,
  username: PropTypes.string,
  onChangeUsername: PropTypes.func
};

export default withStyles(styles)(HomePage);

