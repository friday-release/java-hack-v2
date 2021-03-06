import React from 'react';
import {makeStyles} from '@material-ui/core/styles/index';
import {Link} from 'react-router-dom';
import Grid from '@material-ui/core/Grid';
import Button from '@material-ui/core/Button';
import ButtonGroup from '@material-ui/core/ButtonGroup';

/**
 * Created by anthony on 15/09/2019.
 */

const useHeaderStyles = makeStyles(theme => ({
  headerTop: {
    backgroundColor: '#ffdb00',
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
    height: '50px',
    '&:hover': {
      backgroundColor: '#f3f3f3',
    }
  },
  gridContainer: {
    paddingBottom: 0
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
        <div style={{
          textAlign: 'center',
          verticalAlign: 'middle',
          fontSize: '1.8rem',
          paddingTop: '6px',
          fontWeight: '700',
        }}>Райффайзен банк
        </div>
      </div>
      <Grid container spacing={0}>
        <Grid item xs={12} className={classes.gridContainer}>
          <ButtonGroup fullWidth className={classes.buttonContainer}
                       aria-label="full width outlined button group">
            <Button className={classes.navItem}>Главная</Button>
            <Button className={classes.navItem}>История операций</Button>
            <Button className={classes.navItem}>Шаблоны и автоплатежи</Button>
            <Button className={classes.navItem}>Оплатить</Button>
            <Button className={classes.navItem}>Перевести</Button>
          </ButtonGroup>
        </Grid>
      </Grid>
    </header>
  )
};

export default Header;
