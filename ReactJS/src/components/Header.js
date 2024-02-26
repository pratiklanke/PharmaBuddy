import { Container } from 'react-bootstrap';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Link } from 'react-router-dom';
import NavDropdown from 'react-bootstrap/NavDropdown';
export default function Header() {

    const element =
        <>
            <Navbar bg="dark" data-bs-theme="dark">
                <Container>
                    <Navbar.Brand href="#home">PharmaBuddy</Navbar.Brand>
                    <Nav className="me-auto">
                        <Nav.Link as={Link} to="/Products">Home</Nav.Link>
                        <Nav.Link as={Link} to="/Products">Products</Nav.Link>
                        <Nav.Link as={Link} to="/Cart">Cart</Nav.Link>
                        {/* <NavDropdown title="Categories" id="basic-nav-dropdown">
                            <NavDropdown.Item as={Link} to='/Products/Categories/headphones'>Headphones</NavDropdown.Item>
                            <NavDropdown.Item as={Link} to='/Products/Categories/laptops'>Laptops</NavDropdown.Item>
                        </NavDropdown> */}
                        <Nav.Link as={Link} to="/Login">Login</Nav.Link>
                    </Nav>
                </Container>
            </Navbar>
        </>

    return element;
}