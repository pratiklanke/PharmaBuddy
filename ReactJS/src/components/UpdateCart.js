import Form from 'react-bootstrap/Form';
import useUpdate from '../customHooks/useUpdate';
import { useContext } from 'react';
import CartContext from './CartContext';
import useDelete from '../customHooks/useDelete';

export default function UpdateCart(props)
{
    const {updateData}=useUpdate();
    const context=useContext(CartContext);
    const {cartitem}=props;
    const carturl=`http://localhost:3001/cartlist/${cartitem.id}`;
    const {deleteData}=useDelete();

    const element=
    <>
     <Form.Select value={cartitem.quantity}
     onChange={(e)=>{
        debugger;
        if(e.target.value==="0")
        {
            deleteData(carturl);
        }
        else
        {
        updateData(carturl,{id:cartitem.id,pid:cartitem.pid,title:cartitem.title,
        imagepath:cartitem.imagepath,quantity:e.target.value});
        }
        context.refreshCartData();
     }}
     >
      <option value="0">Remove</option>
      <option value="1">1</option>
      <option value="2">2</option>
      <option value="3">3</option>
    </Form.Select>
    </>

    return element;
}