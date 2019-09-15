import React from 'react';
import Typography from "@material-ui/core/Typography";
import { withStyles } from '@material-ui/core/styles';
import Divider from "@material-ui/core/Divider";
import Paper from "@material-ui/core/Paper";

const styles = (theme => ({
  root: {
    margin: 20,
    padding: theme.spacing(3, 2),
    minWidth: 275,
  },
  heading: {
    fontSize: theme.typography.pxToRem(15),
    fontWeight: theme.typography.fontWeightRegular,
  },
  title: {
    display: 'flex',
    padding: '16px',
    minHeight: '24px',
    borderBottom: '1px solid #ddd'
  }
}));

const DetailInfo = ({detail, classes}) => {
  return (
    <Paper className={classes.root}>
      <Typography className={classes.title} variant="h4" component="h2">
        Карма
      </Typography>
      <Divider light />
      <div><b> Баллы</b>{detail.points && detail.points}</div>

      <div><b>Имя</b>{detail.profile && detail.profile.firstName}</div>
    </Paper>
  )};

export default withStyles(styles)(DetailInfo);

