package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.dto.UserDto;
import com.app.exception.ResourseNotFound;
import com.app.service.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	ResponseEntity<?> getAll(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@PostMapping("/addUser")
	ResponseEntity<?> addUser(@RequestBody UserDto user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));
	}
	
	@GetMapping("/{id}")
	ResponseEntity<?> getById(@PathVariable Long id) throws ResourseNotFound{
		return ResponseEntity.ok(userService.getUserById(id));
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<?> deleteUser(@PathVariable Long id){
		return ResponseEntity.ok(userService.deleteUserById(id));
	}
	
	@PutMapping("/updateUser")
	ResponseEntity<?> updateMedicine(@RequestBody UserDto userDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.updateUser(userDto));
	}

}
