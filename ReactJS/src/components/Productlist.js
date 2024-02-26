import Card from 'react-bootstrap/Card';
import { Col } from "react-bootstrap";
import { Link } from 'react-router-dom';

export default function Productlist(props)
{

    const element=
    <>
    {props.productlist.map(prod=>  
        <Col> 
        <Link to={`/Products/${prod.id}`}>        
        <Card style={{boxShadow:'5px 5px 5px grey'}}>
         <Card.Img variant="top" src={prod.imagepath} height={80} width={20} />
         <Card.Body>
           <Card.Text>
           {prod.title}
           </Card.Text>
         </Card.Body>
       </Card>
       </Link> 
       </Col>
    )}
    </>

    return element;
}