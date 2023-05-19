package com.berzinc.pettracker.pets;

import org.springframework.data.jpa.repository.JpaRepository;

/**		
 * 
 * @author Erik Ziegler
 *
 */

public interface PetRepository extends JpaRepository<Pet, Long> {
    Pet findByName(String name);
}
