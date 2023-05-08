package com.berzinc.pettracker.users;

public class RegisterUserRequest {
    
    private final String userName;
    private final String firstName;
    private final String lastName;
    private final String password;
    private final Roles role;

    public RegisterUserRequest(String userName, String firstName, String lastName, String password, Roles role) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
    }

    public String getUserName() {
        return userName;
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
        return "{\"userName\":"+ userName + ","+ 
        "\"firstName\":" + firstName + "," +
        "\"lastName\":" + lastName + "," +
        "\"role\":\"" + role.name() + "\"}";
    }


}
