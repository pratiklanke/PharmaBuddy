package com.app.service;

import java.util.List;

import com.app.entities.OrderDetails;
import com.app.entities.Orders;
import com.app.exception.ResourceNotFoundException;

public interface OrderDetailsService {

	void saveOrderDetails(OrderDetails od);

	OrderDetails findById(int id) throws ResourceNotFoundException;

	List<OrderDetails> findByOrder(Orders order);

}
