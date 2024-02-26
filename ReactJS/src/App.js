import logo from './logo.svg';
import './App.css';

import ProductRoot from './components/ProductRoot';
import { Container,Row } from 'react-bootstrap';
import Header from './components/Header';
import RoutingPath from './components/RoutingPath';
import { useEffect, useState } from 'react';
import useFetch from './customHooks/useFetch';
import CartContext from './components/CartContext';

function App() {

  const [isCart,setIsCart]=useState([]);

  const cartUrl=`http://localhost:3001/cartlist`;

  const {data,setRefetchData}=useFetch(cartUrl);

  useEffect(()=>{
    setIsCart(data);
  })

  function refreshCart()
  {
    setRefetchData({});
  }


  return (
    <>
    <CartContext.Provider value={{cart:isCart, refreshCartData:refreshCart}}>
      <Container>
        <Row>
          <Header/>
        </Row>
        <Row>
          <RoutingPath/>
        </Row>

      </Container>
      </CartContext.Provider>
    </>

  );
}

export default App;
