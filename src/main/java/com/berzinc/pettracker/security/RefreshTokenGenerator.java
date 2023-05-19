package com.berzinc.pettracker.security;

import java.util.UUID;
import java.util.function.Function;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.berzinc.pettracker.users.User;


@Component
public class RefreshTokenGenerator implements Function<User, RefreshToken> {

    @Value("${jwt.refresh.expirationms}")
    private long jwtRefreshExpirationMs;
    
    @Override
    public RefreshToken apply(User user) {
        Date expiration = new Date((new Date()).getTime() + jwtRefreshExpirationMs);
        return new RefreshToken(UUID.randomUUID().toString(), expiration, user);
    }
    
}
