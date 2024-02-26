package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Cart;

public interface CartDAO extends JpaRepository<Cart, Long>{

}
