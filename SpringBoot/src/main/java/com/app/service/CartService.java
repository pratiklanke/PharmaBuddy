package com.app.service;

import java.util.List;

import com.app.dto.ApiResponseDto;
import com.app.dto.CartDto;
import com.app.exception.ResourseNotFound;


public interface CartService {
	
	List<CartDto> getAllCarts();
	
	CartDto getCartById(Long id) throws ResourseNotFound;
	
	CartDto addCart(CartDto cart);
	
	ApiResponseDto deleteCartById(Long id);
	
	CartDto updateCart(CartDto cart);

}
