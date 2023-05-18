package com.berzinc.pettracker.vaccinations; 

import java.util.List;
 
import jakarta.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.berzinc.pettracker.pets.Pet;
import com.berzinc.pettracker.pets.PetRepository;

@Service
public class VaccinationService {
    @Autowired
    private VaccinationRepository vaccinationRepository;
    
    @Autowired
    private PetRepository PetRepository;

    public List<Vaccination> listAllVaccinations() {
        return vaccinationRepository.findAll();
    }
     
    public Vaccination createVaccination(VaccinationRequest vaccinationRequest) {
        Pet pet = PetRepository.findByName(vaccinationRequest.getPetName());
        if(pet == null) {
            throw new IllegalStateException("Pet not found");
        }
        Vaccination vaccination = new Vaccination(pet, vaccinationRequest.getDate(), vaccinationRequest.getName());
    	return vaccinationRepository.save(vaccination);
    }
     
    public Vaccination getVaccination(Long id) {
        return vaccinationRepository.findById(id).get();
    }
     
    public void deleteVaccination(Long id) {
    	vaccinationRepository.deleteById(id);
    }
    
    public List<Vaccination> listVaccinationByPetName(String petName) {
        Pet pet = PetRepository.findByName(petName);
        if(pet == null) {
            throw new IllegalStateException("Pet not found");
        }
        return vaccinationRepository.findAllByPet(pet);   
    }

    public Vaccination updateVaccination(Long id, Vaccination vaccinationDetails) {
    	// Vaccination vaccination = vaccinationRepository.findById(id).get();
    	// vaccination.setPet_id(vaccinationDetails.getPet_id());
    	// vaccination.setDate(vaccinationDetails.getDate());
    	// vaccination.setName(vaccinationDetails.getName());
        
        // return vaccinationRepository.save(vaccination);  
        return null;                              
    }
}
