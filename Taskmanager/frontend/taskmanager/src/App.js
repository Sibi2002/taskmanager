
import { Route, Routes } from 'react-router-dom';
import LogIn from './newcomponent/LogIn';
import Signup from './newcomponent/Signup';
import { LocalizationProvider } from '@mui/x-date-pickers';
import { AdapterMoment } from '@mui/x-date-pickers/AdapterMoment'
import Home from './newcomponent/Home';
import Navigation from './newcomponent/Navigation';
import AdminPriv from './newcomponent/admin/AdminPriv';
import About from './newcomponent/About';
import Requireauth from './Authtorization/RequireAuth';
import UserLog from './Authtorization/UserLogInRejection';
import Refresher from './Authtorization/Refresher';
function App() {
  return (
      <>
      <LocalizationProvider dateAdapter={AdapterMoment}>
    
      <Navigation></Navigation>
      <Routes>
       <Route element={<Refresher></Refresher>}>
      <Route element={<Requireauth allowedRoles={['Admin','User']}></Requireauth>} alloweRoles={[1,2]} >
      <Route path='/' element={<Home></Home>}></Route>
      </Route>
      <Route element={<Requireauth allowedRoles={['Admin']}></Requireauth>} alloweRoles={[1]} >
      <Route path='/taskassign' element={<AdminPriv/>}></Route>
      </Route>
      </Route>
       <Route path='/about' element={<About></About>}></Route>
       <Route path='/login' element={<UserLog><LogIn></LogIn></UserLog>}></Route>
       <Route path='/signup' element={<UserLog><Signup></Signup></UserLog>}></Route>
      </Routes>
      </LocalizationProvider>
      </>
  );
}

export default App;
