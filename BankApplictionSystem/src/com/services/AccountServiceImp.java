package com.services;

import java.time.LocalDateTime;
import java.util.List;

import com.dao.AccountDAO;
import com.model.Accountdetails;
import com.model.User;
import com.util.InputValidUtil;

public class AccountServiceImp implements AdminAccountService {

	@Override
	public int createAccount() {
		User user=new User();
		user.setUsername(InputValidUtil.inputString("Enter Username:"));
		user.setPassword(InputValidUtil.inputString("Enter Password:"));
		user.setLastLogin(LocalDateTime.now());
		
		Accountdetails accountdetails=new Accountdetails();
		accountdetails.setAccountHolderName(InputValidUtil.inputString("Enter Account Holdar Name:"));
		accountdetails.setAccountNumber(InputValidUtil.autoGenAccountNo());
		accountdetails.setAccountType(InputValidUtil.validAccountType("Enter Account Type(Savings or Current) :"));
		accountdetails.setAddress(InputValidUtil.inputString("Enter Address:"));
		accountdetails.setAdharNo(InputValidUtil.validAdharNo("Enter Adhar No:"));
		accountdetails.setEmail(InputValidUtil.validEmail("Enter Email:"));
		accountdetails.setBalance(10000);
		accountdetails.setGender(InputValidUtil.inputGendar("Enter Gender (Male/femele):"));
		accountdetails.setPanNum(InputValidUtil.validPanNo("Enter PanNo:"));
		user.setAccountdetails(accountdetails);
	 	int id=AccountDAO.addnewAccount(user);
	 	if(id!=0) {
	 		System.out.println("new Account Created..!");
	 		System.out.println("Account no: "+accountdetails.getAccountNumber());
	 		return id;
	 	}
	 	return 0;
	}

	@Override
	public void displayAccountDetails() {
		List<User> list=AccountDAO.getAllAccount();
		System.out.println(list);

	}

	@Override
	public void checkBalance() {
		
	}

	@Override
	public void updateAccountInfo() {
	

	}

	@Override
	public void deleteAccount() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deposit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdraw() {
		// TODO Auto-generated method stub
		
	}

	
}
