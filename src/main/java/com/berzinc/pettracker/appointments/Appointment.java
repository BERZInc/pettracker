package com.berzinc.pettracker.appointments;

import com.berzinc.pettracker.users.User;
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
@Table(name = "appointments")
public class Appointment {
  @Id
  @Column(name="appointment_id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @Column(name="fullName", nullable=false)
  private String fullName;

  @Column(name="petName", nullable=false)
  private String petName;
  
  @Column(name="vetName", nullable=false)
  private String vetName;
  
  @Column(name="date", nullable=false)
  private String date;
  
  @Column(name="time", nullable=false)
  private String time;
  
  @Column(name="notes", nullable=false)
  private String notes;

  @ManyToOne
  @JoinColumn(name="user_id", nullable=false)
  @JsonIgnore
  private User user;

  public Appointment() {}
  
  public Appointment(String fullName, String petName, String vetName, String date, String time) {
    this.fullName = fullName;
    this.petName = petName;
    this.vetName = vetName;
    this.date = date;
    this.time = time;
    this.notes = "";
  }

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getFullName() {
	return fullName;
}

public void setFullName(String fullName) {
	this.fullName = fullName;
}

public String getPetName() {
	return petName;
}

public void setPetName(String petName) {
	this.petName = petName;
}

public String getVetName() {
	return vetName;
}

public void setVetName(String vetName) {
	this.vetName = vetName;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public String getTime() {
	return time;
}

public void setTime(String time) {
	this.time = time;
}

public String getNotes() {
	return notes;
}

public void setNotes(String notes) {
	this.notes = notes;
}

public User getUser() {
  return user;
}

public void setUser(User user) {
  this.user = user;
}

}