package com.app.dto;

import java.time.LocalDate;

import lombok.Data;
@Data
public class OrderDto {
	private Long orderId;
	
	private LocalDate orderDate;
	
	private String address;

	public OrderDto() {
		super();
	}

	public OrderDto(Long orderId, LocalDate orderDate, String address) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.address = address;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
