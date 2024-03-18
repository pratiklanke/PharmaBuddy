package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Customer;
import com.app.entities.Orders;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepo;

	@Override
	public Orders saveOrder(Orders order) {
		// TODO Auto-generated method stub
		return orderRepo.save(order);
	}

	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepo.findAll();
	}

	@Override
	public List<Orders> getCustomerOrders(Customer customer) {
		// TODO Auto-generated method stub
		return orderRepo.findByCustomer(customer);
	}

	@Override
	public Orders findById(int id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Orders order = orderRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Order Not Found..!"));
		return order;
	}

}
