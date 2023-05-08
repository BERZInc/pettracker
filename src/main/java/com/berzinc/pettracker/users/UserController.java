package com.berzinc.pettracker.users;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/users")
public class UserController {
    
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping(
      path="/register",
      consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<Object> addNewUser(RegisterUserRequest registerUserRequest) {
      logger.debug("processing register user request: {}", registerUserRequest);

      User savedUser = userService.registerUser(registerUserRequest);

      URI uri = URI.create("/users/" + savedUser.getUsername());
      HttpHeaders responseHeaders = generateHttpHeaders();
      responseHeaders.setLocation(uri);

      logger.debug("registering user was successful: {}", savedUser);
      return new ResponseEntity<Object>(savedUser.toString(), responseHeaders, HttpStatus.CREATED);
    }


    // @GetMapping(path="")
    // public @ResponseBody List<User> getAllUsers() {
    //   logger.info("processing getting all users");

    //   List<User> users = userRepository.findAll();

    //   users.stream().forEach(user -> logger.info("{}", user));

    //   try {
    //     return users;
    //   } catch(Exception e) {
    //     logger.error("error trying to get all users", e);
    //     return null;
    //   }

    // }

    @PutMapping(path="/{userName}")
    public ResponseEntity<String> updateUserData(@PathVariable String userName, @RequestBody RegisterUserRequest registerUserRequest) {
      logger.debug("processing register user request: {}", registerUserRequest);


      return new ResponseEntity<String>("", generateHttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping(path="/{userName}")
    public ResponseEntity<String> getUser(@PathVariable String userName) {
      logger.debug("processing get user {} request", userName);
      User user = userService.getUserByUserName(userName);
      return new ResponseEntity<String>(user.toString(), generateHttpHeaders(), HttpStatus.OK);
    }


    private HttpHeaders generateHttpHeaders() {
      HttpHeaders responseHeaders = new HttpHeaders();
      responseHeaders.set("Content-Type", MediaType.APPLICATION_JSON.toString());
      return responseHeaders;
    }


}
