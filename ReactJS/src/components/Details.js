import { useParams } from "react-router-dom";
import useFetch from "../customHooks/useFetch";
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import AddToCart from "./AddToCart";

export default function Details()
{
    const {id}=useParams();
    const productdataurl=`http://localhost:3001/productlist/${id}`;

    const {data}=useFetch(productdataurl);
    const productdata=data;

    const element=
    <>
    <h1>This is details component</h1>
    <Card style={{ width: '18rem' }}>
      <Card.Img variant="top" src={productdata.imagepath} />
      <Card.Body>
        <Card.Title>{productdata.brand}</Card.Title>
        <Card.Text>
        {productdata.title}
        </Card.Text>
        <Card.Text>
        INR. {productdata.price}
        </Card.Text>
       <AddToCart pid={productdata.id} title={productdata.title}
       imagepath={productdata.imagepath} price={productdata.price}/>
      </Card.Body>
    </Card>
    </>

    return element;
}