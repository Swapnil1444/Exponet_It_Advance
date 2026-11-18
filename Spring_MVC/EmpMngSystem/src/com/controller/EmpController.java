package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Employee;

@Controller
public class EmpController {

	
	@RequestMapping("/login")
	public String loginUser(@RequestParam("username") String username, @RequestParam("password") String password) {
		System.out.println("User Login ");
		System.out.println("Username:" + username + " password:" + password);

		return "home";
	}
	
	@RequestMapping("/signup")
	public String signInUser(@ModelAttribute Employee emp) {

		System.out.println("Sign in Emp-->" + emp);
		return "Login";

	}

}
