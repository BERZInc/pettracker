package com.berzinc.pettracker.vaccinations;


import com.berzinc.pettracker.pets.Pet;
import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**		
 * 
 * @author Erik Ziegler
 *
 */
@Entity
@Table(name = "vaccinations")
public class Vaccination {
  @Id
  @Column(name="vaccination_id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name="pet_id", nullable=false)
  @JsonIgnore
  private Pet pet;
  
  @Column(name="date", nullable=false)
  private String date;
  
  @Column(name="vaccName", nullable=false)
  private String vaccName;

  public Vaccination(Pet pet, String date, String vaccName) {
	    this.pet = pet;
	    this.date = date;
	    this.vaccName = vaccName;
	  }

  public Vaccination(){}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public Pet getPet() {
	return pet;
}

public void setPet(Pet pet) {
	this.pet = pet;
}

public String getVaccName() {
	return vaccName;
}

public void setVaccName(String vaccName) {
	this.vaccName = vaccName;
}


}