package com.app.dto;

import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;

import com.app.entities.Product;

public class ProductDto {

	private int productId;
	
	private String pname;
	
	private String categoryName;
	
	private double price;
	
	private int sellerId;
	
	private String brand;
	
	//used while updating the product
	private String photo;
	
	//used while uploading the product
	private MultipartFile pic;
	
	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", pname=" + pname + ", categoryName=" + categoryName + ",price=" + price + ", sellerId=" + sellerId + "]";
	}
	
	public static Product toEntity(ProductDto dto) {
		Product product=new Product();
		// source to destination copied excluding pic parameter
		BeanUtils.copyProperties(dto, product, "pic");		
		return product;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public MultipartFile getPic() {
		return pic;
	}

	public void setPic(MultipartFile pic) {
		this.pic = pic;
	}
	
}
