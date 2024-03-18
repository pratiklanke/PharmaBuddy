package com.app.dto;

import org.springframework.beans.BeanUtils;

import com.app.entities.OrderDetails;
import com.app.entities.Product;


public class OrderDetailsDTO {

	private int id;
	
	private Product product;
	
	private int qty;
	
	public static OrderDetailsDTO fromEntity(OrderDetails entity) {
		OrderDetailsDTO dto = new OrderDetailsDTO();
		BeanUtils.copyProperties(entity, dto);		
		return dto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
}
