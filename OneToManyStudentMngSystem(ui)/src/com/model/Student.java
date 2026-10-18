package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sId;
	private String name;
	private String phoneNo;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private int age;
	private String address;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Student_Subject",joinColumns = @JoinColumn(name ="Stude_Id"),inverseJoinColumns = @JoinColumn(name="Sub_Id"))
	List<Subject> subList;

	
	public int getsId() {
		return sId;
	}


	public void setsId(int sId) {
		this.sId = sId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public List<Subject> getSubList() {
		return subList;
	}


	public void setSubList(List<Subject> subList) {
		this.subList = subList;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "Student [sId=" + sId + ", name=" + name + ", phoneNo=" + phoneNo + ", gender=" + gender + ", age=" + age
				+ ", address=" + address + ", subList=" + subList + "]";
	}


	
	
}
