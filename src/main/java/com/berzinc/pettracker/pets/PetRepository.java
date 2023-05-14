package com.berzinc.pettracker.pets;

import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface PetRepository extends JpaRepository<Pet, Long> {

}
