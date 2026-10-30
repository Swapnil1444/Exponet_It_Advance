package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String username;
	private String email;
	private String phoneNo;
	private String city;
	
	private Gender gender;
	
	private int age;
	public int getId() {
		return id;
	}
	
	
	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
	    return "User {" +
	            "\n  ID       : " + id +
	            "\n  Username : " + username +
	            "\n  Email    : " + email +
	            "\n  Phone No : " + phoneNo +
	            "\n  City     : " + city +
	            "\n  Gender   : " + gender +
	            "\n  Age      : " + age +
	            "\n}";
	}
	
	
}
