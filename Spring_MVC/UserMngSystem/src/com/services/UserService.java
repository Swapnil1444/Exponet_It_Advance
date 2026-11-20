package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.UserDAO;
import com.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDao;

	private static final String username = "Admin";
	private static final String password = "Admin@123";

	public void addUser(User user) {
		if (user == null) {
			throw new RuntimeException("User Is null");
		}
		System.out.println("Id:" + userDao.addUser(user));

		System.out.println("Create new Account :" + user);
	}

	public User Login(String username, String password) {

		return userDao.getUser(username, password);
	}

	public List<User> getAllUserService(String username, String password) {

		if (username == null || password == null) {
			throw new RuntimeException("Username and password is null..!");
		}
		if (!username.equalsIgnoreCase(this.username) || !password.equals(this.password)) {
			throw new RuntimeException("Username and password Invalid..!");
		}
		return userDao.getUserList();
	}

	public List<User> getAllUsersService() {
		return userDao.getUserList();
	}

	public void deleteUser(int id) {
		
		userDao.deleteUser(id);
	}

	public User getUser(int id) {
		return userDao.getUserById(id);
		
	}

	public void updateUser(User user) {
		userDao.updateUserInfo(user);
		
	}

}
