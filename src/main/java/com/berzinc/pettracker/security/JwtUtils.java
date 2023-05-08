package com.berzinc.pettracker.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.berzinc.pettracker.users.Roles;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
    
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expirationms}")
    private int jwtExpirationMs;

    public String generateAccessToken(Roles role) {
        return Jwts.builder().setSubject(role.name()).setIssuedAt(new Date())
        .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs)).signWith(SignatureAlgorithm.HS512, jwtSecret)
        .compact();
    }
}


// jwt.refresh.expirationms=86400