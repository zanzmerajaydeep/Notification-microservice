import logo from './logo.svg';
import './App.css';
import { Route, Router, Routes } from 'react-router-dom';

import { Home } from './component/Home.jsx';
import React, { useState } from 'react';
import CustomNav from './component/CustomNav';
import { About } from './component/About';


import { Email } from './component/Email';
import {PN} from './component/PN';
import {SMS} from './component/SMS';
import { Footer } from './component/Footer';
import { AddStudent } from './component/AddStudent';


function App() {

  const[item,setItem]= useState([
    {name:'Email',img:'email1.png',des:'Stay connected and informed with our reliable email notification Service.'},
    {name:'SMS',img:"sms1.png",des:'Instantly reach your users with our powerful SMS notification Service.'},
    {name:'Push Notification',img:'pn1.png',des:'Engage and retain users with our customizable push notification Service.'}
  ])

  return (
    <>
      <div className='wrapper'>
        
          <CustomNav/>

        <Routes>
          <Route exact path='/' element={<Home products={item}/>}>
          </Route>
          <Route exact path='/about' element={<About />}>
          </Route>
          
          <Route exact path='/Email' element={<Email/>}>
          </Route>
          <Route exact path='/SMS' element={<SMS/>}>
          </Route>
          <Route exact path='/Push Notification' element={<PN/>}>
          </Route>
          <Route exact path='/addStudent' element={<AddStudent/>}>
          </Route>  
        </Routes>
        

        <Footer/>

      </div>
     

    </>

  );
}

export default App;
