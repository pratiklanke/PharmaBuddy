import { Button } from "react-bootstrap";
import usePost from "../customHooks/usePost";
import { useContext, useState } from "react";
import useFetch from "../customHooks/useFetch";
import CartContext from "./CartContext";
import useUpdate from "../customHooks/useUpdate";

export default function AddToCart(props) {
    const { pid, title, imagepath, price } = props;
    const { postData } = usePost();
    const {updateData}=useUpdate();
    const context = useContext(CartContext);

    const [itemAdded, setItemAdded] = useState(false);

    const carturl = `http://localhost:3001/cartlist`;

    debugger;
    const existingItem=context.cart.filter(c=>c.pid===pid);


    const element = <>
        <Button disabled={itemAdded}
            onClick={() => {
                if(existingItem)
                {
                    updateData(carturl+ `/${existingItem[0].id}`,{id:existingItem[0].id,pid:pid,
                    title:existingItem[0].title,imagepath:existingItem[0].imagepath,quantity:existingItem[0].quantity+1});
                }
                else{
                postData(carturl, { pid: pid, title: title, imagepath: imagepath, quantity: 1 });
                }
                context.refreshCartData();
                setItemAdded(true);
            }}
        >
            {itemAdded ? 'Item Added' : 'Add To Cart'}
        </Button>
    </>

    return element;
}