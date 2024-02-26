package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Order;

public interface OrderDAO extends JpaRepository<Order, Long> {

}
