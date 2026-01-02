import React, { Fragment, useState } from 'react'
import { Button, Card, Container, Form, FormGroup, Input, NavLink } from 'reactstrap'
import { Emailbase_url } from '../assest/base_url'

import { NavLink as reactlink } from 'react-router-dom';
import axios from 'axios'
import { ToastContainer, toast } from 'react-toastify'
import { PropagateLoader } from 'react-spinners';

export const AddStudent = () => {

    const [Students, setStudent] = useState({})
    const [loading, setloading] = useState(false);
   

    const handleForm = (e) => {
        console.log(Students);
        postDataToServer(Students);
        e.preventDefault();

    }

    //insert student data into database with api
    const postDataToServer = (data) => {

        document.querySelector(".main").style.opacity = 0.4;
        setloading(true);

        axios.post(`${Emailbase_url}/addStudent`, data, {

        }).then(
            (response) => {
                setloading(false);
                document.querySelector(".main").style.opacity = 1;
                toast.success("Student Details added!...");
            },
            (error) => {
                alert("error")
                setloading(false);
                document.querySelector(".main").style.opacity = 1;
                toast.error("Error | Something went wrong!....");

            }
        );

    }
    return (
        <div className='main'>
            <div className='addStudentHome' style={{ backgroundColor: '#566279' }}>
                <div style={{ position:"fixed",marginLeft:"600px", display: 'flex', justifyContent: 'center' }}>
                    {

                        loading ? <PropagateLoader
                            color="#364e60"
                            size={20}
                        /> : " "

                    }
                </div>

                <ToastContainer />
                <div className='addform'>
                    <NavLink style={{ margin: '10px' }} tag={reactlink} to="/Email" class="btn "><Button>Back</Button> </NavLink>
                    <Card className='formCard' >
                       
                        <Form onSubmit={handleForm} style={{ padding: '40px' }}>
                        <header style={{ marginBottom: '20px' }} ><h1>Add Student Details</h1></header>
                            <FormGroup>
                                <Input type='text' required placeholder='Enter Student Name' title='heloo' name='studentName' id='fname' pattern="^[a-zA-Z\s]+$"  onInvalid={e => e.target.setCustomValidity(' required | Name must be in String!')}
                                    onChange={(e) => {
                                        setStudent({ ...Students, studentName: e.target.value })
                                    }}
                                    onInput={(e)=>{e.target.setCustomValidity("")}} />
                            </FormGroup>
                            <FormGroup>
                                <Input type='number'  required placeholder='Enter Student Marks in percentage' name='studentMark' id='fcategory'title='' min="0" max="100" onInvalid={e => e.target.setCustomValidity(' required | Student Marks must be in between 0 to 100!') }
                                    onChange={(e) => {
                                        setStudent({ ...Students, studentMark: e.target.value })
                                    }}
                                    
                                    onInput={(e)=>{e.target.setCustomValidity("")}}
                                    />
                            </FormGroup>
                            <FormGroup>
                                <Input type='email' required placeholder='Enter Student Email' name='studentEmail' id='hname' title="Must be in Proper Email Formate" onInvalid={e => e.target.setCustomValidity(' required |Email Must be in Proper Email Formate')}
                                    onChange={(e) => {
                                        setStudent({ ...Students, studentEmail: e.target.value })
                                    }}
                                    onInput={(e)=>{e.target.setCustomValidity("")}} />
                            </FormGroup>
                            <FormGroup>
                                <Input type='text' required placeholder='Enter Student Mentor Name' name='studentMentorName' id='description' pattern="^[a-zA-Z\s]+$"  onInvalid={e => e.target.setCustomValidity(' required | Name must be in String!')}
                                    onChange={(e) => {
                                        setStudent({ ...Students, studentMentorName: e.target.value })
                                    }} 
                                    onInput={(e)=>{e.target.setCustomValidity("")}}/>
                            </FormGroup>
                            <FormGroup>
                                <Input type='text' required placeholder='Enter University Name' name='studentUniversity' id='price' pattern="^[a-zA-Z\s]+$"  onInvalid={e => e.target.setCustomValidity(' required | Name must be in String!')}
                                    onChange={(e) => {
                                        setStudent({ ...Students, studentUniversity: e.target.value })
                                    }}
                                    onInput={(e)=>{e.target.setCustomValidity("")}} />
                            </FormGroup>
                            <FormGroup>
                                <Input type='text' pattern="[0-9]{10}" required placeholder='Enter Student Contact No'  name='studentContactno' id='file'  onInvalid={e => e.target.setCustomValidity(' required | Contact number must be in number and must be 10 digit')}
                                    onChange={(e) => {
                                        setStudent({ ...Students, studentContactno: e.target.value })
                                    }}
                                    onInput={(e)=>{e.target.setCustomValidity("")}} />
                            </FormGroup>
                            <Container>
                                <Button type='submit' color='success' outline>Add Student</Button>&nbsp;&nbsp;&nbsp;&nbsp;
                                <Button color='warning ml-2' type='reset' outline>Clear details</Button>
                            </Container>
                        </Form>
                    </Card>

                </div>
            </div>
        </div>

    )
}
