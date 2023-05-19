package com.berzinc.pettracker.security;

import java.util.Date;

import com.berzinc.pettracker.users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="refresh_tokens")
public class RefreshToken {
    
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable= false, unique=true)
    private String token;

    @Column(nullable=false)
    private Date expirationDate;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "user", referencedColumnName = "user_id")
    private User user;

    public RefreshToken(String token, Date expireData, User user) {
        this.token = token;
        this.expirationDate = expireData;
        this.user = user;
    }

    public RefreshToken() {
    }

    public long getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

}
