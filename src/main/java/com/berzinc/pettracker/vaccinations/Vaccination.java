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

@Entity
@Table(name = "vaccinations")
public class Vaccination {
  @Id
  @Column(name="vaccination_id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @ManyToOne()
  @JoinColumn(name="pet_id")
  //@JsonIgnore
  private Pet pet;
  
  @Column(name="date", nullable=false)
  private Date date;
  
  @Column(name="name", nullable=false)
  private String name;

  public Vaccination(Pet pet, Date date, String name) {
    this.pet = pet;
    this.date = date;
    this.name = name;
  }

  public Vaccination(){}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Pet getPet() {
	return pet;
}

public void setPet(Pet pet) {
	this.pet = pet;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

}