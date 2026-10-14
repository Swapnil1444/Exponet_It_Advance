package com.Controller;

import com.service.UserService;
import com.util.InputValidationUtil;

public class UserMenu {

	UserService service = new UserService();

	public void show() {

		boolean flge = true;
		while (flge) {
			System.out.println("======================================");
			System.out.println("            User mng System    ".toUpperCase());
			System.out.println("======================================");

			System.out.println(" 1.insert \n 2.Update \n 3.Get User \n 4.Delete \n 5.get all User \n 6.Search User Bye name  \n 0.Exit");
			System.out.println("--------------------------------------");
			int key = InputValidationUtil.inputInt("Select Option:");
			System.out.println("--------------------------------------");
			switch (key) {
			case 1:
				service.inserUser();
				break;
			case 2:
				service.updateUser();
				break;
			case 3:
				service.getUser();
				break;
			case 4:
				service.deleteUser();
				break;
			case 5:
				service.getAllUser();
				break;
				
			case 6:
				service.getUserByName();
				break;
			case 0:
				flge = false;
				System.out.println("Exit..!");
				break;
			default:
				System.out.println("Invaid Input..!");
				break;
			}
		}
	}

}
