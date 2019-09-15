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
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import InputLabel from '@material-ui/core/InputLabel';
import TextField from '@material-ui/core/TextField';

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
  const [open, setOpen] = React.useState(false);
  const [fullWidth, setFullWidth] = React.useState(true);
  const [taskId, setTaskId] = React.useState('');
  const [maxWidth, setMaxWidth] = React.useState('sm');
  
  function handleClickOpen() {
    setOpen(true);
  }

  function handleClose() {
    setOpen(false);
    onEffect(taskId);
  }

  function handleTaskIdChange(id) {
    setTaskId(id);
  }


  function handleMaxWidthChange(event) {
    setMaxWidth(event.target.value);
  }

  function handleFullWidthChange(event) {
    setFullWidth(event.target.checked);
  }
  
  return (
    <>
    <Paper className={classes.root}>
      <Typography className={classes.title} variant="h4" component="h2">
        Задания
      </Typography>
      <Divider light />
      {tasks.map(({id, title, description, points }) => {
        const onClick = () => { handleTaskIdChange(id), handleClickOpen() }
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
    <Dialog
    fullWidth={fullWidth}
    maxWidth={maxWidth}
    open={open}
    onClose={handleClose}
    aria-labelledby="max-width-dialog-title"
  >
    <DialogTitle id="max-width-dialog-title">Подключить СМС уведомление</DialogTitle>
    <DialogContent>
      <DialogContentText>
      СМС уведомление будет подключено на номер: +7 (960) 955-05-65 
      </DialogContentText>
       <Button onClick={handleClose} color="secondary" className={classes.button}>
         Подключить
      </Button>
    </DialogContent>
    <DialogActions>
      <Button onClick={handleClose} color="primary">
        Закрыть
      </Button>
    </DialogActions>
  </Dialog>
    </>
  )};

export default withStyles(styles)(Tasks);

