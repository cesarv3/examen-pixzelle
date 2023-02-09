import React, {useState} from 'react';
import {
    MDBContainer,
    MDBNavbar,
    MDBNavbarBrand,
    MDBNavbarNav,
    MDBNavbarItem,
    MDBNavbarLink,
    MDBNavbarToggler,
    MDBIcon,
    MDBCollapse} from 'mdb-react-ui-kit';

const Navbar = () => {
    const [mostarNavBar, setMostrarNavbar] = useState(false);

    return(
        <MDBNavbar expand='lg' light bgColor='light'>
            <MDBContainer fluid>
                <MDBNavbarBrand href='#'>CesarV</MDBNavbarBrand>
                <MDBNavbarToggler
          aria-controls='navbarSupportedContent'
          aria-expanded='false'
          aria-label='Toggle navigation'
          onClick={() => setMostrarNavbar(!mostarNavBar)}>
          <MDBIcon icon='bars' fas />
        </MDBNavbarToggler>
        <MDBCollapse navbar show={mostarNavBar}>
                <MDBNavbarNav className='mr-auto mb-2 mb-lg-0'>
                    <MDBNavbarItem>
                        <MDBNavbarLink active aria-current='page' href='http://localhost:3000/juegos'>
                        Juegos
                        </MDBNavbarLink>
                    </MDBNavbarItem>
                    <MDBNavbarItem>
                        <MDBNavbarLink href='http://localhost:3000/consolas'>
                            Consolas
                        </MDBNavbarLink>
                    </MDBNavbarItem>
                    <MDBNavbarItem>
                        <MDBNavbarLink href='http://localhost:3000/companias'>
                            Companias
                        </MDBNavbarLink>
                    </MDBNavbarItem>                    
                </MDBNavbarNav>
                </MDBCollapse>
            </MDBContainer>
        </MDBNavbar>
        
    )
}

export default Navbar;