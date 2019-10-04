package com.badwitsoftware.flightreservation.user;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "users")
public final class User implements Serializable {
	private static final long serialVersionUID = 3173173602116696373L;
	@Id
	@GeneratedValue
	@Column(updatable = false)
	private Long id;

	@Column(name = "first")
	private String firstName;

	@Column(name = "last")
	private String lastName;

	@Email
	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "password")
	private String password;

	@ManyToMany
	private Set<Role> roles;

	public Long getId() {
		return id;
	}

	void setId(Long id) {
		this.id = id;
	}

	 String getFirstName() {
		return firstName;
	}

	void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	 String getLastName() {
		return lastName;
	}

	void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	void setEmail(String email) {
		this.email = email;
	}

	 String getPassword() {
		return password;
	}

	void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	void setRoles(Set<Role> userRoles) {
		this.roles = userRoles;
	}
}