package com.app.service;

import java.util.List;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


import com.app.dto.ApiResponseDto;
import com.app.dto.OrderDto;
import com.app.exception.ResourseNotFound;
import com.app.pojos.Order;
import com.app.repository.OrderDAO;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
@Service
@Transactional
public class OrderServImpl implements OrderService {
	
	@Autowired
	private OrderDAO orderDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<OrderDto> getAllOrders() {
		List<Order> orders = orderDao.findAll();
		return orders.stream().map(o -> mapper.map(o, OrderDto.class)).collect(Collectors.toList());
	}

	@Override
	public OrderDto getOrderById(Long id) throws ResourseNotFound {
		orderDao.findById(id).orElseThrow(()->new ResourseNotFound("Order not Found..!"));
		return null;
	}

	@Override
	public OrderDto addOrder(OrderDto order) {
		Order o = mapper.map(order, Order.class);
		Order savedOrder = orderDao.save(o);
		return mapper.map(savedOrder, OrderDto.class);
	}

	@Override
	public ApiResponseDto deleteOrderById(Long id) {
		if(orderDao.existsById(id)) {
			orderDao.deleteById(id);
			return new ApiResponseDto("Order Deleted..!");
		}		
		return new ApiResponseDto("Order Not Deleted..!");
	}

	@Override
	public OrderDto updateOrder(OrderDto order) {
		Order o = mapper.map(order, Order.class);
		Order savedOrder = orderDao.save(o);
		return mapper.map(savedOrder, OrderDto.class);
	}

}
