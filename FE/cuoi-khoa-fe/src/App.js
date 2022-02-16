import { Routes, Route, Link } from 'react-router-dom';
import { useState } from 'react';

import SignIn from './LoginRegister/Login';
import SignUp from './LoginRegister/Register';

function App() {


  return (
    <div className="App">

        <Routes>
            <Route path="/" element={ <SignIn /> }></Route> 
            <Route path="/Register" element={ <SignUp /> }></Route> 
        </Routes>

    </div>
  );
}

export default App;
