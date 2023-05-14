package com.berzinc.pettracker.vaccinations;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@Table(name = "vaccinations")
public class Vaccination {
  @Id
  @Column(name="vaccination_id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @Column(name="pet_id", nullable=false)
  private Long pet_id;
  
  @Column(name="date", nullable=false)
  private Date date;
  
  @Column(name="name", nullable=false)
  private String name;

  public Vaccination(Long pet_id, Date date, String name) {
    this.pet_id = pet_id;
    this.date = date;
    this.name = name;
  }

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Long getPet_id() {
	return pet_id;
}

public void setPet_id(Long pet_id) {
	this.pet_id = pet_id;
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