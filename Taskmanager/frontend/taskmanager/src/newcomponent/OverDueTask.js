import React, { useEffect, useState } from 'react';
import {Box,List,ListItem,Card,CardContent,IconButton,Typography,CardActions,CardHeader} from '@mui/material'
import TaskAltIcon from '@mui/icons-material/TaskAlt';
import axios from 'axios';
import useAuth from '../hooks/useAuth';
function OverDueTask() {
    const {auth}=useAuth();
    const[overDueTasks,setOverDueTasks]=useState([]);
    const fetchOverDueTAsks = async ()=>{
        const userid=auth.user_name;
        let response = await axios.get(`http://localhost:8080/api/${userid}/overdue`,{withCredentials:'true'});
        setOverDueTasks(response.data)
        if(overDueTasks.length){
            localStorage.setItem('nooverdue','true');
        }
    }
    const updateStatus=(user_name,task_id)=>{
        axios.post(`http://localhost:8080/api/${user_name}/${task_id}/status_update`,{},{withCredentials:true})
        .then((response)=>{console.log(response);window.location.reload(true)})
        .catch((error)=>console.log(error));
    }
    useEffect(()=>{fetchOverDueTAsks()},[] );
  return (
    <Box>
        <List>
            {overDueTasks.map(task =><ListItem key={task.id}>
                <Card className='task-progress' sx={{ width:'400px'}}>
                    <CardContent sx={{paddingBottom:'16px'}}>
                        <CardHeader title={ <Typography variant='h5'sx={{fontWeight:'bold'}}>{task.task_name}</Typography>} sx={{paddingBottom:0}}/>
                        <Typography variant='body1'>
                         Assigned By:{task.admin_name}<br/>
                         Assigne Date:{task.assigned_date}<br/>
                         Over Due By:{task.over_due_by}
                         </Typography>
                        <CardActions sx={{width:'350px',display:'flex', justifyContent:"flex-end"}}>
                            <IconButton sx={{top:10}} color='error' onClick={()=>{
                                updateStatus(auth.user_name,task.task_id)
                            }}>sk.
                            <TaskAltIcon></TaskAltIcon>
                            </IconButton>
                        </CardActions>
                    </CardContent>
                </Card>
            </ListItem>)}
        </List>
    </Box>
  )
}

export default OverDueTask

