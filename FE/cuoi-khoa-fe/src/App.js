import { Routes, Route, Link } from 'react-router-dom';

import SignIn from './LoginRegister/Login';
import SignUp from './LoginRegister/Register';
import Sidebar from './SideBar/SideBar'

function App() {


  return (
    <div className="App">

        <Routes>
            <Route path="/" element={ <SignIn /> }></Route> 
            <Route path="/Register" element={ <SignUp /> }></Route> 
            <Route path="/QuanLyKhoaHoc" element={ <Sidebar /> }></Route> 
        </Routes>

    </div>
  );
}

export default App;
