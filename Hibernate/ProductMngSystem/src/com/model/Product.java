package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pId;
	private String pName;
	private double price;
	private String description;
	private int quantity;
	private String catagory;
	private boolean isAvaible;

	public Product() {
	}

	public Product(String pName, double price, String desc, int quantity, String catagory, boolean isAvaible) {
		this.pName = pName;
		this.price = price;
		this.description = desc;
		this.quantity = quantity;
		this.catagory = catagory;
		this.isAvaible = isAvaible;
	}

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String desc) {
		this.description = desc;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public boolean isAvaible() {
		return isAvaible;
	}

	public void setAvaible(boolean isAvaible) {
		this.isAvaible = isAvaible;
	}

	@Override
	public String toString() {

		String stockStatus;

		if (quantity == 0) {
			stockStatus = "OUT OF STOCK";
		} else if (quantity <= 5) {
			stockStatus = "LOW STOCK";
		} else {
			stockStatus = "IN STOCK";
		}

		return "\n" + "+--------------------------------------------------+\n"
				+ "|                 PRODUCT DETAILS                  |\n"
				+ "+--------------------------------------------------+\n"
				+ String.format("| %-18s : %-27s |%n", "Product ID", pId)
				+ String.format("| %-18s : %-27s |%n", "Product Name", pName)
				+ String.format("| %-18s : Rs. %-23.2f |%n", "Price", price)
				+ String.format("| %-18s : %-27s |%n", "Description", description)
				+ String.format("| %-18s : %-27d |%n", "Quantity", quantity)
				+ String.format("| %-18s : %-27s |%n", "Category", catagory)
				+ String.format("| %-18s : %-27s |%n", "Availability", isAvaible ? "Available" : "Not Available")
				+ String.format("| %-18s : %-27s |%n", "Stock Status", stockStatus)
				+ "+--------------------------------------------------+";
	}

}
