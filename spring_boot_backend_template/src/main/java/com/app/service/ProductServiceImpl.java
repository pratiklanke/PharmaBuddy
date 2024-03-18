package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.entities.Category;
import com.app.entities.Product;
import com.app.entities.Seller;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepo;

	@Autowired
	SellerService sellerService;

	@Autowired
	CategoryService categoryService;

	@Override
	public Product addProduct(Product product) {
		productRepo.save(product);
		return product;
	}

	@Override
	public void updateProduct(Product product) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("updating product.. ");
		Product pp = productRepo.findById(product.getProductId())
				.orElseThrow(() -> new ResourceNotFoundException("Product not found..!"));

		product.setSeller(pp.getSeller());
		productRepo.save(product);
	}

	@Override
	public List<Product> findProducts(int sellerId) throws ResourceNotFoundException {
		Seller seller = sellerService.findSellerById(sellerId);
		return productRepo.findBySeller(seller);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public Product findProductById(int productId) throws ResourceNotFoundException {
		return productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product Not Found..!"));
	}

	@Override
	public List<Product> categoryProducts(String categoryName) {
		// TODO Auto-generated method stub
		Category category = categoryService.findByName(categoryName);
		return productRepo.findByCategory(category);
	}

	@Override
	public Page<Product> allProductsPaginated(int page, int pagesize) {
		Page<Product> prods = productRepo.findAll(PageRequest.of(page, pagesize, Sort.by(Direction.DESC, "productId")));
		System.err.println(prods.getSize());
		return prods;
	}

}
