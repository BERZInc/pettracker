package com.berzinc.pettracker.users;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.berzinc.pettracker.security.Credentials;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Users")
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

  @OneToMany(mappedBy = "user", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
  // @JsonManagedReference
  private Set<UserRole> userRoles;

  public User(Builder builder) {
    this.firstName = builder.values.get("firstName");
    this.lastName = builder.values.get("lastName");
    Credentials credentials = new Credentials(builder.values.get("userName"), builder.values.get("password"));
    this.credentials = credentials;
    this.userRoles = builder.roles.stream().map(role -> new UserRole(role, this)).collect(Collectors.toSet());
  }

  public User(){
    this.firstName = "";
    this.lastName = "";
    this.credentials = new Credentials();
    this.userRoles = new HashSet<>();
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

  @JsonIgnore
  public String getPassword() {
    return credentials.getPassword();
  }

  @Override
  public String toString() {
    String roles = userRoles.stream()
      .map(userRole -> 
        "\""+ userRole.getRole().name()+ "\"")
      .collect(Collectors.joining(","));
      // .reduce(",", String::concat);
    return "{\"username\":\""+ credentials.getUsername() + "\","
      + "\"firstName\":\"" + firstName + "\","
      + "\"lastName\":\"" + lastName + "\","
      + "\"roles\":[" + roles +"]}"; 
  }

  public static class Builder {

    private Set<Roles> roles = new HashSet<>();
    private Map<String, String> values = new HashMap<>();

    public Builder() {}

    public Builder setUsername(String userName) {
      values.put("userName", userName);
      return this;
    }

    public Builder setFirstName(String firstName) {
      values.put("firstName", firstName);
      return this;
    }

    public Builder setLastName(String lastName) {
      values.put("lastName", lastName);
      return this;
    }

    public Builder setPassword(String password) {
      values.put("password", password);
      return this;
    }

    public Builder addRole(Roles role) {
      roles.add(role);
      return this;
    }

    public User build() {
      return new User(this);
    }

  }


}