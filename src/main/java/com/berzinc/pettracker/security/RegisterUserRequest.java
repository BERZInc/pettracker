package com.berzinc.pettracker.security;

import com.berzinc.pettracker.users.Roles;

public class RegisterUserRequest {
    
    private final String username;
    private final String firstName;
    private final String lastName;
    private final String password;
    private final Roles role;

    public RegisterUserRequest(String username, String firstName, String lastName, String password, Roles role) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public String getPassword() {
        return password;
    }

    public Roles getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "{\"userName\":"+ username + ","+ 
        "\"firstName\":" + firstName + "," +
        "\"lastName\":" + lastName + "," +
        "\"role\":\"" + role.name() + "\"}";
    }

}
