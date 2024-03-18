package com.app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CartDTO;
import com.app.dto.OrderDetailsDTO;
import com.app.dto.OrderResponseDTO;
import com.app.dto.PlaceOrderDTO;
import com.app.dto.Response;
import com.app.entities.Address;
import com.app.entities.Category;
import com.app.entities.Customer;
import com.app.entities.OrderDetails;
import com.app.entities.Orders;
import com.app.entities.Payment;
import com.app.entities.Product;
import com.app.exception.ResourceNotFoundException;
import com.app.service.AddressService;
import com.app.service.CategoryService;
import com.app.service.CustomerService;
import com.app.service.OrderDetailsService;
import com.app.service.OrderService;
import com.app.service.PaymentService;
import com.app.service.ProductService;



@CrossOrigin
@RestController
@RequestMapping("/api/orders")
public class OrdersController {

	@Autowired 
	OrderService orderService;
	
	@Autowired 
	CustomerService customerService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired 
	AddressService addressService;
	
	@Autowired 
	PaymentService paymentService;
	
	@Autowired 
	OrderDetailsService orderDetailsService;
	
	@Autowired 
	ProductService productService;	
	
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody PlaceOrderDTO dto) throws ResourceNotFoundException {	
		
		Address address=addressService.saveAddress(dto.getAddress());
		System.out.println("Address Saved"+address);
		dto.getPayment().setPaymentDate(new Date());
		
		Payment payment=paymentService.savePayment(dto.getPayment());
		System.out.println("Payment Saved"+payment);
		
		Orders order=new Orders();
		order.setOrderDate(new Date());
		order.setAddress(address);
		order.setPayment(payment);
		
		Customer customer=customerService.findCustomerById(dto.getCustomerId());
		order.setCustomer(customer);
		
		Orders orders=orderService.saveOrder(order);
		
		for(CartDTO cart : dto.getCart()) {
			OrderDetails od=new OrderDetails();
			od.setOrders(orders);
			od.setQty(cart.getQty());
			
			Product product=productService.findProductById(cart.getProductId());
			
			Category category =categoryService.findByName(cart.getCategoryName());
			product.setCategory(category);
			
			od.setProduct(product);
			
			orderDetailsService.saveOrderDetails(od);
		}
		
		
		System.out.println(dto.getAddress());
		System.out.println(dto.getCustomerId());
		System.out.println(dto.getPayment());
		System.out.println(dto.getCart().get(0));
		return Response.status(HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<?> findAllOrders(Optional<Integer> custId) throws ResourceNotFoundException {
		List<Orders> result=null;
		if(custId.isPresent()) {
			Customer customer=customerService.findCustomerById(custId.get());
			 result= orderService.getCustomerOrders(customer);
		}else {
			result = orderService.getAllOrders();
		}
		return Response.success(result);
	}
//	@GetMapping("/{Id}")
//	public ResponseEntity<?> findAllOrders(@RequestParam(value = "custId", required = false) Integer custId) {
//	    List<Orders> result = null;
//	    if (custId != null) {
//	        Optional<Customer> customer = customerService.findCustomerById(custId);
//	        if (customer.isPresent()) {
//	            result = orderService.getCustomerOrders(customer.get());
//	        } else {
//	            // Handle case when customer is not found for the given custId
//	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
//	        }
//	    } else {
//	        result = orderService.getAllOrders();
//	    }
//	    return ResponseEntity.ok(result);
//	}

	
	@GetMapping("/{id}")
	public ResponseEntity<?> findOrderById(@PathVariable("id") int id) throws ResourceNotFoundException {
		
		Orders order = orderService.findById(id);
		
		List<OrderDetails> details=orderDetailsService.findByOrder(order);
		
		List<OrderDetailsDTO> detailsdto=new ArrayList<OrderDetailsDTO>();
		
		details.forEach(od -> {
			OrderDetailsDTO dto=OrderDetailsDTO.fromEntity(od);
			detailsdto.add(dto);
		});
		
		OrderResponseDTO result=new OrderResponseDTO();
		result.setOrder(order);
		result.setDetails(detailsdto);
		return Response.success(result);
	}

}

