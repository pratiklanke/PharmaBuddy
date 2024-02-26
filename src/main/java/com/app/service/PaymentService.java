package com.app.service;

import java.util.List;

import com.app.dto.ApiResponseDto;
import com.app.dto.PaymentDto;
import com.app.exception.ResourseNotFound;

public interface PaymentService {
	List<PaymentDto> getAllPayments();
	
	PaymentDto getPaymentById(Long id) throws ResourseNotFound;
	
	PaymentDto addPayment(PaymentDto payment);
	
	ApiResponseDto deletePaymentById(Long id);
	
	PaymentDto updatePayment(PaymentDto payment);

}
