package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.dto.ApiResponseDto;
import com.app.dto.UserDto;
import com.app.exception.ResourseNotFound;
import com.app.pojos.User;
import com.app.repository.UserDAO;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
@Service
@Transactional
public class UserServImpl implements UserService {
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<UserDto> getAllUsers() {
	 	List<User> users= userDao.findAll();
	 	return users.stream().map(u->mapper.map(u, UserDto.class)).collect(Collectors.toList());
	}

	@Override
	public UserDto getUserById(Long id) throws ResourseNotFound {
		User u = userDao.findById(id).orElseThrow(()->new ResourseNotFound("User Not Found..!"));
		return mapper.map(u, UserDto.class);
	}

	@Override
	public UserDto addUser(UserDto user) {
		User u = mapper.map(user, User.class);
		User savedUser = userDao.save(u);
		return mapper.map(savedUser,UserDto.class);
	}

	@Override
	public ApiResponseDto deleteUserById(Long id) {
		if(userDao.existsById(id)) {
			userDao.deleteById(id);
			return new ApiResponseDto("Deleted..!");
		}		
		return new ApiResponseDto("Not Deleted..!");
	}

	@Override
	public UserDto updateUser(UserDto user) {
		User u = mapper.map(user, User.class);
		User savedUser = userDao.save(u);
		return mapper.map(savedUser,UserDto.class);
	}

}
