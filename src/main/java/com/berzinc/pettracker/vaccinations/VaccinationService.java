package com.berzinc.pettracker.vaccinations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.berzinc.pettracker.pets.Pet;
import com.berzinc.pettracker.pets.PetRepository;
import com.berzinc.pettracker.users.User;
import com.berzinc.pettracker.users.UserRepository;
/**		
 * 
 * @author Erik Ziegler
 *
 */
@Service
public class VaccinationService {
	@Autowired
	private VaccinationRepository vaccinationRepository;

	@Autowired
    private PetRepository petRepository;

	@Autowired
    private UserRepository userRepository;

	public List<Vaccination> listAllVaccinations(String username) {

		User user = userRepository.findByUsername(username)
			.orElseThrow(() -> new IllegalStateException("user not found " + username));
		List<Pet> pets = petRepository.findAllByUser(user);

		List<Vaccination> vaccinations = new ArrayList<>();
		
		pets.stream()
			.forEach(pet -> vaccinationRepository.findAllByPet(pet)
				.forEach(vaccinations::add));

		return vaccinations;
	}

	public Vaccination createVaccination(VaccinationRequest vaccinationRequest) {
		Pet pet = petRepository.findByName(vaccinationRequest.getPetName());
		Vaccination vaccination = new Vaccination(pet, vaccinationRequest.getDate(), vaccinationRequest.getVaccName());
		return vaccinationRepository.save(vaccination);
	}

	public Vaccination getVaccination(Long id) {
		return vaccinationRepository.findById(id).get();
	}

	public void deleteVaccination(Long id) {
		vaccinationRepository.deleteById(id);
	}

	public Vaccination updateVaccination(Long id, VaccinationRequest vaccinationRequest) {
		Pet pet = petRepository.findByName(vaccinationRequest.getPetName());
		Vaccination vaccination = vaccinationRepository.findById(id).get();

		vaccination.setVaccName(vaccinationRequest.getVaccName());
		vaccination.setPet(pet);
		vaccination.setDate(vaccinationRequest.getDate());

		return vaccinationRepository.save(vaccination);
	}
}
