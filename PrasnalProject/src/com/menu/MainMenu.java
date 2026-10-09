package com.menu;

import com.service.ForgetPasswodService;
import com.service.LoginService;
import com.service.SingUpService;
import com.util.InputUtil;

import net.bytebuddy.description.type.TypeDescription.Generic.OfParameterizedType.ForGenerifiedErasure;

public class MainMenu {

	public void manuShow() {

		boolean flag = true;
		while (flag) {
			System.out.println("============================");
			System.out.println("         MAIN MENU          ");
			System.out.println("============================");

			System.out.println(" 1.Login \n 2.Sign In \n 3.Forget Password \n 4.Exit");
			System.out.println("-----------------------------");
			int key = InputUtil.inputInt("Select Option:");
			System.out.println("-----------------------------");
			switch (key) {
			case 1:
				LoginService loginService=new LoginService();
				loginService.login();
				break;
			case 2:
				SingUpService singUpService =new  SingUpService();
				singUpService.singIn();
				break;
			case 3:
				ForgetPasswodService forgetPasswodService=new ForgetPasswodService();
				forgetPasswodService.forgetpassword();
				break;
			case 4:
				System.out.println("Exit...!");
				flag=false;
				break;
			default:
				System.out.println("Invalid Input..!");
				break;
			}

		}
	}

}
