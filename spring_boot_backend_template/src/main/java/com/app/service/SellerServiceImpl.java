package com.app.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.SellerDto;
import com.app.entities.Seller;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.SellerRepository;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	SellerRepository sellerRepo;
	@Autowired
	ModelMapper mapper = new ModelMapper();

	@Override
	public Seller registerSeller(SellerDto sellerDto) {
		Seller seller = sellerRepo.findByEmail(sellerDto.getEmail());

		if (seller != null) {
			return null;
		} else {
			Seller seller1 = new Seller();
			String password = sellerDto.getPassword();
			sellerDto.setPassword(password);
			mapper.map(sellerDto, seller1);
			System.out.println(seller1);
			return sellerRepo.save(seller1);
		}
	}

	@Override
	public Seller validate(String email, String password) {
		Seller seller = sellerRepo.findByEmail(email);
		if (seller != null && seller.getPassword().matches(password)) {
			return seller;
		}
		return null;
	}

	@Override
	public List<Seller> findAllSellers() {
		// TODO Auto-generated method stub
		return sellerRepo.findAll();
	}

	@Override
	public Seller findSellerById(int id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return sellerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Seller Not Found..!"));
	}

	@Override
	public void updateProfile(Seller seller, int id) {
		// TODO Auto-generated method stub
		System.out.println("Updating profile..." + id);
		Optional<Seller> seller1 = sellerRepo.findById(id);
		if (seller1 != null) {
			if (seller.getPassword().equals("") || seller.getPassword() == null) {

				seller.setPassword(seller1.get().getPassword());
			} else if (seller.getPassword().equals(seller1.get().getPassword())) {
				seller.setPassword(seller1.get().getPassword());
			}
			sellerRepo.save(seller);
		}
	}

	@Override
	public Seller findByEmail(String email) {
		Seller seller = sellerRepo.findByEmail(email);
		return seller;
	}

	@Override
	public void resetPassword(Seller seller, String password) {
		seller.setPassword(password);
		sellerRepo.save(seller);
	}

}
