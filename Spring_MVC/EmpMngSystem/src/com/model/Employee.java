package com.model;

public class Employee {
	
	private String fullname;
	private String email;
	private String username;
	private String pasword;
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	@Override
	public String toString() {
		return "Employee [fullname=" + fullname + ", email=" + email + ", username=" + username + ", pasword=" + pasword
				+ "]";
	}
	
	

}
