package com.berzinc.pettracker.users;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "users")
public class User {
  @Id
  @Column(name="user_id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @Column(name="first_name", nullable=false)
  private String firstName;

  @Column(name="last_name", nullable=false)
  private String lastName;

  @Column(name="username", nullable = false)
  private String username;

  @JsonIgnore
  @Column(name="password", nullable = false)
  private String password;

  @OneToMany()
  private List<UserRole> roles;

  public User(){}

  public User(String usermame, String password, String firstName, String lastName, UserRole role) {
    this.username = usermame;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.roles = Arrays.asList(role);
  }

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

  public String getFirstName() {
    return firstName;
  }
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

  public String getLastName() {
    return lastName;
  }

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public List<UserRole> getRoles() {
    return roles;
  }

}