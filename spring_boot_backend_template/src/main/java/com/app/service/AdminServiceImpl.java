package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Admin;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.AdminRepository;


@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminRepository adminRepo;
	
//	PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

	@Override
	public Admin validate(String email, String password) throws ResourceNotFoundException {
		System.out.println("validating Admin...");
		Admin admin=adminRepo.findByEmail(email);
		System.out.println(admin.getPassword());
		
		if(admin.getPassword().equals(password)) {
			return admin;
		}
		else {
			throw new ResourceNotFoundException("Either email or Password is incorrect");
		}
	}

	@Override
	public void updateAdmin(Admin admin) {
		Admin admin1=adminRepo.findByEmail(admin.getEmail());
		if(admin.getPassword().equals("") || admin.getPassword()==null) {
			admin.setPassword(admin1.getPassword());
		}
		String Password=admin.getPassword();
		admin1.setPassword(Password);
		adminRepo.save(admin1);	
	}

	@Override
	public Admin findByEmail(String email) {
		// TODO Auto-generated method stub
		return adminRepo.findByEmail(email);
	}

	@Override
	public void resetPassword(Admin admin, String password) {
		String password1 =(password);
		admin.setPassword(password1);
		adminRepo.save(admin);
	}

}
