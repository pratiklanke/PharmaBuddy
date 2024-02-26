package com.app.dto;

import lombok.Data;

@Data
public class CartDto {


	private Long cartId;

	private double amount;

	public CartDto(Long cartId, double amount) {
		super();
		this.cartId = cartId;
		this.amount = amount;
	}

	public CartDto() {
		super();
	}
	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
