package com.app.dto;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class PaymentDto {
	private Long paymentId;
	
	private double totalAmount;
	
	private LocalDateTime paymentDateTime;

	public PaymentDto() {
		super();
	}

	public PaymentDto(Long paymentId, double totalAmount, LocalDateTime paymentDateTime) {
		super();
		this.paymentId = paymentId;
		this.totalAmount = totalAmount;
		this.paymentDateTime = paymentDateTime;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDateTime getPaymentDateTime() {
		return paymentDateTime;
	}

	public void setPaymentDateTime(LocalDateTime paymentDateTime) {
		this.paymentDateTime = paymentDateTime;
	}
	

}
