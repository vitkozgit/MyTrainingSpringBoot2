package com.example.demo.jdbc;

public interface ProductRepository {
	Iterable<Product> findAll();
	Product findOneById(String id);
	Product save(Product product);
}
