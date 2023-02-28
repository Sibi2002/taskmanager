import React, { useState } from 'react'
import { Box,TextField,Paper} from '@mui/material'
import { Button } from '@mui/material'
import Avatar from '@mui/material/Avatar';
import './css/signup.css'
import tasker from'./images/taskamnager.jpg'
import axios from 'axios'
import  useAuth  from '../hooks/useAuth';
import { useNavigate } from 'react-router-dom';

function Signup() {
    const [username,setUserName]=useState('');
    const [password,setPassword]=useState('');
    const navi=useNavigate();
    const handleChangeUser=(event)=>{
        setUserName(event.target.value)
      
    }
    const handleChangePas=(event)=>{
        setPassword(event.target.value)
        
    }
    const accessGranter=()=>{
      axios.post('http://localhost:8080/users/signup',{
        user_name:username,
        password:password,
        role_id:2
      },{withCredentials:true}).then(response =>{
      
        if(response.status===200){
           navi('/',{replace:true})
        }
        else{
          alert("access denied try again")
        } })
     
    }
  return (
    <div id='signup'>  
    <Paper id="grider" elevation={12} >
      <img id='tasker_img'alt='Task Manager' src={tasker}></img>
      <Avatar sx={{ width: 70,height: 70,marginLeft:'70%',marginBottom:5,marginTop:2}} />  
     <Box >
        <TextField label="User Name" required type="text" onChange={handleChangeUser} color="secondary" sx={{width:350,marginBottom:3}}></TextField>
        <br/>
        <TextField label="Password" required type="Password" onChange={handleChangePas} color="secondary" sx={{width:350,marginBottom:3}}></TextField>
        <br/>
        <Button variant='contained' onClick={accessGranter} color="secondary" sx={{marginBottom:2}}>SignUp</Button>
        <br/>
        <a className='loginlink' href='http://localhost:3000/login'> Already has an account LogIn</a>
      </Box>
     </Paper>
     </div>
  )
}

export default Signup
