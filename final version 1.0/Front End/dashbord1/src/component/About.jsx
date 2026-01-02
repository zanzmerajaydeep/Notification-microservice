import React from 'react'
import { Button, Card, CardBody, CardHeader, CardText, CardTitle, Col, Row, Table } from 'reactstrap'

export const About = () => {
  return (
    <div className='main'>
      <div style={{ display: 'flex', justifyContent: 'center',  backgroundColor: '#c1ccde' ,height:'70vh'}}>
        <Card
          className="my-2"
          style={{
            width: '60%',

          }}
        >
          <CardHeader style={{ display: 'flex', justifyContent: 'center' }}>
            <h4>Devlopers Details</h4>
          </CardHeader>
          <CardBody>
            <CardTitle tag="h6">
              <p><strong>College ID :</strong> 21MCA168 </p>
              <p><strong>Name :</strong> Zanzmera Jaydeep Kantibhai </p>
              <p><strong>Company Name :</strong> Einfochips (An Arrow Conpany)</p>
              <p><strong>Business Unit :</strong> PES (Digital)</p>



            </CardTitle>


          </CardBody>

        </Card>
      </div>
    </div>
  )
}
