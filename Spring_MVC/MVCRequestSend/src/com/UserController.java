package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.User;

@Controller
public class UserController {

	@RequestMapping("/login")
	public String loginUser(@RequestParam("username") String username, @RequestParam("password") String password) {
		System.out.println("User Login ");
		System.out.println("Username:" + username + " password:" + password);

		return "homePage";
	}

//	@RequestMapping("/signin")
//	public void signInUser(@RequestParam("name") String name, @RequestParam("phone") long num,
//			@RequestParam("email") String email) {
//
//		System.out.println("Sign in User");
//		System.out.println("Name:" + name + " Email:" + email + " Phone:" + num);
//
//	}

	@RequestMapping("/signin")
	public String signInUser(@ModelAttribute User user) {

		System.out.println("Sign in User-->" + user);
		return "Login";

	}

}
