package com.berzinc.pettracker.users;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserRoles")
public class UserRole {
    
    @Id
    @Column(name="user_role_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name="user_role_value")
    private String role;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id", nullable=false)
    @OnDelete(action=OnDeleteAction.CASCADE)
    private User user;

    public UserRole(Roles role, User user) {
        this.role = role.name();
        this.user = user;
    }

    public UserRole(Roles role) {
        this.role = role.name();
        this.user = new User();
    }

    public UserRole() {
    }

    public long getId() {
        return id;
    }

    public Roles getRole() {
        return Roles.valueOf(role);
    }

    public User getUser() {
        return user;
    }
}
