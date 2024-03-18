package com.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ProductDto;
import com.app.dto.ProductPagedResponseDTO;
import com.app.dto.ProductResponseDto;
import com.app.dto.Response;
import com.app.entities.Category;
import com.app.entities.Product;
import com.app.entities.Seller;
import com.app.exception.ResourceNotFoundException;
import com.app.service.CategoryService;
import com.app.service.ProductService;
import com.app.service.SellerService;

@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	SellerService sellerService;

	@Autowired
	CategoryService categoryService;

	@PostMapping
	public ResponseEntity<?> saveProduct(ProductDto dto) throws ResourceNotFoundException {

		System.out.println(dto);
		Product product = ProductDto.toEntity(dto); // Model Mapping

		Seller seller = sellerService.findSellerById(dto.getSellerId());
		product.setSeller(seller);

		Category category = categoryService.findByName(dto.getCategoryName());
		System.out.println(category.getCategoryId() + " " + category.getCategoryName());
		product.setCategory(category);

		Product product1 = productService.addProduct(product); // pic conversion to string
		return Response.success(product1);
	}

	// SellerId kept optional if sellerid is sent then products assigned to seller
	// will be fetched.
	// otherwise fetching of all products
	// /api/products?sellerId=1 or /api/products
	@GetMapping
	public ResponseEntity<?> findAllProducts(Optional<Integer> sellerId) throws ResourceNotFoundException {
		System.out.println("findAllProducts");
		List<ProductResponseDto> result = new ArrayList<ProductResponseDto>();

		if (sellerId.isPresent()) {
			System.out.println("findAllProducts" + sellerId);
			List<Product> products = productService.findProducts(sellerId.get());
			for (Product product : products) {
				result.add(ProductResponseDto.fromEntity(product));
			}

		} else {
			System.out.println("getAllProducts" + sellerId);
			for (Product product : productService.getAllProducts()) {
				result.add(ProductResponseDto.fromEntity(product));
			}
		}
		return Response.success(result);
	}

	// PUT: /api/products/1
	@PutMapping("{id}")
	public ResponseEntity<?> updateProduct(@RequestBody ProductDto productDto, @PathVariable("id") int id)
			throws ResourceNotFoundException {
		System.out.println(productDto);
		Product product = ProductDto.toEntity(productDto); // Model Mapping

		Seller seller = sellerService.findSellerById(productDto.getSellerId());
		product.setSeller(seller);

		Category category = categoryService.findByName(productDto.getCategoryName());
		System.out.println(category.getCategoryId() + " " + category.getCategoryName());
		product.setCategory(category);

		System.out.println("updating product.. ");
		productService.updateProduct(product);
		return Response.success(product);
	}

	// GET : /api/products/1
	@GetMapping("{id}")
	public ResponseEntity<?> findProduct(@PathVariable("id") int productId) throws ResourceNotFoundException {
		Product product = productService.findProductById(productId);
		return Response.success(ProductResponseDto.fromEntity(product));
	}

	// GET : /api/products/category?cat=Chair
	@GetMapping("/category")
	public ResponseEntity<?> findCategoryProducts(String cat) {
		System.out.println("categoyName..." + cat);
		List<ProductResponseDto> result = new ArrayList<ProductResponseDto>();

		for (Product p : productService.categoryProducts(cat)) {
			result.add(ProductResponseDto.fromEntity(p));
		}
		return Response.success(result);
	}

	@GetMapping("/paginated")
	public ResponseEntity<?> paginatedProducts(int page, int pagesize) {
		List<ProductResponseDto> result = new ArrayList<ProductResponseDto>();
		Page<Product> data = productService.allProductsPaginated(page, pagesize);
		data.forEach(item -> {
			result.add(ProductResponseDto.fromEntity(item));
		});
		ProductPagedResponseDTO resp = new ProductPagedResponseDTO();
		resp.setPagesize(pagesize);
		resp.setCurrent(page);
		resp.setTotal(data.getTotalElements());
		resp.setPlist(result);
		return Response.success(resp);
	}
}
