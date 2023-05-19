package com.berzinc.pettracker.vaccinations;

import java.sql.Date;

import com.berzinc.pettracker.pets.Pet;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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

  @Column(name="petName", nullable=false)
  private String petName;
  
  @Column(name="date", nullable=false)
  private String date;
  
  @Column(name="vaccName", nullable=false)
  private String vaccName;

  public Vaccination(String petName, String date, String vaccName) {
	    this.petName = petName;
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

public String getPetName() {
	return petName;
}

public void setPetName(String petName) {
	this.petName = petName;
}

public String getVaccName() {
	return vaccName;
}

public void setVaccName(String vaccName) {
	this.vaccName = vaccName;
}


}