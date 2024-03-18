package com.app.service;

import com.app.entities.Payment;
import com.app.exception.ResourceNotFoundException;

public interface PaymentService {

	Payment savePayment(Payment payment);
	
	Payment findPaymentById(int id) throws ResourceNotFoundException;
}
