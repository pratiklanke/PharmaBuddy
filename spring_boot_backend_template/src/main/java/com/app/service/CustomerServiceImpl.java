package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.CustomerDto;
import com.app.entities.Customer;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepo;
	
	ModelMapper mapper = new ModelMapper();
	
	@Override
	public Customer registerUser(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		Customer cust=customerRepo.findByEmail(customerDto.getEmail());
		System.out.println(cust);
		if(cust!=null) {
				return null;
		}else {
			Customer customer = new Customer();
			String password = customerDto.getPassword();
			customerDto.setPassword(password);
			mapper.map(customerDto, customer);
			System.out.println(customer);
			return customerRepo.save(customer);
		}
	}

	@Override
	public Customer validate(String email, String password) {
		System.out.println("validating...");
		Customer customer=customerRepo.findByEmail(email);
		System.out.println(customer.getPassword());
		
		if(customer!=null && (customer.getPassword()).matches(password)) {
			return customer;
		}
		return null;
	}

	@Override
	public List<Customer> findAllCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public Customer findCustomerById(int id) throws ResourceNotFoundException {
		Customer customer = customerRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer Nt found..!"));
		System.out.println(customer);
		if(customer!=null) {
		return customer;
		}else {
			return null;
		}
	}

	@Override
	public void updateProfile(Customer cust,int id) throws ResourceNotFoundException {
		System.out.println("Updating profile..."+id);
		// TODO Auto-generated method stub
		Customer cust1=customerRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer Not Found..!"));
		if(cust1!=null) {
			if(cust.getPassword().equals("") || cust.getPassword()==null) {
				
				cust.setPassword(cust1.getPassword());
			}
			customerRepo.save(cust);
		}
	}

	@Override
	public Customer findByEmail(String email) {
		// TODO Auto-generated method stub
		Customer customer=customerRepo.findByEmail(email);
		return customer;
	}

	@Override
	public void resetPassword(Customer cust, String password) {
		cust.setPassword(password);
		customerRepo.save(cust);
	}
}
