package com.service;

import com.dao.UserDAO;
import com.model.Gender;
import com.model.User;
import com.util.InputValidationUtil;

public class UserService {

	// 1. Insert User
	public void inserUser() {

		System.out.println("\n========== INSERT USER ==========");

		User user = new User();

		user.setUsername(InputValidationUtil.inputString("Enter User Name: "));

		user.setEmail(InputValidationUtil.validEmail("Enter User Email: "));

		user.setPhoneNo(InputValidationUtil.validPhoneNo("Enter User Phone: "));

		user.setCity(InputValidationUtil.inputString("Enter User City: "));

		user.setAge(InputValidationUtil.inputInt("Enter Age: "));

		user.setGender(inputGender());

		int id = UserDAO.insertUser(user);

		if (id != 0) {
			System.out.println("\nUser inserted successfully!");
			System.out.println("Generated User ID: " + id);
		} else {
			System.out.println("Failed to insert user.");
		}
	}

	// 2. Update User
	public void updateUser() {

		System.out.println("\n========== UPDATE USER ==========");

		int id = InputValidationUtil.inputInt("Enter User ID: ");
		User user = UserDAO.getUserbyId(id);

		if (user == null) {
			System.out.println("User not found!");
			return;
		}

		System.out.println("Current User Details:");
		System.out.println(user);

		user.setUsername(InputValidationUtil.inputString("Enter New User Name: "));

		user.setEmail(InputValidationUtil.validEmail("Enter New Email: "));

		user.setPhoneNo(InputValidationUtil.validPhoneNo("Enter New Phone: "));

		user.setCity(InputValidationUtil.inputString("Enter New City: "));

		user.setAge(InputValidationUtil.inputInt("Enter New Age: "));

		user.setGender(inputGender());

		UserDAO.updateUser(user);

		System.out.println("User updated successfully!");
	}

	// 3. Get User By ID
	public void getUser() {

		System.out.println("\n========== GET USER ==========");

		int id = InputValidationUtil.inputInt("Enter User ID: ");
		User user = UserDAO.getUserbyId(id);

		if (user != null) {
			System.out.println(user);
		} else {
			System.out.println("User not found!");
		}
	}

	// 4. Get All Users
	public void getAllUser() {

		System.out.println("\n========== ALL USERS ==========");

		System.out.println(UserDAO.getAllUsers());
	}

	// 5. Delete User
	public void deleteUser() {

		System.out.println("\n========== DELETE USER ==========");

		int id = InputValidationUtil.inputInt("Enter User ID: ");
		User user = UserDAO.getUserbyId(id);

		if (user == null) {
			System.out.println("User not found!");
			return;
		}

		UserDAO.deleteUser(user.getId());

		System.out.println("User deleted successfully!");
	}

	// 6. Search User By Name
	public void getUserByName() {

		System.out.println("\n========== SEARCH USER ==========");

		String username = InputValidationUtil.inputString("Enter User Name: ");

		System.out.println(UserDAO.getUserByName(username));
	}

	// Reusable Gender Input
	private Gender inputGender() {

		while (true) {

			String gender = InputValidationUtil.inputString("Enter Gender (Male/Female): ").trim();

			try {
				return Gender.valueOf(gender.toUpperCase());
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid gender! Please enter Male or Female.");
			}
		}
	}
}