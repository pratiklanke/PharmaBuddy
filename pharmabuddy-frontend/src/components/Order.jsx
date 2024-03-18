import React from 'react';
import Oder from "./Oder.css";
const Order = () => {
  return (
    <div className="image-card">
      <div className="image-container">
        <img src="https://assets.pharmeasy.in/apothecary/images/family.svg?dim=256x0" alt="Image 1" />
        <h5>32 Million+</h5>
        <p>Registered users as of Mar 31, 2023</p>
      </div>
      <div class = "vertical"></div>
      <div className="image-container">
        <img src="https://assets.pharmeasy.in/apothecary/images/deliveryBoy.svg?dim=256x0" alt="Image 2" />
        <h5>36 Million+</h5>
        <p>Orders on Pharmeasy till date </p>
      </div>
      <div class = "vertical"></div>
      <div className="image-container">
        <img src="https://assets.pharmeasy.in/apothecary/images/pincodeServed.svg?dim=256x0" alt="Image 3" />
        <h5>99000+</h5>
        <p>Unique items sold last 3 months</p>
      </div>
      <div class = "vertical"></div>
      <div className="image-container">
        <img src="https://assets.pharmeasy.in/apothecary/images/locationMarker.svg?dim=256x0" alt="Image 3" />
        <h5>19500+</h5>
        <p>Pin codes serviced last 3 months</p>
      </div>
    </div>
  );
};

export default Order;

