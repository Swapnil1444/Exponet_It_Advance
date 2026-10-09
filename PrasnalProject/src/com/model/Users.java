package com.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String UserName;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String role;
	private LocalDateTime AccountCreatingTime;

	public Users() {
		// TODO Auto-generated constructor stub
	}
	
	public Users(String firstName, String lastName, String email, String userName, String password, String role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		UserName = userName;
		this.password = password;
		this.role = role;
		AccountCreatingTime = LocalDateTime.now();
	}
	
	

	public Users(int id, String firstName, String lastName, String email, String userName, String password, String role,
			LocalDateTime accountCreatingTime) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		UserName = userName;
		this.password = password;
		this.role = role;
		AccountCreatingTime = accountCreatingTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDateTime getAccountCreatingTime() {
		return AccountCreatingTime;
	}
	
	public String getFullName() {
		return firstName+" "+lastName;
	}

	public void setAccountCreatingTime(LocalDateTime accountCreatingTime) {
		AccountCreatingTime = accountCreatingTime;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", UserName=" + UserName + ", password=" + password + ", role=" + role + ", AccountCreatingTime="
				+ AccountCreatingTime + "]";
	}
	

}
