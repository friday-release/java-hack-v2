/**
 * NotFoundPage
 *
 * This is the page we show when the user visits a url that doesn't have a route
 */

import React from 'react';
import { withStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';

const styles = theme => ({
  root: {
    padding: theme.spacing(3, 2),
    marginLeft: 80,
    height: '100%',
    width: '600px',
    display: 'flex',
    flexDirection: 'column'
  },
 
});

function Loans({classes, getLoan}) {
  return (
    <div className={classes.root}>
      <h1>Потребительский кредит</h1>
      <Button variant="contained" onClick={getLoan} color="primary" className={classes.button}>
      Подать заявление
      </Button>
    </div>
  );
}

export default withStyles(styles)(Loans);
