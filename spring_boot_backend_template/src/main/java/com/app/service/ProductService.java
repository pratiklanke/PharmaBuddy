package com.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.app.entities.Product;
import com.app.exception.ResourceNotFoundException;


public interface ProductService {

	Product addProduct(Product product);

	void updateProduct(Product product) throws ResourceNotFoundException;

	List<Product> findProducts(int sellerId) throws ResourceNotFoundException;

	List<Product> getAllProducts();

	Product findProductById(int id) throws ResourceNotFoundException;

	List<Product> categoryProducts(String pcategory);

	Page<Product> allProductsPaginated(int page, int pagesize);

}
