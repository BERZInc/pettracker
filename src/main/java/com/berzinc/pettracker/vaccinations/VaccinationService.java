package com.berzinc.pettracker.vaccinations; 

import java.util.List;
 
import jakarta.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class VaccinationService {
    @Autowired
    private VaccinationRepository vaccinationRepository;
    
    public List<Vaccination> listAllVaccinations() {
        return vaccinationRepository.findAll();
    }
     
    public Vaccination createVaccination(Vaccination vaccination) {
    	return vaccinationRepository.save(vaccination);
    }
     
    public Vaccination getVaccination(Long id) {
        return vaccinationRepository.findById(id).get();
    }
     
    public void deleteVaccination(Long id) {
    	vaccinationRepository.deleteById(id);
    }
    
    public Vaccination updateVaccination(Long id, Vaccination vaccinationDetails) {
    	Vaccination vaccination = vaccinationRepository.findById(id).get();
    	vaccination.setPet_id(vaccinationDetails.getPet_id());
    	vaccination.setDate(vaccinationDetails.getDate());
    	vaccination.setName(vaccinationDetails.getName());
        
        return vaccinationRepository.save(vaccination);                                
    }
}
