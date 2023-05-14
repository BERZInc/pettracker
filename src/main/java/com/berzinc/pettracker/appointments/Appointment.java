package com.berzinc.pettracker.appointments;

import java.sql.Date;
import java.sql.Time;

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
@Table(name = "appointments")
public class Appointment {
  @Id
  @Column(name="appointment_id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @Column(name="user_id", nullable=false)
  private Long user_id;

  @Column(name="pet_id", nullable=false)
  private Long pet_id;
  
  @Column(name="vet_id", nullable=false)
  private Long vet_id;
  
  @Column(name="date", nullable=false)
  private Date date;
  
  @Column(name="time", nullable=false)
  private Time time;

  public Appointment(Long user_id, Long pet_id, Long vet_id, Date date, Time time) {
    this.user_id = user_id;
    this.pet_id = pet_id;
    this.vet_id = vet_id;
    this.date = date;
    this.time = time;
  }

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Long getUser_id() {
	return user_id;
}

public void setUser_id(Long user_id) {
	this.user_id = user_id;
}

public Long getPet_id() {
	return pet_id;
}

public void setPet_id(Long pet_id) {
	this.pet_id = pet_id;
}

public Long getVet_id() {
	return vet_id;
}

public void setVet_id(Long vet_id) {
	this.vet_id = vet_id;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public Time getTime() {
	return time;
}

public void setTime(Time time) {
	this.time = time;
}

}