package com.app.dto;

public class CartDTO {

	private int productId;

	private String categoryName;

	private String pname;

	private int price;

	private int qty;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "CartDTO [productId=" + productId + ", categoryName=" + categoryName + ", pname=" + pname + ", price="
				+ price + ", qty=" + qty + "]";
	}
}
