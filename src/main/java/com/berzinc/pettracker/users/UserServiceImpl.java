package com.berzinc.pettracker.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.berzinc.pettracker.security.Credentials;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public User registerUser(RegisterUserRequest registerUserRequest) {

        User newUser = new User.Builder()
        .setFirstName(registerUserRequest.getFirstName())
        .setLastName(registerUserRequest.getLastName())
        .setUsername(registerUserRequest.getUserName())
        .setPassword(registerUserRequest.getPassword())
        .addRole(registerUserRequest.getRole())
        .build();

      logger.trace("storing user in database : {}", newUser);
      return userRepository.save(newUser);
    }

    @Override
    public User getUserByUserName(String userName) {

        return userRepository.findUserByCredentials(new Credentials(userName, null)).orElse(null);

    }
    
}
