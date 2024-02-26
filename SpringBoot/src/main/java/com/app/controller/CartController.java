package com.app.controller;

import com.app.dto.CartDto;

import com.app.exception.ResourseNotFound;
import com.app.service.CartService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@GetMapping
	ResponseEntity<?> getAll(){
		return ResponseEntity.ok(cartService.getAllCarts());
	}
	
	@PostMapping("/addcart")
	ResponseEntity<?> addCart(@RequestBody CartDto cart){
		return ResponseEntity.status(HttpStatus.CREATED).body(cartService.addCart(cart));
	}
	
	@GetMapping("/{id}")
	ResponseEntity<?> getById(@PathVariable Long id) throws ResourseNotFound{
		return ResponseEntity.ok(cartService.getCartById(id));
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<?> deleteCart(@PathVariable Long id){
		return ResponseEntity.ok(cartService.deleteCartById(id));
	}
	
	@PutMapping("/updatecart")
	ResponseEntity<?> updateMedicine(@RequestBody CartDto cartDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(cartService.updateCart(cartDto));
	}

}
