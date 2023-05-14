package com.berzinc.pettracker.vaccinations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.berzinc.pettracker.security.Credentials;

@RestController
@RequestMapping(path="/api")
public class VaccinationController {
    
    @Autowired
    private VaccinationService vaccinationService;
    
    @RequestMapping(value="/vaccinations", method=RequestMethod.POST)
    public Vaccination createVaccination(@RequestBody Vaccination vaccination) {
        return vaccinationService.createVaccination(vaccination);
    }
    
    @RequestMapping(value="/vaccinations", method=RequestMethod.GET)
    public List<Vaccination> listAllVaccinations() {
        return vaccinationService.listAllVaccinations();
    }

    @RequestMapping(value="/vaccinations/{id}", method=RequestMethod.PUT)
    public Vaccination updateVaccination(@PathVariable(value = "id") Long id, @RequestBody Vaccination vaccinationDetails) {
        return vaccinationService.updateVaccination(id, vaccinationDetails);
    }

    @RequestMapping(value="/vaccinations/{id}", method=RequestMethod.DELETE)
    public void deleteVaccination(@PathVariable(value = "id") Long id) {
    	vaccinationService.deleteVaccination(id);
    }
}
