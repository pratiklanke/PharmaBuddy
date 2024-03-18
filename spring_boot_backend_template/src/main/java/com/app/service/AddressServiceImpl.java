package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Address;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.AddressRepository;


@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepo;
	
	@Override
	public Address saveAddress(Address address) {
		// TODO Auto-generated method stub
		return addressRepo.save(address);
	}

	@Override
	public Address findAddress(int id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Address address=addressRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Address Not Found..!"));
		return address;
	}


}
