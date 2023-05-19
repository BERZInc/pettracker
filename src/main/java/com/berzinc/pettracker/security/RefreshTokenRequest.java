package com.berzinc.pettracker.security;

public class RefreshTokenRequest {
    
    private String refreshToken;

    public RefreshTokenRequest(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public RefreshTokenRequest() {
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    @Override
    public String toString() {
        return "RefreshTokenRequest [refreshToken=" + refreshToken + "]";
    }
}
