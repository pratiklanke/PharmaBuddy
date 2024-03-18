package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Payment;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.PaymentRepository;


@Service
public class PaymentSeviceImple implements PaymentService {
	
	@Autowired
	PaymentRepository paymentRepo;

	@Override
	public Payment savePayment(Payment payment) {
		// TODO Auto-generated method stub
		return paymentRepo.save(payment);
	}

	@Override
	public Payment findPaymentById(int id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Payment payment=paymentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Payment Details Not Found..!"));
		return payment;
	}

}
