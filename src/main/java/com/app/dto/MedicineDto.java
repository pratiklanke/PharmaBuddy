package com.app.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MedicineDto {
	
	private Long medicineId;
	
	private String name;
	
	private LocalDate expiryDate;
	
	private double price;
	
	private int stock;

	public MedicineDto() {
		super();
	}

	public MedicineDto(Long medicineId, String name, LocalDate expiryDate, double price, int stock) {
		super();
		this.medicineId = medicineId;
		this.name = name;
		this.expiryDate = expiryDate;
		this.price = price;
		this.stock = stock;
	}

	public Long getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Long medicineId) {
		this.medicineId = medicineId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
