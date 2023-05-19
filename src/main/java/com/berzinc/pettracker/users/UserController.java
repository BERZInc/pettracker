package com.berzinc.pettracker.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.berzinc.pettracker.security.Credentials;
/**		
 * 
 * @author Erik Ziegler
 *
 */
@RestController
@RequestMapping(path="/api")
public class UserController {
    /*
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String username, @RequestParam String passowrd) {
        
        Credentials credentials = new Credentials(username, passowrd); 
        User user = new User(firstName, lastName, credentials);

        userRepository.save(user);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
      // This returns a JSON or XML with the users
      return userRepository.findAll();
    }
    */
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value="/users", method=RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    
    @RequestMapping(value="/users", method=RequestMethod.GET)
    public List<User> listAllUsers() {
        return userService.listAllUsers();
    }

    @RequestMapping(value="/users/{id}", method=RequestMethod.PUT)
    public User updateUser(@PathVariable(value = "id") Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    @RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
    public void deleteUser(@PathVariable(value = "id") Long id) {
    	userService.deleteUser(id);
    }
}
