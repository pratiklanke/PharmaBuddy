package com.app.service;

import java.util.List;

import com.app.dto.SellerDto;
import com.app.entities.Seller;
import com.app.exception.ResourceNotFoundException;

public interface SellerService {

	Seller registerSeller(SellerDto sellerDto);

	Seller validate(String email, String password);

	List<Seller> findAllSellers();

	Seller findSellerById(int id) throws ResourceNotFoundException;

	void updateProfile(Seller seller, int id);

	Seller findByEmail(String email);

	void resetPassword(Seller seller, String password);

}
