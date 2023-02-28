import React from 'react'
import {AppBar,Toolbar,IconButton,Typography,Stack, Button} from '@mui/material'
import AssignmentIcon from '@mui/icons-material/Assignment';
import { useNavigate } from 'react-router-dom';
import  useAuth  from '../hooks/useAuth';
import axios from 'axios'
const Navigation= () =>{
   const navi=useNavigate();
   const { auth }= useAuth();
   const redirect=()=>{
    navi('/taskassign');
   }
   const logout = async() =>{
    try{let response= await  axios.get('http://localhost:8080/api/deletesession',{ withCredentials:true });
    console.log(response);
    window.location.reload(true);
}
    catch(error){
        console.log(error);
    }    
}
  return (
    <AppBar color="secondary" position="static">
  <Toolbar variant="dense">
    <IconButton edge="start" color="inherit" aria-label="menu" sx={{ mr: 2 }} onClick={()=>navi('/')}>
      <AssignmentIcon></AssignmentIcon>
    </IconButton>
    <Typography variant='h5' component='div' sx={{flexGrow:1}}>Task Manager</Typography>
    <Stack direction='row' spacing={2}>
    {
      (auth?.role==="Admin") && (<Button color='inherit' onClick={redirect}>Assign Task</Button>)
   }
    <Button color='inherit' onClick={()=>navi('/about')}>About</Button>{
      !auth && (<Button color='inherit' onClick={()=>{navi('/login')}}>Login</Button> )
    }
    {
      auth && (<Button color='inherit'  onClick={()=>{logout(); navi('/login',{replace:true});}}>Logout</Button>)
    }
    </Stack>
  </Toolbar>
</AppBar>
  )
}

export default Navigation
