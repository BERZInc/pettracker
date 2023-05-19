package com.berzinc.pettracker.pets; 

import java.util.List;
 
import jakarta.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
/**		
 * 
 * @author Erik Ziegler
 *
 */
@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;
    
    public List<Pet> listAllPets() {
        return petRepository.findAll();
    }
    
    @CrossOrigin
    public Pet createPet(Pet pet) {
    	return petRepository.save(pet);
    }
     
    public Pet getPet(Long id) {
        return petRepository.findById(id).get();
    }
     
    public void deletePet(Long id) {
    	petRepository.deleteById(id);
    }
    
    public Pet updatePet(Long id, Pet petDetails) {
    	Pet pet = petRepository.findById(id).get();
    	pet.setName(petDetails.getName());
    	pet.setAge(petDetails.getAge());
    	pet.setSpecies(petDetails.getSpecies());
    	pet.setColor(petDetails.getColor());
    	pet.setBreed(petDetails.getBreed());
    	pet.setHeight(petDetails.getHeight());
    	pet.setWeight(petDetails.getWeight());
        
        return petRepository.save(pet);                                
    }
}
