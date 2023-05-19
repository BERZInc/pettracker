package com.berzinc.pettracker.vaccinations;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.berzinc.pettracker.pets.Pet;

/**		
 * 
 * @author Erik Ziegler
 *
 */

public interface VaccinationRepository extends JpaRepository<Vaccination, Long> {
}
