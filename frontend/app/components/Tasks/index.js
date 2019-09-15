import React from 'react';
import Typography from "@material-ui/core/Typography";
import {withStyles} from '@material-ui/core/styles';
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
    lineHeight: '0.6',
    'font-size': '1.8rem',
    minHeight: '24px',
    borderBottom: '1px solid #ddd'
  },
  button: {
    marginTop: 20,
    backgroundColor: '#ffdb00',
    color: '#000000'
  }
}));


const Tasks = ({tasks, classes, onEffect}) => {
  return (
    <Paper className={classes.root}>
      <Typography className={classes.title} variant="h4" component="h2">
        Задания
      </Typography>
      <Divider light />
      {tasks.map(({id, title, description, points}) => {
        const onClick = () => onEffect(id);
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
                <br/>
                {points
                  ? <b>Будет начислено {points} баллов<br/></b>
                  : ''}
                <Button variant="contained" onClick={onClick} color="secondary" className={classes.button}>
                  Выполнить
                </Button>
              </Typography>
            </ExpansionPanelDetails>
          </ExpansionPanel>
        );
      })}
    </Paper>
  )};

export default withStyles(styles)(Tasks);

