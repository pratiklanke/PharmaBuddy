package com.app.service;

import java.util.List;

import com.app.dto.ApiResponseDto;
import com.app.dto.UserDto;
import com.app.exception.ResourseNotFound;

public interface UserService {
	List<UserDto> getAllUsers();
	
	UserDto getUserById(Long id) throws ResourseNotFound;
	
	UserDto addUser(UserDto user);
	
	ApiResponseDto deleteUserById(Long id);
	
	UserDto updateUser(UserDto user);
}
