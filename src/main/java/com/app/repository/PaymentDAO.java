package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Payment;

public interface PaymentDAO extends JpaRepository<Payment, Long> {

}
