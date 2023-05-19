package com.berzinc.pettracker.security;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable{
    
    private static final long serialVersionUID = 111;

    private final String username;
    private final String password;

    public AuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    
}