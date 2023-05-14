package com.berzinc.pettracker.users; 

import java.util.List;
 
import jakarta.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }
     
    public User createUser(User user) {
    	return userRepository.save(user);
    }
     
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }
     
    public void deleteUser(Long id) {
    	userRepository.deleteById(id);
    }
    
    public User updateUser(Long id, User userDetails) {
    	User user = userRepository.findById(id).get();
    	user.setFirstName(userDetails.getFirstName());
    	user.setLastName(userDetails.getLastName());
    	user.setCredentials(userDetails.getCredentials());
        
        return userRepository.save(user);                                
    }
}
