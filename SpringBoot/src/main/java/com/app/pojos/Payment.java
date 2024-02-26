package com.app.pojos;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="payments")
@Getter@Setter
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;
	
	private double totalAmount;
	
	private LocalDateTime paymentDateTime;
	
	@Enumerated(EnumType.STRING)
	private PaymentMode mode;
	
	@OneToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="order_id")
	private Order order;

}
