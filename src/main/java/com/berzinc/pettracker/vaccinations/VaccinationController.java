package com.berzinc.pettracker.vaccinations;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

/**		
 * 
 * @author Erik Ziegler
 *
 */
@RestController
@RequestMapping(path="/api")
public class VaccinationController {
    
    @Autowired
    private VaccinationService vaccinationService;

    @CrossOrigin
    @RequestMapping(value="/vaccinations", method=RequestMethod.POST)
    public Vaccination createPet(@RequestBody VaccinationRequest vaccination) {
        return vaccinationService.createVaccination(vaccination);
    }
    
    @CrossOrigin
    @RequestMapping(value="/vaccinations", method=RequestMethod.GET)
    public List<Vaccination> listAllVaccinations(Principal principal) {
        return vaccinationService.listAllVaccinations(principal.getName());
    }

    @CrossOrigin
    @RequestMapping(value="/vaccinations/{id}", method=RequestMethod.PUT)
    public Vaccination updateVaccination(@PathVariable(value = "id") Long id, @RequestBody VaccinationRequest vaccination) {
        return vaccinationService.updateVaccination(id, vaccination);
    }

    @RequestMapping(value="/vaccinations/{id}", method=RequestMethod.DELETE)
    public void deletePet(@PathVariable(value = "id") Long id) {
    	vaccinationService.deleteVaccination(id);
    }
}
