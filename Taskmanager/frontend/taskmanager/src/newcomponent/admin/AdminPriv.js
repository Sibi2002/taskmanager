import React from 'react'
import Createtask from './Createtask'
import TaskAssigner from './TaskAssigner'
import { Grid, Typography } from '@mui/material'
import { Box } from '@mui/system'
function AdminPriv() {
   
  return (  
    <Box sx={{textAlign:'center'}}>
    <Typography variant='h4' sx={{padding:"4px",margin:0}}>Hi here you can assign or create task</Typography>
    <Grid container spacing={10} sx={{alignContent:'center'}}  my={6} >
    <Grid item  >
     <Typography variant='h5'sx={{padding:'4px',paddingLeft:'10px'}}>Assign Task Here</Typography>
     <TaskAssigner></TaskAssigner> 
    </Grid>
    <Grid item >
    <Typography variant='h5'sx={{padding:'4px'}}>Create Task Here</Typography>
    <Createtask></Createtask>
    </Grid>
   </Grid>
   </Box>
  )
}

export default AdminPriv
