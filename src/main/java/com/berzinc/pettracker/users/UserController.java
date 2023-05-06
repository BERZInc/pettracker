package com.berzinc.pettracker.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.berzinc.pettracker.security.Credentials;

@RestController
@RequestMapping(path="/users")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    // @PostMapping(path="/register")
    // public ResponseEntity<Object> addNewUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String username, @RequestParam String password) {
        
    //     Credentials credentials = new Credentials(username, password); 
    //     User user = new User(firstName, lastName, credentials);

    //     userRepository.save(user);
    //     return ResponseEntity.status(201).build();
    // }

    @PostMapping(
      path="/register",
      consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<Object> addNewUser(User user) {
        
        // Credentials credentials = new Credentials(username, password); 
        // User user = new User(firstName, lastName, credentials);

        userRepository.save(user);
        return ResponseEntity.status(201).build();
    }


    @GetMapping(path="/")
    public @ResponseBody Iterable<User> getAllUsers() {
      return userRepository.findAll();
    }

}
