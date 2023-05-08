package com.berzinc.pettracker.users;

public interface UserService {
    public User registerUser(RegisterUserRequest registerUserRequest);
    public User getUserByUserName(String userName);
}
