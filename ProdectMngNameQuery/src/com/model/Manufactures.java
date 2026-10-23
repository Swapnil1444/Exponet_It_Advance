package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Manufactures {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToMany(mappedBy = "manufactures",cascade = CascadeType.ALL)
	List<Product> listProdect;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getListProdect() {
		return listProdect;
	}

	public void setListProdect(List<Product> listProdect) {
		this.listProdect = listProdect;
	}

	@Override
	public String toString() {
		return "Manufactures [id=" + id + ", name=" + name + ", listProdect=" + listProdect + "]";
	}
	
	
	
}
