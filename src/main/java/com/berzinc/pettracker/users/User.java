package com.berzinc.pettracker.users;

import com.berzinc.pettracker.security.Credentials;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class User {
  @Id
  @Column(name="user_id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name="first_name", nullable=false)
  private final String firstName;

  @Column(name="last_name", nullable=false)
  private final String lastName;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_name")
  private final Credentials credentials;

  public User(String firstName, String lastName, Credentials credentials) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.credentials = credentials;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getUsername() {
    return credentials.getUsername();
  }

  public String getPassword() {
    return credentials.getPassword();
  }

}