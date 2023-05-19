package com.berzinc.pettracker.pets;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.berzinc.pettracker.users.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface PetRepository extends JpaRepository<Pet, Long> {
    Pet findByName(String name);
    List<Pet> findAllByUser(User user);
}
