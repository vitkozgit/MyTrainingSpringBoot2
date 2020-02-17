package com.example.demo.jdbc;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

	private ProductRepository productRepository;

	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@GetMapping("/product")
	public Product findOneById(@RequestParam("id") String id) {
		return productRepository.findOneById(id);
	}

	@PutMapping("/product")
	public Product saveProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
}
