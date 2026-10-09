package com.service;

import com.dao.UsersDAO;
import com.menu.HomeMenu;
import com.model.Users;
import com.util.InputUtil;

public class SingUpService {

	HomeMenu homeMenu=new HomeMenu();
	public void singIn() {
		System.out.println("Create new Account");
		System.out.println("-----------------------------");
		String fname=InputUtil.inputString("Enetr First Name:");
		String lname=InputUtil.inputString("Enter Last Name:");
		String email=InputUtil.inputString("Enter Email:");
		String username=InputUtil.inputString("Enter UserName:");
		String password =InputUtil.inputString("Enter Password:");
		String role =InputUtil.inputString("Enter Role:");
		System.out.println("-----------------------------");
		homeMenu.homeMenu(UsersDAO.getUser(UsersDAO.insertUser(new Users(fname, lname, email, username, password, role))));
	}

	
}
