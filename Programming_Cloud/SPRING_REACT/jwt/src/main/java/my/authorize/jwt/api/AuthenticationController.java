package my.authorize.jwt.api;

import my.authorize.jwt.domain.user.User;
import my.authorize.jwt.repository.CrudUserRepository;
import my.authorize.jwt.security.jwt.JwtAuthenticationService;
import my.authorize.jwt.domain.user.dto.AccountCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class AuthenticationController {
	private AuthenticationManager authenticationManager;

	private JwtAuthenticationService jwtAuthenticationService;

	private CrudUserRepository crudUserRepository;

	@Autowired
	public AuthenticationController(AuthenticationManager authenticationManager,
									JwtAuthenticationService jwtAuthenticationService,
									CrudUserRepository crudUserRepository) {
		this.authenticationManager = authenticationManager;
		this.jwtAuthenticationService = jwtAuthenticationService;
		this.crudUserRepository = crudUserRepository;
	}

	@PostMapping("/auth/login")
	public ResponseEntity<Map<Object, Object>> signin(@RequestBody AccountCredentials credentials) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword()));
		List<String> list = new ArrayList<>();

		Optional<User> userOpt = crudUserRepository.findByUsername(credentials.getUsername());
		User user = userOpt.orElseThrow(() -> new RuntimeException("Username not found : " + credentials.getUsername()));
		list.add(user.getRole());

		String token = jwtAuthenticationService.createToken(credentials.getUsername(), list);

		Map<Object, Object> model = new HashMap<>();
		model.put("username",credentials.getUsername());
		model.put("token", token);
		return ResponseEntity.ok(model);
	}
}
