package com.app.service;

import java.util.List;

import com.app.dto.CustomerDto;
import com.app.entities.Customer;
import com.app.exception.ResourceNotFoundException;


public interface CustomerService {

	Customer registerUser(CustomerDto customerDto);

	Customer validate(String email, String password);

	List<Customer> findAllCustomers();

	Customer findCustomerById(int id) throws ResourceNotFoundException ;

	void updateProfile(Customer cust, int id) throws ResourceNotFoundException;

	Customer findByEmail(String email);

	void resetPassword(Customer cust, String password);

}
