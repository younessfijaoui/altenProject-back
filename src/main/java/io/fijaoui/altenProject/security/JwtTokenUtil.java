package io.fijaoui.altenProject.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

@Component
public class JwtTokenUtil {

	@Value("${security.jwt.token.secret}")
	private String jwtSecret;

	@Value("${security.jwt.token.expiration}")
	private int jwtExpiration;


	public String generateToken(Authentication authentication) {
		byte[] secretKeyBytes = "ThisIsA256BitStrongSecretKeyForHS256".getBytes(StandardCharsets.UTF_8);
		SecretKey jwtSecretKey = new SecretKeySpec(secretKeyBytes, SignatureAlgorithm.HS256.getJcaName());

		String jwtToken = Jwts.builder()
				.setSubject(authentication.getName())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
				.signWith(jwtSecretKey)
				.compact();
		return jwtToken;
	}


	public String getUserNameFromToken(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(jwtSecret)
				.build()
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}


	public boolean validateToken(String token, Authentication authentication) {
		String username = getUserNameFromToken(token);
		return (username.equals(authentication.getName()) && !isTokenExpired(token));
	}


	private boolean isTokenExpired(String token) {
		Date expiration = Jwts.parserBuilder()
				.setSigningKey(jwtSecret)
				.build()
				.parseClaimsJws(token)
				.getBody()
				.getExpiration();
		return expiration.before(new Date());
	}

	public String getUsername(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

}