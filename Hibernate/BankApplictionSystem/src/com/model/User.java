package com.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private LocalDateTime lastLogin;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adhar_Id")
	private Accountdetails accountdetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Accountdetails getAccountdetails() {
		return accountdetails;
	}

	public void setAccountdetails(Accountdetails accountdetails) {
		this.accountdetails = accountdetails;
	}


@Override
public String toString() {
    return "{\n"
            + "  \"id\": " + id + ",\n"
            + "  \"username\": \"" + username + "\",\n"
            + "  \"password\": \"********\",\n"
            + "  \"lastLogin\": \"" + lastLogin + "\",\n"
            + "  \"accountdetails\": " + accountdetails + "\n"
            + "}";
}

}
