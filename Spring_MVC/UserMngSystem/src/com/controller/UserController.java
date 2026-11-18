package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.User;
import com.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	public SessionFactory sf;

	@RequestMapping("/signup")
	public String addUser(@ModelAttribute User user) {
		userService.addUser(user);
		return "Login";
	}

	@RequestMapping("login")
	public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
		// System.out.println("Login User: " + userService.Login(username, password));

		try {
			model.addAttribute("allEmployee", userService.getAllUserService(username, password));
			return "AdminPage";
		} catch (RuntimeException e) {
			model.addAttribute("msg",e.getMessage());
			return "errerPage";
		}

	}
}
