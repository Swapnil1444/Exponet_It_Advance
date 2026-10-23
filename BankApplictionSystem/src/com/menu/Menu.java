package com.menu;

import com.model.User;
import com.services.AccountServiceImp;
import com.services.AdminAccountService;
import com.services.AdminServices;
import com.util.InputValidUtil;

public class Menu {

	private static AdminAccountService r = new AccountServiceImp();
	private static AdminServices l=new AdminServices();

	public static void adminlogin() {
		boolean flag = true;
		while (flag) {
			System.out.println("=======================================");
			System.out.println("      WELCOME UNION BANK OF INDIA      ");
			System.out.println("=======================================");
			System.out.println("1.User login \n2.new User Login \n3.Exit");

			System.out.println("=======================================");
			int key = InputValidUtil.inputInt("Select Option:");
			System.out.println("=======================================");

			switch (key) {
			case 1:
				l.UserLogin();
				break;

			case 2:
				l.newAccount();
				break;
			case 3:
				System.out.println("Exit...!");
				flag = false;
				break;
			default:
				System.err.println("Invalid Input..!");
				break;
			}

		}
	}

	public static void mainMenu(User user) {

		boolean flag = true;

		while (flag) {
			System.out.println("=======================================");
			System.out.println("         WELCOME BACK " + user.getUsername().toUpperCase() + "     ");
			System.out.println("=======================================");

			System.out.println("1.Create Account \n2.Display Account Details " + "\n3.Check Balance \n4.Deposit Amount "
					+ "\n5.Withdraw Amount \n6.Update Account Info " + "\n7.Delete Account \n8.Exit");
			System.out.println("=======================================");
			int key = InputValidUtil.inputInt("Select Option");
			switch (key) {
			case 1:
				r.createAccount();
				break;
			case 2:
				r.displayAccountDetails();
				break;
			case 3:
				r.checkBalance();
				break;
			case 4:
				r.deposit();
				break;
			case 5:
				r.withdraw();
				break;
			case 6:
				r.updateAccountInfo();
				break;
			case 7:
				r.deleteAccount();
				break;
			case 8:
				System.out.println("Exit...!");
				flag = false;
				break;
			default:
				System.err.println("Invalid Input..!");
				break;
			}

		}
	}

}
