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

import com.app.dto.PaymentDto;
import com.app.exception.ResourseNotFound;
import com.app.service.PaymentService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping
	ResponseEntity<?> getAll(){
		return ResponseEntity.ok(paymentService.getAllPayments());
	}
	
	@PostMapping("/addPayment")
	ResponseEntity<?> addPayment(@RequestBody PaymentDto payment){
		return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.addPayment(payment));
	}
	
	@GetMapping("/{id}")
	ResponseEntity<?> getById(@PathVariable Long id) throws ResourseNotFound{
		return ResponseEntity.ok(paymentService.getPaymentById(id));
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<?> deletePayment(@PathVariable Long id){
		return ResponseEntity.ok(paymentService.deletePaymentById(id));
	}
	
	@PutMapping("/updatePayment")
	ResponseEntity<?> updateMedicine(@RequestBody PaymentDto paymentDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.updatePayment(paymentDto));
	}

}
