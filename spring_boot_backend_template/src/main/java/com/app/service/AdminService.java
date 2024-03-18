package com.app.service;

import com.app.entities.Admin;
import com.app.exception.ResourceNotFoundException;

public interface AdminService {

	Admin validate(String email, String password) throws ResourceNotFoundException;

	void updateAdmin(Admin admin);

	Admin findByEmail(String email);

	void resetPassword(Admin admin, String password);

}
