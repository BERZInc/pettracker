package com.berzinc.pettracker.security;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Credentials {
    
    @Id
    @Column(name="credentials_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name="user_name", unique=true)
    private final String userName;
    private final String password;

    public Credentials(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUsername() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

}
