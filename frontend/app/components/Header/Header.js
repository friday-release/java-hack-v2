import React from 'react';
import { makeStyles } from '@material-ui/core/styles/index';
import { Link } from 'react-router-dom';
import Grid from '@material-ui/core/Grid';
import Button from '@material-ui/core/Button';
import ButtonGroup from '@material-ui/core/ButtonGroup';

/**
 * Created by anthony on 15/09/2019.
 */

const useHeaderStyles = makeStyles(theme => ({
  headerTop: {
    backgroundColor: '#ffdb00',
    paddingTop: '30px',
    height: '50px'
  },
  logo: {
    backgroundColor: 'green'
  },
  navContainer: {
    backgroundColor: '#ffdb00',
    display: 'flex',
    flexWrap: 'nowrap',
    justifyContent: 'space-between',
  },
  navItem: {
    backgroundColor: 'white',
    height: '50px'
  }
}));

const Header = () => {
  const classes = useHeaderStyles();
  return (
    <header>
      <div className={classes.headerTop}>
        <Link to="/invoices">
          <div className={classes.logo} />
        </Link>
        <div>Райффайзен банк</div>
      </div>
      <Grid container spacing={3} className={classes.navContainer}>
        <Grid item xs={12}>
          <ButtonGroup fullWidth aria-label="full width outlined button group">
            <Button className={classes.navItem}>Главная</Button>
            <Button className={classes.navItem}>История операций</Button>
            <Button className={classes.navItem}>Шаблоны и автоплатежи</Button>
            <Button className={classes.navItem}>Кредиты</Button>
            <Button className={classes.navItem}>Депозиты</Button>
          </ButtonGroup>
        </Grid>
      </Grid>
    </header>
  )
};

export default Header;
