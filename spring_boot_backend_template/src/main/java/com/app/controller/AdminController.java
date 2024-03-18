package com.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AdminDto;
import com.app.dto.LoginDTO;
import com.app.dto.Response;
import com.app.entities.Admin;
import com.app.exception.ResourceNotFoundException;
import com.app.service.AdminService;
import com.app.service.OtpGenerator;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	OtpGenerator otpGenerator;

	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody LoginDTO dto) throws ResourceNotFoundException {
		System.out.println(dto);
		Admin admin = adminService.validate(dto.getEmail(), dto.getPassword());
		if (admin != null)
			return Response.success(admin);
		else
			return Response.status(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<?> updateProfile(@RequestBody Admin admin) {
		adminService.updateAdmin(admin);
		return Response.status(HttpStatus.OK);
	}

	@PostMapping("/forgetpassword")
	public ResponseEntity<?>forgetPassword(@RequestBody AdminDto adminDto) {	
	Admin admin = adminService.findByEmail(adminDto.getEmail());
	if (admin != null) {
		adminService.resetPassword(admin, adminDto.getPassword());
		return Response.status(HttpStatus.OK);
	} else {
		return Response.status(HttpStatus.NOT_FOUND);
	}
	}

	@PutMapping("/resetpassword")
	public ResponseEntity<?> resetPassword(@RequestBody AdminDto adminDto){
		Admin admin = adminService.findByEmail(adminDto.getEmail());
		if (admin != null) {
			adminService.resetPassword(admin, adminDto.getPassword());
			return Response.status(HttpStatus.OK);
		} else {
			return Response.status(HttpStatus.NOT_FOUND);
		}
	}

}
