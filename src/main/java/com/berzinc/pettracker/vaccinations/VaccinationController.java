package com.berzinc.pettracker.vaccinations;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.berzinc.pettracker.security.Credentials;

@RestController
@RequestMapping(path="/api")
public class VaccinationController {
    
    @Autowired
    private VaccinationService vaccinationService;

    @CrossOrigin
    @RequestMapping(value="/vaccinations", method=RequestMethod.POST)
    public ResponseEntity<?> createVaccination(@RequestBody VaccinationRequest vaccinationRequest) {
        try {
            Vaccination newVaccination = vaccinationService.createVaccination(vaccinationRequest);    
            return ResponseEntity.ok(newVaccination);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        
    }

    @CrossOrigin
    @RequestMapping(value="/vaccinations/pet", method=RequestMethod.GET)
    public ResponseEntity<?> listPetVaccinations(@RequestParam String petName) {
        try {
            List<Vaccination> vaccinations = vaccinationService.listVaccinationByPetName(petName);   
            return ResponseEntity.ok(vaccinations);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @CrossOrigin
    @RequestMapping(value="/vaccinations", method=RequestMethod.GET)
    public List<Vaccination> listAllVaccinations() {
        return vaccinationService.listAllVaccinations();
    }

    @CrossOrigin
    @RequestMapping(value="/vaccinations/{id}", method=RequestMethod.PUT)
    public Vaccination updateVaccination(@PathVariable(value = "id") Long id, @RequestBody Vaccination vaccinationDetails) {
        return vaccinationService.updateVaccination(id, vaccinationDetails);
    }

    @RequestMapping(value="/vaccinations/{id}", method=RequestMethod.DELETE)
    public void deleteVaccination(@PathVariable(value = "id") Long id) {
    	vaccinationService.deleteVaccination(id);
    }
}
