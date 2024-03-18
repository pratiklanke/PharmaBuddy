package com.app.dto;

import org.springframework.beans.BeanUtils;

import com.app.entities.Product;


public class ProductResponseDto {

	private String brand;

	private int productId;

	private String pname;

	private String categoryName;

	private double price;

	private int sellerId;

	private String sellerName;

	private String photo;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public static ProductResponseDto fromEntity(Product entity) {
		ProductResponseDto dto = new ProductResponseDto();
		dto.setSellerId(entity.getSeller().getId());
		dto.setSellerName(entity.getSeller().getName());
		dto.setCategoryName(entity.getCategory().getCategoryName());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
