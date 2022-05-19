import React from 'react';
import './App.css';

import { HashRouter, Routes, Route, Navigate } from 'react-router-dom';

import {LoginPage} from './Views/LoginPage/LoginPage';
//import { ReimbusementPage } from './Views/ReimbusementPage/ReimbusementPage';
//import {ProfilePage} from './Views/ProfilePage/ProfilePage';

function App() {
  return (
    <HashRouter>
      <Routes >
          <Route path="*" element={<Navigate to="/login" replace />} />
          <Route path="/login" element={<LoginPage />}/>
          
      </Routes>
    </HashRouter>
  );
}

export default App;
/*<Route path="/reimbusement" element={<ReimbusementPage />}/>
          <Route path="/user/:id" element={<ProfilePage />}/>
*/