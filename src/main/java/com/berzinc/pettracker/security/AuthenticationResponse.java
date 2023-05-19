package com.berzinc.pettracker.security;

import java.util.List;

public class AuthenticationResponse {
    
    private long id;
    private String username;
    private AccessToken accessToken;
    private RefreshToken refreshToken;
    private String tokenType = "Bearer";
    private List<String> roles;

    public AuthenticationResponse(
        AccessToken accessToken, 
        RefreshToken refreshToken,
        long id,
        String username,
        List<String> roles) {
        this.refreshToken = refreshToken;
        this.accessToken = accessToken;
        this.id = id;
        this.username = username;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public AccessToken getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public List<String> getRoles() {
        return roles;
    }

    public RefreshToken getRefreshToken() {
        return refreshToken;
    }
}
