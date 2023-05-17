package com.berzinc.pettracker.pets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.berzinc.pettracker.security.Credentials;

@RestController
@RequestMapping(path="/api")
public class PetController {
    
    @Autowired
    private PetService petService;
    
    @CrossOrigin
    @RequestMapping(value="/pets", method=RequestMethod.POST)
    public Pet createPet(@RequestBody Pet pet) {
        System.out.println(pet);
        return petService.createPet(pet);
    }
    
    @CrossOrigin
    @RequestMapping(value="/pets", method=RequestMethod.GET)
    public List<Pet> listAllPets() {
        return petService.listAllPets();
    }

    @CrossOrigin
    @RequestMapping(value="/pets/{id}", method=RequestMethod.PUT)
    public Pet updatePet(@PathVariable(value = "id") Long id, @RequestBody Pet petDetails) {
        return petService.updatePet(id, petDetails);
    }

    @RequestMapping(value="/pets/{id}", method=RequestMethod.DELETE)
    public void deletePet(@PathVariable(value = "id") Long id) {
    	petService.deletePet(id);
    }
}
