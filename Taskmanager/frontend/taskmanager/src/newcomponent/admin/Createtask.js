import React, { useState } from 'react'
import { Box,TextField, Button} from '@mui/material'
import axios from 'axios'
function Createtask() {
  const [task_name,setTaskName]=useState('');

  const createTask=()=>{
   axios.post("http://localhost:8080/api/admin/createtask",{task_name:task_name},{withCredentials:true}).then(response=>{ 
      console.log(response);}).then(data => { if(data===0){
        alert('already exist'); }
        else{
          window.location.reload(true)
        }}).catch(error=>console.log(error));
  }
  return (
    <Box>
        <TextField label='Task name' required sx={{margin:'5px'}} onChange={(event)=>setTaskName(event.target.value)}></TextField> <br/>
        <Button id='task-create-btn' variant='contained' color='secondary' onClick={createTask}>Create</Button>
    </Box>
  )
}

export default Createtask
