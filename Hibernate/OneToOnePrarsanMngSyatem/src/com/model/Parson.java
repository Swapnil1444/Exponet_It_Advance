package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Parson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pId;
	private String pName;
	@OneToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name = "Adhar_Id" )
	private Adhar adhar;
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Adhar getAdhar() {
		return adhar;
	}
	public void setAdhar(Adhar adhar) {
		this.adhar = adhar;
	}
	@Override
	public String toString() {
		return "Prasan [\n pId=" + pId + ",\n pName=" + pName + ",\n adhar=" + adhar + "]";
	}
	
	
	
}
