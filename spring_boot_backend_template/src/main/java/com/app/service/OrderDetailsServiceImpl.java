package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.OrderDetails;
import com.app.entities.Orders;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.OrderDetailsRepository;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	OrderDetailsRepository orderDetailsRepo;

	@Override
	public void saveOrderDetails(OrderDetails od) {
		// TODO Auto-generated method stub
		orderDetailsRepo.save(od);
	}

	@Override
	public OrderDetails findById(int id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		OrderDetails orderDetails = orderDetailsRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("File Not Found..!"));
		return orderDetails;
	}

	@Override
	public List<OrderDetails> findByOrder(Orders order) {
		// TODO Auto-generated method stub
		return orderDetailsRepo.findByOrders(order);
	}
}
