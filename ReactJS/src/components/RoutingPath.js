import { Routes,Route } from "react-router-dom"
import ProductRoot from "./ProductRoot"
import Cart from "./Cart";
import Details from "./Details";
import Login from "./Login";
export default function RoutingPath()
{
    const element=
    <>
    <Routes>
        <Route path="Products" element={<ProductRoot/>}/>
        <Route path="Cart" element={<Cart/>}/>
        <Route path="Products/:id" element={<Details/>}/>
        <Route path="Products/Categories/:category" element={<ProductRoot/>}/>
        <Route path="Login" element={<Login/>}/>
    </Routes>
    </>

    return element;
}