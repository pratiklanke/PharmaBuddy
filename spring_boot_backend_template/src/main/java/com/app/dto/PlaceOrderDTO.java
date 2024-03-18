package com.app.dto;

import java.util.List;

import com.app.entities.Address;
import com.app.entities.Payment;

public class PlaceOrderDTO {

	private Address address;

	private List<CartDTO> cart;

	private Payment payment;

	private int customerId;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<CartDTO> getCart() {
		return cart;
	}

	public void setCart(List<CartDTO> cart) {
		this.cart = cart;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
