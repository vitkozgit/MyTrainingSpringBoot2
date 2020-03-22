package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class  AuthenticationController {

	@Autowired
	private JwtAuthenticationService jwtAuthenticationService;

	@Autowired
	private ProdosUserRepository prodosUserRepository;
}
