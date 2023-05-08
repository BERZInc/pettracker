package com.berzinc.pettracker.security;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RefreshToken {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable= false, unique=true)
    private String token;

    @Column(nullable=false)
    private Instant expireData;

    public RefreshToken(String token, Instant expireData) {
        this.token = token;
        this.expireData = expireData;
    }

    public RefreshToken() {
    }

    public long getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public Instant getExpireData() {
        return expireData;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((token == null) ? 0 : token.hashCode());
        result = prime * result + ((expireData == null) ? 0 : expireData.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RefreshToken other = (RefreshToken) obj;
        if (id != other.id)
            return false;
        if (token == null) {
            if (other.token != null)
                return false;
        } else if (!token.equals(other.token))
            return false;
        if (expireData == null) {
            if (other.expireData != null)
                return false;
        } else if (!expireData.equals(other.expireData))
            return false;
        return true;
    }

}
