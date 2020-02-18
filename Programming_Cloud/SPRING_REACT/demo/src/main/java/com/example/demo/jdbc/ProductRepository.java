package com.example.demo.jdbc;

import java.util.List;

public interface ProductRepository {
	Iterable<Product> findAll();
	List<Product> findOneById(String id);
	Product save(Product product);
	String delete(String id);
}
