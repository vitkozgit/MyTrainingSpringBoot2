package com.example.demo.jdbc;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class MyOwnCrudRepository implements CrudRepository<ProductJpa, String> {
	@Override
	public <S extends ProductJpa> S save(S s) {
		return null;
	}

	@Override
	public <S extends ProductJpa> Iterable<S> saveAll(Iterable<S> iterable) {
		return null;
	}

	@Override
	public Optional<ProductJpa> findById(String s) {
		return Optional.empty();
	}

	@Override
	public boolean existsById(String s) {
		return false;
	}

	@Override
	public Iterable<ProductJpa> findAll() {
		return null;
	}

	@Override
	public Iterable<ProductJpa> findAllById(Iterable<String> iterable) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteById(String s) {

	}

	@Override
	public void delete(ProductJpa productJpa) {

	}

	@Override
	public void deleteAll(Iterable<? extends ProductJpa> iterable) {

	}

	@Override
	public void deleteAll() {

	}
}
