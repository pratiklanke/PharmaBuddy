import { useParams } from "react-router-dom";
import useFetch from "../customHooks/useFetch";

import Productlist from "./Productlist";

export default function ProductRoot()
{
    debugger;
    const {category}=useParams();
    debugger;
    const productUrl=(category)?`http://localhost:3001/productlist?category=${category}`:
    `http://localhost:3001/productlist`;

    const {data}=useFetch(productUrl); 

    const productlistdata=data;

    const element=
    <>
    <Productlist productlist={productlistdata}/>
    </>

    return element;
}