import React, { useState } from 'react'
import { Box,TextField,Paper} from '@mui/material'
import { Button } from '@mui/material'
import Avatar from '@mui/material/Avatar';
import './css/login.css'
import tasker from'./images/taskamnager.jpg'
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function LogIn() {
    const [username,setUserName]=useState('');
    const [password,setPassword]=useState('');
    const navi=useNavigate();
    const instance = axios.create({
      withCredentials: true
  });
    const handleChangeUser=(event)=>{
        setUserName(event.target.value)
    }
    const handleChangePas=(event)=>{
        setPassword(event.target.value)
      
    }
    const accessGranter=()=>{
     instance.post('http://localhost:8080/users/login',{
          user_name:username,
          password:password,
          role_id:2
        }).then(response =>{
          
          if(response.status===200){
             navi('/',{replace:true});    
          }
          else{
            alert("access denied try again")
          } })
        
    }
  return (
    <div id='login'>  
    <Paper id="grider" elevation={12} >
      <img id='tasker_img'alt='Task Manager' src={tasker}></img>
      <Avatar sx={{ width: 70,height: 70,marginLeft:'70%',marginBottom:5,marginTop:2}} />  
     <Box >
        <TextField label="User Name" required type="text" onChange={handleChangeUser} color="secondary" sx={{width:350,marginBottom:3}}></TextField>
        <br/>
        <TextField label="Password" required type="Password" onChange={handleChangePas} color="secondary" sx={{width:350,marginBottom:3}}></TextField>
        <br/>
        <Button variant='contained' onClick={accessGranter} color="secondary" sx={{marginBottom:2}}>LogIn</Button>
        <br/>
        <a className='Signuplink' href='/signup'> Don't have an account Sign Up</a>
      </Box>
     </Paper >
     </div>
  )
}

export default LogIn