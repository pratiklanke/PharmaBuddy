package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="medicines")
@Getter@Setter
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long medicineId;
	
	private String name;
	
	private LocalDate expiryDate;
	
	private double price;
	
	private int stock;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admin_Id")
	private Admin admin;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_Id")
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cart_Id")
	private Cart cart;
}
