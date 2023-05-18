package com.berzinc.pettracker.vaccinations;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.berzinc.pettracker.pets.Pet;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface VaccinationRepository extends JpaRepository<Vaccination, Long> {
    List<Vaccination> findAllByPet(Pet pet);
}
