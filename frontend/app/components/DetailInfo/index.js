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
    paddingTop: '0',
    paddingLeft: '0',
    lineHeight: '0.6',
    fontSize: '1.8rem',
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
      <div style={{
        'font-size': '1.3rem',
        'line-height': '1.9'
      }}>{detail.tenantTitle}</div>
      <div style={{padding: 15}}><b>Бренд </b>{detail.brandTitle}</div>
      <div style={{padding: 15}}><b>ОГРНИП </b>{detail.ogrn}</div>
      <div style={{padding: 15}}><b>Баллы </b>{detail.points}</div>

    </Paper>
  )};

export default withStyles(styles)(DetailInfo);

