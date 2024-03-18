package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginDTO;
import com.app.dto.Response;
import com.app.dto.SellerDto;
import com.app.entities.Seller;
import com.app.exception.ResourceNotFoundException;
import com.app.service.OtpGenerator;
import com.app.service.ProductService;
import com.app.service.SellerService;

@CrossOrigin
@RestController
@RequestMapping("/api/sellers")
public class SellerController {

	@Autowired
	SellerService sellerService;

	@Autowired
	private ProductService productService;

	@Autowired
	OtpGenerator otpGenerator;

	@PostMapping
	public ResponseEntity<?> register(@RequestBody SellerDto sellerDto) {
		Seller seller = sellerService.registerSeller(sellerDto);
		if (seller != null) {
			return Response.success(seller);
		} else
			return Response.status(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody LoginDTO dto) {
		System.out.println(dto);
		Seller seller = sellerService.validate(dto.getEmail(), dto.getPassword());
		if (seller != null)
			return Response.success(seller);
		else
			return Response.status(HttpStatus.NOT_FOUND);
	}

	@GetMapping
	public ResponseEntity<?> findAllSellers() {
		System.out.println("findAllSellers...");
		List<Seller> result = sellerService.findAllSellers();
		return Response.success(result);
	}

	@GetMapping("{id}")
	public ResponseEntity<?> findSellerById(@PathVariable("id") int id) throws ResourceNotFoundException {
		System.out.println("findSellerById...");
		Seller result = sellerService.findSellerById(id);
		return Response.success(result);
	}

	/*
	 * we have to delete seller but for that 1st we have to delete product but for
	 * deleting product we have to delete orderdetails and we cannot loose the data
	 * or order so kahi garaj nahi delete karaychi
	 * 
	 * @DeleteMapping("{id}") public ResponseEntity<?>
	 * deleteSeller(@PathVariable("id") int id) { int sellerId=id;
	 * List<Product>products=productService.findProducts(sellerId); for(Product
	 * product:products) { productService.deleteProduct(product.getProdid()); }
	 * sellerService.deleteSeller(id); return Response.status(HttpStatus.OK); }
	 */

	@PutMapping("{id}")
	public ResponseEntity<?> updateProfile(@RequestBody Seller seller, @PathVariable("id") int id) {
		sellerService.updateProfile(seller, id);
		return Response.status(HttpStatus.OK);
	}

	@PostMapping("/forgetpassword")
	public ResponseEntity<?> forgetPassword(@RequestBody SellerDto sellerDto) {
		Seller seller = sellerService.findByEmail(sellerDto.getEmail());
		if (seller != null) {
			sellerService.resetPassword(seller, sellerDto.getPassword());
			return Response.status(HttpStatus.OK);
		} else {
			return Response.status(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/resetpassword")
	public ResponseEntity<?> resetPassword(@RequestBody SellerDto sellerDto) {
		Seller seller = sellerService.findByEmail(sellerDto.getEmail());
		if (seller != null) {
			sellerService.resetPassword(seller, sellerDto.getPassword());
			return Response.status(HttpStatus.OK);
		} else {
			return Response.status(HttpStatus.NOT_FOUND);
		}
	}
}
