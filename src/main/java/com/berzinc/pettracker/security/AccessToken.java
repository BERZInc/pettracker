package com.berzinc.pettracker.security;

import java.util.Date;

public class AccessToken {
    
    private final String token;
    private final Date expirationDate;

    public AccessToken(String token, Date expiration) {
        this.token = token;
        this.expirationDate = expiration;
    }

    public String getToken() {
        return token;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

}

