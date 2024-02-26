package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.dto.ApiResponseDto;
import com.app.dto.PaymentDto;
import com.app.exception.ResourseNotFound;
import com.app.pojos.Payment;
import com.app.repository.PaymentDAO;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
@Service
@Transactional
public class PaymentServImpl implements PaymentService {
	
	@Autowired
	private PaymentDAO paymentDao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<PaymentDto> getAllPayments() {
		List<Payment> payments = paymentDao.findAll();
		return payments.stream().map(p->mapper.map(p, PaymentDto.class)).collect(Collectors.toList());
	}

	@Override
	public PaymentDto getPaymentById(Long id) throws ResourseNotFound {
		Payment p = paymentDao.findById(id).orElseThrow(()->new ResourseNotFound("Payment Not Found"));
		return mapper.map(p, PaymentDto.class);
	}

	@Override
	public PaymentDto addPayment(PaymentDto payment) {
		Payment p = mapper.map(payment, Payment.class);
		Payment savedPayment = paymentDao.save(p);
		return mapper.map(savedPayment, PaymentDto.class);
	}

	@Override
	public ApiResponseDto deletePaymentById(Long id) {
		if(paymentDao.existsById(id)) {
			paymentDao.deleteById(id);
			return new ApiResponseDto("Deleted..!");
		}		
		return new ApiResponseDto("Not Deleted..!");
	}

	@Override
	public PaymentDto updatePayment(PaymentDto payment) {
		Payment p = mapper.map(payment, Payment.class);
		Payment savedPayment = paymentDao.save(p);
		return mapper.map(savedPayment, PaymentDto.class);
	}

}
