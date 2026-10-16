package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Adhar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aId;
	private String adharNo;

	@JoinColumn(referencedColumnName = "adhar")
	Person person;

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Adhar [\n aId=" + aId + ",\n adharNo=" + adharNo + "]";
	}

}
