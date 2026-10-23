package com.services;

import java.time.LocalDateTime;
import java.util.List;

import com.dao.AccountDAO;
import com.menu.Menu;
import com.model.Accountdetails;
import com.model.User;
import com.mysql.cj.xdevapi.Schema.Validation;
import com.util.InputValidUtil;

public class AdminServices {

	AdminAccountService a = new AccountServiceImp();

	public void UserLogin() {

		String username = InputValidUtil.inputString("Enter UserName:");
		String password = InputValidUtil.inputString("Enter Password:");
		List<User> users = AccountDAO.getAllAccount();
		User user=null;
		boolean found=true;
		for(User u:users ) {
			if(u.getUsername().equals(username)&& u.getPassword().equals(password)) {
				found=false;
				user=u;
			}
		}
		if(found) {
			System.out.println("Username and Password not match");
		}else {
			Menu.mainMenu(user);
		}

	}

	public void newAccount() {
		a.createAccount();
	}

}
