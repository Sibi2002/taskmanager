import React, { useEffect, useState } from 'react'
import {Box,List,ListItem,Card,CardContent,IconButton,Typography,CardActions,Tooltip,CardHeader} from '@mui/material'
import TaskAltIcon from '@mui/icons-material/TaskAlt';
import axios from 'axios';
import useAuth from '../hooks/useAuth';
function AssignedTask() {
    const {auth}=useAuth();
    const[assignedTasks,setAssignedTasks]=useState([]);
    const fetchAssignedTAsks = async ()=>{
         const user_name=auth.user_name;
         let response = await axios.get(`http://localhost:8080/api/${user_name}/assigned`,{withCredentials:true});
         setAssignedTasks(response.data)
    }
    const updateStatus=(user_Name,task_id)=>{
         if(localStorage.getItem('nooverdue')==='false'){
            alert('complete over due tasks')
         }else{
         axios.post(`http://localhost:8080/api/${user_Name}/${task_id}/status_update`,{},{ withCredentials:true })
         .then((response)=>{console.log(response);window.location.reload(true)})
         .catch((error)=>console.log(error));
        }
    }
        
    useEffect(()=>{fetchAssignedTAsks()},[] );
  return (
    <Box>
        
        <List>
            {assignedTasks.map(task =><ListItem key={task.id}>
                <Card sx={{width:"400px"}} >
                    <CardHeader title={<Typography variant='h6'sx={{fontWeight:'bold'}}>{task.task_name}</Typography>} sx={{paddingBottom:0}}/>
                    <CardContent>
                        <Typography variant='body1'>
                         Assigned By:{task.admin_name} <br/>
                         Assigne Date:{task.assigned_date}<br/>
                         Due Date:{task.due_date}
                         </Typography>
                        <CardActions disableSpacing draggable sx={{ width:'350px',display:'flex', justifyContent:"flex-end"}}>
                            <Tooltip title='Mark as Completed' placement='bottom' arrow>
                            <IconButton sx={{top:10}}  color='secondary' onClick={()=>{
                                updateStatus(auth.user_name,task.task_id);
                            }}>
                            <TaskAltIcon></TaskAltIcon>
                            </IconButton>
                            </Tooltip>
                        </CardActions>
                    </CardContent>
                </Card>
            </ListItem>)}
        </List>
    </Box>
  )
}

export default AssignedTask;
