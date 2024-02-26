package com.app.service;

import java.util.List;

import com.app.dto.ApiResponseDto;
import com.app.dto.OrderDto;
import com.app.exception.ResourseNotFound;

public interface OrderService {
	
	List<OrderDto> getAllOrders();
	
	OrderDto getOrderById(Long id) throws ResourseNotFound;
	
	OrderDto addOrder(OrderDto order);
	
	ApiResponseDto deleteOrderById(Long id);
	
	OrderDto updateOrder(OrderDto order);
}
