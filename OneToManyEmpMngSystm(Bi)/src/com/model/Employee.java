package com.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	private String eName;
	private String phoneNo;
	private int age;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dept_Id" )
	private Deparment dept;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Deparment getDept() {
		return dept;
	}

	public void setDept(Deparment dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "\n Employee [ eid=" + eid + ", eName=" + eName + ", phoneNo=" + phoneNo + ", age=" + age + ", gender="
				+ gender + "]";
	}
	
	
	
}
