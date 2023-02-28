import React, { useEffect, useState } from 'react';
import {Box,List,ListItem,Card,CardContent,Typography,CardHeader} from '@mui/material'
import useAuth from '../hooks/useAuth';
import axios from 'axios';
function CompletedTask() {
    const {auth}=useAuth();
    const[completedTasks,setCompletedTasks]=useState([]);
    const fetchCompletedTAsks = async ()=>{
        const user_name=auth.user_name;
        let response = await axios.get(`http://localhost:8080/api/${user_name}/completed`,{withCredentials:'true'});
        setCompletedTasks(response.data)
    }

    useEffect(()=>{fetchCompletedTAsks()} ,[] );
  return (
    <Box>
        <List>
            {completedTasks.map(task =><ListItem key={task.id}>
                <Card className='task-progress' sx={{ width:'400px'}}>
                    <CardHeader title={<Typography variant='h6'sx={{fontWeight:'bold'}}>{task.task_name}</Typography>} sx={{paddingBottom:0}}/>
                    <CardContent>
                        <Typography variant='body1'>
                         Assigned By:{task.admin_name}<br/>
                         Assigne Date:{task.assigned_date}<br/>
                         Completed Date:{task.completed_date}
                        </Typography>
                    </CardContent>
                </Card>
            </ListItem>)}
        </List>
    </Box>
  )
}

export default CompletedTask
