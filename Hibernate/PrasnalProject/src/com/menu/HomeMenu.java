package com.menu;

import com.model.Users;

public class HomeMenu {
	
	public void homeMenu(Users users) {
		System.out.println("-----------------------------");
		System.out.println(" WELCOME "+users.getFullName().toUpperCase());
		System.out.println("-----------------------------");
	}

}
