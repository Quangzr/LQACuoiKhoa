import { Routes, Route, Link } from 'react-router-dom';

import SignIn from './LoginRegister/Login';
import SignUp from './LoginRegister/Register';
import Sidebar from './SideBar/SideBar'
import Header from './Header/Header'
import CourseTable from './Table/Course'
import QuanLyKhoaHoc from './Page/QuanLyKhoaHoc'

function App() {
  return (
    <div className="App">
        
        <Routes>
            <Route path="/" element={ <SignIn /> }></Route> 
            <Route path="/Register" element={ <SignUp /> }></Route> 
            <Route path="/QuanLyKhoaHoc" element={ <QuanLyKhoaHoc /> }></Route> 
        </Routes>

        {/* <CourseTable /> */}
    </div>
  );
}

export default App;
