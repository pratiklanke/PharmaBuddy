package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ApiResponseDto;
import com.app.dto.CartDto;
import com.app.exception.ResourseNotFound;
import com.app.pojos.Cart;
import com.app.repository.CartDAO;
@Service
@Transactional
public class CartServImpl implements CartService {

	@Autowired
	private CartDAO cartDao;
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<CartDto> getAllCarts() {
		List<Cart> carts = cartDao.findAll();
		return carts.stream().map(c -> mapper.map(c, CartDto.class)).collect(Collectors.toList());
	}

	@Override
	public CartDto getCartById(Long id) throws ResourseNotFound {
		Cart c = cartDao.findById(id).orElseThrow(()->new ResourseNotFound("Cart Id not Found..!"));
		return mapper.map(c, CartDto.class);
	}

	@Override
	public CartDto addCart(CartDto cart) {
		Cart c = mapper.map(cart, Cart.class);
		Cart savedCart = cartDao.save(c);
		return mapper.map(savedCart, CartDto.class);
	}

	@Override
	public ApiResponseDto deleteCartById(Long id) {
		if(cartDao.existsById(id)) {
			cartDao.deleteById(id);
			return new ApiResponseDto("Cart Deleted..!");
		}		
		return new ApiResponseDto("Cart Not Deleted..!");
	}

	@Override
	public CartDto updateCart(CartDto cart) {
		Cart c = mapper.map(cart, Cart.class);
		Cart savedCart = cartDao.save(c);
		return mapper.map(savedCart, CartDto.class);
	}

}
