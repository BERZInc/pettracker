package com.berzinc.pettracker.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.berzinc.pettracker.security.Credentials;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByCredentials(Credentials credentials);
}
