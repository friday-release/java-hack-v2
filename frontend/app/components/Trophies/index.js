import React from 'react';
import Typography from "@material-ui/core/Typography";
import { withStyles } from '@material-ui/core/styles';
import Divider from "@material-ui/core/Divider";
import ExpansionPanel from "@material-ui/core/ExpansionPanel";
import ExpansionPanelSummary from "@material-ui/core/ExpansionPanelSummary";
import ExpandMoreIcon from "@material-ui/core/SvgIcon/SvgIcon";
import ExpansionPanelDetails from "@material-ui/core/ExpansionPanelDetails";
import Paper from "@material-ui/core/Paper";
import Button from '@material-ui/core/Button';

const styles = (theme => ({
  root: {
    margin: 20,
    padding: theme.spacing(3, 2),
    minWidth: 400,
  },
  heading: {
    fontSize: theme.typography.pxToRem(15),
    fontWeight:600,
  },
  title: {
    display: 'flex',
    padding: '16px',
    'padding-top': '0',
    'padding-left': '0',
    'line-height': '0.6',
    'font-size': '1.8rem',
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
  },
  button: {
    marginTop: 20
  }
}));


const Trophies = ({availableTrophies, selectTrophy, detail, completedTrophies, classes}) => {
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
      {availableTrophies.map(({id, title, description, points}) => {
        const onClick = (id) => selectTrophy(id);
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
                { detail.points >= points && <Button variant="contained" onClick={onClick} color="secondary" className={classes.button}>
                 Получить
                </Button>}
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

