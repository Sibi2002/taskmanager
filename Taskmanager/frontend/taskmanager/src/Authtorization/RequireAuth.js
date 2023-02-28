import React from 'react'
import { Outlet,  Navigate } from 'react-router-dom'
import useAuth from '../hooks/useAuth'
const Requireauth=({allowedRoles})=>{
    const {auth}=useAuth();
  return (
        auth? allowedRoles?.includes(auth.role)? 
        <Outlet/> :<Navigate to={'/'}></Navigate>:<Navigate to={'/login'}/>)
}
export default Requireauth;