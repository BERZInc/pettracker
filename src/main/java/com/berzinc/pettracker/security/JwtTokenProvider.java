package com.berzinc.pettracker.security;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.berzinc.pettracker.users.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {

    //from application.properties
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expirationms}")
    private int jwtExpirationMs;

    public AccessToken generateJwtToken(User user) {
        Date expiration = new Date((new Date()).getTime() + jwtExpirationMs);

        Claims claims = Jwts.claims().setSubject(user.getUsername());
        claims.put("roles", user.getRoles().stream().map(role ->new SimpleGrantedAuthority(role.getAuthority()))
                                        .filter(Objects::nonNull)
                                        .collect(Collectors.toList()));

        String token = Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(new Date())
            .setExpiration(expiration)
            .signWith(SignatureAlgorithm.HS512, jwtSecret)
            .compact();

        return new AccessToken(token, expiration);
    }

    public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			System.out.println("Invalid JWT signature: " + e.getMessage());
		} catch (MalformedJwtException e) {
            System.out.println("Invalid JWT token: " + e.getMessage());
		} catch (ExpiredJwtException e) {
            System.out.println("JWT token is expired: " + e.getMessage());
		} catch (UnsupportedJwtException e) {
            System.out.println("JWT token is unsupported: " + e.getMessage());
		} catch (IllegalArgumentException e) {
            System.out.println("JWT claims string is empty: " + e.getMessage());
		}

		return false;
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    @SuppressWarnings("unchecked")
    public List<GrantedAuthority> getRoles(String token) {
        List<Map<String, String>>  roleClaims = Jwts.parser().setSigningKey(jwtSecret)
                .parseClaimsJws(token).getBody().get("roles", List.class);
        return roleClaims.stream().map(roleClaim ->
                new SimpleGrantedAuthority(roleClaim.get("authority")))
                .collect(Collectors.toList());
    }

}