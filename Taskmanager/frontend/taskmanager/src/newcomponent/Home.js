import React from 'react'

import { Box,Grid,Typography,Paper } from '@mui/material'
import AssignedTask from './AssignedTask'
import CompletedTask from './CompletedTask'
import OverDueTask from './OverDueTask'
import useAuth from '../hooks/useAuth'

function Home() {
  const {auth}=useAuth();
  return (
   <Box>
    <Typography variant='h4' sx={{textAlign:'center',paddingTop:1,fontWeight:'bolder'}}> Welcome {auth.user_name} here are Your Task Progress </Typography>
    <Grid container spacing={5} my={4} >
        <Grid item>
            <Paper elevation={3} sx={{backgroundColor:"lightblue" ,width:'400px',marginLeft:2}}>
            <Typography variant='h5' sx={{textAlign:'center',padding:'4px',fontWeight:'bold'}}>Assigned Tasks</Typography>
            </Paper>
         <AssignedTask></AssignedTask>
        </Grid>
        <Grid item>
        <Paper elevation={3} sx={{backgroundColor:'hsla(120, 74%, 51%, 0.877)',width:'400px',marginLeft:2}}>
        <Typography variant='h5'sx={{textAlign:'center',padding:'4px',fontWeight:'bold'}}>Completed Tasks</Typography>
        </Paper>
            <CompletedTask></CompletedTask>
        </Grid>
        <Grid item>
          <Paper elevation={3} sx={{backgroundColor:'hsl(0, 94%, 65%)',width:'400px',marginLeft:2}}>
         <Typography variant='h5'sx={{textAlign:'center',padding:'4px',fontWeight:'bold'}}>Over Due Tasks</Typography>
        </Paper >
        <OverDueTask></OverDueTask>
        </Grid>
    </Grid>
   </Box>
  )
}

export default Home
