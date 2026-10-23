package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQuery(name="getAllProduct",query = "from Product")
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String pName;
	private double price;

	@ManyToOne
	@JoinColumn(name="manufactures_id")
	Manufactures manufactures;
	public int getPid() {
		return pid;
	}

	public Manufactures getManufactures() {
		return manufactures;
	}

	public void setManufactures(Manufactures manufactures) {
		this.manufactures = manufactures;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "\n   Product [pid=" + pid + ", pName=" + pName + ", price=" + price + "]";
	}
	
	

}
