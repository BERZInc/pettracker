package com.berzinc.pettracker.pets;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
/**		
 * 
 * @author Erik Ziegler
 *
 */
@Entity
@Table(name = "pets")
public class Pet {
  @Id
  @Column(name="pet_id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @Column(name="name", nullable=false)
  private String name;

  @Column(name="age", nullable=false)
  private String age;
  
  @Column(name="species", nullable=false)
  private String species;
  
  @Column(name="color", nullable=false)
  private String color;
  
  @Column(name="breed", nullable=false)
  private String breed;
  
  @Column(name="height", nullable=false)
  private Double height;
  
  @Column(name="weight", nullable=false)
  private Double weight; 


  public Pet() {}

  public Pet(String name, String species, String color, String breed, Double height, Double weight) {
    this.name = name;
    this.species = species;
    this.color = color;
    this.breed = breed;
    this.height = height;
    this.weight = weight;
  }

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAge() {
	return age;
}

public void setAge(String age) {
	this.age = age;
}

public String getSpecies() {
	return species;
}

public void setSpecies(String species) {
	this.species = species;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public String getBreed() {
	return breed;
}

public void setBreed(String breed) {
	this.breed = breed;
}

public Double getHeight() {
	return height;
}

public void setHeight(Double height) {
	this.height = height;
}

public Double getWeight() {
	return weight;
}

public void setWeight(Double weight) {
	this.weight = weight;
}

}