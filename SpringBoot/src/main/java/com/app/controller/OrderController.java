package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.dto.OrderDto;
import com.app.exception.ResourseNotFound;
import com.app.service.OrderService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	ResponseEntity<?> getAll(){
		return ResponseEntity.ok(orderService.getAllOrders());
	}
	
	@PostMapping("/addOrder")
	ResponseEntity<?> addOrder(@RequestBody OrderDto order){
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.addOrder(order));
	}
	
	@GetMapping("/{id}")
	ResponseEntity<?> getById(@PathVariable Long id) throws ResourseNotFound{
		return ResponseEntity.ok(orderService.getOrderById(id));
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<?> deleteOrder(@PathVariable Long id){
		return ResponseEntity.ok(orderService.deleteOrderById(id));
	}
	
	@PutMapping("/updateOrder")
	ResponseEntity<?> updateMedicine(@RequestBody OrderDto orderDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.updateOrder(orderDto));
	}
}
