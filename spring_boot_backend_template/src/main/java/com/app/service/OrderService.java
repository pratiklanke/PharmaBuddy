package com.app.service;

import java.util.List;

import com.app.entities.Customer;
import com.app.entities.Orders;
import com.app.exception.ResourceNotFoundException;

public interface OrderService {

	Orders saveOrder(Orders order);

	List<Orders> getAllOrders();

	List<Orders> getCustomerOrders(Customer customer);

	Orders findById(int id) throws ResourceNotFoundException;
}
