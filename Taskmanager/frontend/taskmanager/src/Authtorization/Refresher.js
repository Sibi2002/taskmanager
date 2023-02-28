import { CircularProgress } from '@mui/material';
import React, { useEffect, useState } from 'react'
import { Navigate, Outlet } from 'react-router-dom'
import useAuth from '../hooks/useAuth'
import { useCookie } from '../hooks/useCookie';

function Refresher() {
    const [isLoading,setIsLoading]=useState(true)
    const {auth}=useAuth();
    const refesh=useCookie();
    useEffect(()=>{
        if(auth===null){
         try{ refesh();
        } 
          catch(error){console.log(error)
            }
        }
        setIsLoading(false)        
    },[])
   
  return (
    auth ? <Outlet></Outlet> :  isLoading ? <CircularProgress sx={{position:'absolute',top:'50%',left:'50%'}}></CircularProgress>:<Navigate to={"/login"}/>)
}

export default Refresher
