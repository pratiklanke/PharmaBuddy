package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.User;

public interface UserDAO extends JpaRepository<User, Long> {

}
