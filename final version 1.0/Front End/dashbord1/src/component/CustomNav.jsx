import React, { useState } from 'react';

import { NavLink as reactlink } from 'react-router-dom';
import { useAuth0 } from "@auth0/auth0-react";
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,
  UncontrolledDropdown,
  DropdownToggle,
  DropdownMenu,
  DropdownItem,
  NavbarText,
} from 'reactstrap';

function CustomNav(args) {

  const { loginWithRedirect } = useAuth0();
  const { logout } = useAuth0();
  const { user, isAuthenticated, isLoading } = useAuth0();


  const [isOpen, setIsOpen] = useState(false);
  const toggle = () => setIsOpen(!isOpen);

  return (
    <div>
      <Navbar
        style={{ backgroundColor: '#445064', fontStyle: 'italic', position: 'fixed', width: '100%', height: '80px', top: '0', left: '0', right: '0', zIndex: '1' }}
        expand='md'

      >
        <NavbarBrand tag={reactlink} to="/" style={{ color: 'white' }}>Notifier.com</NavbarBrand>
        <NavbarToggler onClick={toggle} />
        <Collapse isOpen={isOpen} navbar>
          <Nav className="me-auto" navbar >
            <NavItem >
              <NavLink tag={reactlink} to="/Email" style={{ color: 'white' }}>Email </NavLink>
            </NavItem>
            <NavItem>
              <NavLink tag={reactlink} to="/SMS" style={{ color: 'white' }}>
                SMS
              </NavLink>
            </NavItem>
            <NavItem>
              <NavLink tag={reactlink} to="/Push Notification" style={{ color: 'white' }}>
                Notifications
              </NavLink>
            </NavItem>
            <NavItem>
              <NavLink tag={reactlink} to="/about" style={{ color: 'white' }}>
                About US
              </NavLink>
            </NavItem>


           
              
            { isAuthenticated ?
              (<NavItem>
                <NavLink onClick={() => logout({ logoutParams: { returnTo: window.location.origin } })}>Log out</NavLink>
              </NavItem>) :
              
              (<NavItem>
                <NavLink onClick={() => loginWithRedirect()}>Log In</NavLink>
              </NavItem>)
            }
            
            {isAuthenticated} {console.log(user)}
            <NavItem>
              {isAuthenticated && <><h5>{user.name}</h5>
                <p>{user.email}</p></>}
            </NavItem>
          </Nav>
          <NavbarText><img width="50px" src="bell.png"></img></NavbarText>
        </Collapse>
      </Navbar>
    </div>
  );
}

export default CustomNav;