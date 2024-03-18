package com.app.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "payments")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

//	@Length(max=16,min=16)
//	@NotBlank(message="Card Number must be supplied")
	private long cardNo;

	// @NotBlank(message="Name must be supplied")
	private String nameOnCard;

	// @NotBlank(message="Amount must be supplied")
	private double amount;

	// @NotBlank(message="Date must be supplied")
	private Date paymentDate;

	public Payment(int id, long cardNo, String nameOnCard, double amount, Date paymentDate) {
		super();
		this.id = id;
		this.cardNo = cardNo;
		this.nameOnCard = nameOnCard;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}

	public Payment() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getCardNo() {
		return cardNo;
	}

	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", cardno=" + cardNo + ", nameOnCard=" + nameOnCard + ", amount=" + amount
				+ ", paymentDate=" + paymentDate + "]";
	}
}
