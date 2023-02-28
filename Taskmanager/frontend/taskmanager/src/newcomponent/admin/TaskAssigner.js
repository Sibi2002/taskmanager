import React, { useEffect, useState } from 'react'
import { Box,TextField,Autocomplete, Button} from '@mui/material'
import { DatePicker } from '@mui/x-date-pickers'
import axios from 'axios';
import useAuth from '../../hooks/useAuth';
function TaskAssigner() {
    const[users,setUsers]=useState([]);
    const[tasks,setTasks]=useState([]);
    const[date,setDate]=useState(null);
    const[user_name,setUserName]=useState(null);
    const[task_name,setTaskName]=useState(null);
    const[opusers,setOpUsers]=useState([]);
    const[optasks,setOpTasks]=useState([]);
    const {auth}=useAuth();
    const fetchUsers = async () =>{
      const responseUsers= await axios.get('http://localhost:8080/users/api/admin/allusers',{withCredentials:'true'})
      const responseTask= await axios.get('http://localhost:8080/api/admin/getalltask',{withCredentials:'true'})
      setTasks(responseTask.data);
      setUsers(responseUsers.data);
      const task=[];
      const user=[];
      responseTask.data.map(t =>task.push(t.task_name));
      responseUsers.data.map(t =>user.push(t.user_name));
      setOpTasks(task);
      setOpUsers(user);
    }
    useEffect(()=>{
     fetchUsers();
    },[])
    const assigner =()=>{
    let user_id=null;
    let task_id=null;
   
    tasks.map(task =>{if(task.task_name===task_name){
      task_id=task.task_id;   
   }})
    axios.post(`http://localhost:8080/api/admin/assigntask`,{
      user_name:user_name,
      task_id:task_id,
      assigned_by:auth.user_name,
      due_date:date},{withCredentials:true})
     .then(response=>{console.log(response);window.location.reload(true)})
     .catch(error => console.log(error))
    
      }

  
  return (
    
    <Box id='task-asign' sx={{alignSelf:'center',textAlign:"center"}}>
    <Autocomplete  disablePortal
    id='username'
    options={opusers}
    sx={{ width: 300,margin:'10px' }}
    renderInput={(params) => <TextField required {...params} label="User Name" />} value={user_name} onChange={(event,value)=>{setUserName(value)}}></Autocomplete>
    <Autocomplete   disablePortal
    id='Task'
    options={optasks}
    sx={{ width: 300,margin:'10px' }}
    renderInput={(params) => <TextField required {...params} label="Task" />} value={task_name} onChange={(event,value)=>{setTaskName(value)}}></Autocomplete>
   <DatePicker   label='Due Date' disablePast renderInput={(params) => <TextField required {...params}></TextField>}
    value={date} onChange={(newValue)=>setDate(newValue)} />
    <br/>
   <Button variant='contained' color='secondary' id='task-assgin-btn'sx={{margin:'5px'}} onClick={assigner}> Assign </Button>
  </Box>
  )
}

export default TaskAssigner
