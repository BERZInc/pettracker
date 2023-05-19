package com.berzinc.pettracker.users;

import com.berzinc.pettracker.security.Credentials;

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

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_name")
  private Credentials credentials;

  public User(String firstName, String lastName, Credentials credentials) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.credentials = credentials;
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
    return credentials.getUsername();
  }

  public String getPassword() {
    return credentials.getPassword();
  }
	
	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

}