package com.app.service;

import com.app.entities.Address;
import com.app.exception.ResourceNotFoundException;

public interface AddressService {
	
	Address saveAddress(Address address);
	
	Address findAddress(int id) throws ResourceNotFoundException;
}
