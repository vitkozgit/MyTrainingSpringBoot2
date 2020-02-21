package com.example.demo.security;

import org.springframework.data.repository.CrudRepository;

public interface ProdosUserRepository extends CrudRepository<ProdosUser, Long> {

	ProdosUser findByUsername(String username);
}
