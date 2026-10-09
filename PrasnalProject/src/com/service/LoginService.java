package com.service;

import com.dao.UsersDAO;
import com.menu.HomeMenu;
import com.model.Users;
import com.util.InputUtil;

public class LoginService {
	HomeMenu homeMenu = new HomeMenu();

	public void login() {
		System.out.println("         Login Account       ");
		System.out.println("-----------------------------");
		String username = InputUtil.inputString("Enter UserName:");
		String password = InputUtil.inputString("Enter Password:");
		System.out.println("-----------------------------");
		Users user = UsersDAO.getUserbyUsername(username);
		if (user != null) {
			//System.out.println(user);
			if (username.equals(user.getUserName())) {
				homeMenu.homeMenu(UsersDAO.getUserByUserNameAndPassword(username, password));
			} else {
				System.out.println("Invalid Password");
			}
		}

	}

}
