package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Accountdetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private long accountNumber;
	private String accountHolderName;
	private Gender gender;
	private double balance;
	private String accountType;
	private long mobileNumber;
	private String email;
	private String address;
	private String adharNo;
	private String panNum;
	
	@OneToOne(mappedBy = "accountdetails")
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}

	public String getPanNum() {
		return panNum;
	}

	public void setPanNum(String panNum) {
		this.panNum = panNum;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


@Override
public String toString() {
    return "{\n"
            + "  \"id\": " + id + ",\n"
            + "  \"accountNumber\": \"" + accountNumber + "\",\n"
            + "  \"accountHolderName\": \"" + accountHolderName + "\",\n"
            + "  \"gender\": \"" + gender + "\",\n"
            + "  \"balance\": " + balance + ",\n"
            + "  \"accountType\": \"" + accountType + "\",\n"
            + "  \"mobileNumber\": \"**********\",\n"
            + "  \"email\": \"" + email + "\",\n"
            + "  \"address\": \"" + address + "\",\n"
            + "  \"adharNo\": \"XXXX-XXXX-"
            + (adharNo != null && adharNo.length() >= 4
                ? adharNo.substring(adharNo.length() - 4)
                : "XXXX") + "\",\n"
            + "  \"panNum\": \"**********\"\n"
            + "}";
}
	
	
}
