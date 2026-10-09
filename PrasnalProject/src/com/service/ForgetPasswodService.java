package com.service;

import java.util.Random;

import com.dao.UsersDAO;
import com.email.EmailServices;
import com.model.Users;
import com.util.InputUtil;

public class ForgetPasswodService {

	//int otp = 123;

	public void forgetpassword() {
		int Gotp = getOtp();
		String username = InputUtil.inputString("Enter UserName:");
		Users user = UsersDAO.getUserbyUsername(username);
		if (user != null) {
			EmailServices emailServices=new EmailServices();
			emailServices.sendOTP(user, Gotp);
			int otp = InputUtil.inputInt("Enter OTP:");
			if (Gotp==otp) {
				newPassword(user);
			} else {
				System.err.println("Invalid Opt..!");
			}
		} else {
			System.out.println("Invalid UserName");
		}
	}

	private void newPassword(Users user) {

		String newPassword = InputUtil.inputString("Enter new Password:");
		user.setPassword(newPassword);
		UsersDAO.updateUser(user);
	}

	private int getOtp() {
		return (int)(Math.random()*Math.pow(10, 4));
	}

}
