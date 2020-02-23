package my.authorize.jwt.security.jwt;

import io.jsonwebtoken.*;
import my.authorize.jwt.domain.user.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Component
public class JwtAuthenticationService {

	private static final String SECRET_KEY = Base64.getEncoder().encodeToString("xxx".getBytes());
	private static final String PREFIX = "Bearer";
	private static final String EMPTY = "";
	private static final long EXPIRATION_TIME = 86400000;
	private static final String AUTHORIZATION = "Authorization";

	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	public JwtAuthenticationService(UserDetailsServiceImpl userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	public String createToken(String username, List<String> roles) {
		Claims claims = Jwts.claims().setSubject(username);
		claims.put("roles", roles);

		Date now = new Date();
		Date validity = new Date(now.getTime() + EXPIRATION_TIME);

		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(now)
				.setExpiration(validity)
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY)
				.compact();
	}

	public Authentication getAuthentication(HttpServletRequest request) {
		String token = resolveToken(request);
		if (token != null && validateToken(token)) {
			String userName = getUserName(token);
			if (userName != null) {
				UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
				return new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
			}
		}
		return null;
	}

	private String resolveToken(HttpServletRequest request) {
		String bearerToken = request.getHeader(AUTHORIZATION);
		if (bearerToken != null && bearerToken.startsWith(PREFIX)) {
			return bearerToken.replace(PREFIX, EMPTY).trim();
		}
		return null;
	}

	private String getUserName(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
	}

	private boolean validateToken(String token) {
		try {
			Jws<Claims> claimsJws = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);

			if (claimsJws.getBody().getExpiration().before(new Date())) {
				return false;
			}
			return true;
		} catch (JwtException | IllegalArgumentException ex) {
			throw new IllegalArgumentException("Expired aor Invalid JWT token");
		}
	}
}
