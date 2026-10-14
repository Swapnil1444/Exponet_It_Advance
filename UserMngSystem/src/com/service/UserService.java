package com.service;

import com.dao.UserDAO;
import com.model.Gender;
import com.model.User;
import com.util.InputValidationUtil;

public class UserService {
	public void inserUser() {
		User user = new User();
		String username = InputValidationUtil.inputString("Enter User Name:");
		String email = InputValidationUtil.validEmail("Enter User Email:");
		String phoneNo = InputValidationUtil.validPhoneNo("Enter User Phone:");
		String city = InputValidationUtil.inputString("Enter User City:");
		int age = InputValidationUtil.inputInt("Enatr Age:");
		String gender=InputValidationUtil.inputString("Enter Gender (Male/FeMale):");
		
		user.setAge(age);
		user.setUsername(username);
		user.setCity(city);
		user.setEmail(email);
		user.setPhoneNo(phoneNo);
		user.setGender(Gender.valueOf(gender));
		int id = UserDAO.insertUser(user);
		System.out.println("--------------------------------------");

		if (id != 0) {
			System.out.println("\n  Insert User Genreted Id:" + id + "\n");
		} else {
			System.err.println("Error");
		}

	}

	public void updateUser() {
		User user = UserDAO.getUserbyId(InputValidationUtil.inputInt("Enter User ID:"));
		System.out.println("--------------------------------------");

		if(user!=null) {
			System.out.println(user);
			System.out.println("--------------------------------------");

			String username = InputValidationUtil.inputString("Enter User Name:");
			String email = InputValidationUtil.validEmail("Enter User Email:");
			String phoneNo = InputValidationUtil.validPhoneNo("Enter User Phone:");
			String city = InputValidationUtil.inputString("Enter User City:");
			int age = InputValidationUtil.inputInt("Enatr Age:");
			String gender=InputValidationUtil.inputString("Enter Gender (Male/FeMale):");

			user.setAge(age);
			user.setUsername(username);
			user.setCity(city);
			user.setEmail(email);
			user.setPhoneNo(phoneNo);
			user.setGender(Gender.valueOf(gender));
			System.out.println("--------------------------------------");

			UserDAO.updateUser(user);
		}else {
			System.out.println("User Not Found..!");
		}
	}

	public void getUser() {
		User user = UserDAO.getUserbyId(InputValidationUtil.inputInt("Enter User ID:"));
		System.out.println("--------------------------------------");
		System.out.println(user != null ? user : "User Not Found..!");
	}

	public void getAllUser() {
		System.out.println("         All User Informtion     ".toUpperCase());
		System.out.println("--------------------------------------");
  
		System.out.println(UserDAO.getAllUsers());
	}

	public void deleteUser() {
		User user = UserDAO.getUserbyId(InputValidationUtil.inputInt("Enter User ID:"));
		System.out.println("--------------------------------------");

		if (user != null) {
			UserDAO.deleteUser(user.getId());
		} else {
			System.out.println("User Not Found..!");
		}
	}
	
	public void getUserByName() {
		String username = InputValidationUtil.inputString("Enter User Name:");
		System.out.println(UserDAO.getUserByName(username));
	}

}
