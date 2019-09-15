import React from 'react';
import Typography from "@material-ui/core/Typography";
import { withStyles } from '@material-ui/core/styles';
import Divider from "@material-ui/core/Divider";
import ExpansionPanel from "@material-ui/core/ExpansionPanel";
import ExpansionPanelSummary from "@material-ui/core/ExpansionPanelSummary";
import ExpandMoreIcon from "@material-ui/core/SvgIcon/SvgIcon";
import ExpansionPanelDetails from "@material-ui/core/ExpansionPanelDetails";
import Paper from "@material-ui/core/Paper";

const styles = (theme => ({
  root: {
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
  },
  container: {
    display: 'flex',
    flexDirection: 'column',
    paddingLeft: '16px',
    minHeight: '24px'
  },
  dividerTitle: {
    paddingTop: '24px',
  }
}));


const Trophies = ({availableTrophies, completedTrophies, classes}) => {
  return (
  <Paper className={classes.root}>
    <Typography className={classes.title} variant="h4" component="h2">
      Награды
    </Typography>
    <Divider light />
    <div className={classes.container} >
      <Typography className={classes.dividerTitle} variant="h5" component="h2">
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

    <Typography className={classes.dividerTitle} variant="h5" component="h2">
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
    </div>    
  </Paper>
)};

export default withStyles(styles)(Trophies);

