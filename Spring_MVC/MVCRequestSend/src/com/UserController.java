package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.DispatcherServlet;

@Controller
public class UserController {

	@RequestMapping("/login")
	public void loginUser( @RequestParam("username") String username ,@RequestParam("password") String password) {
		System.out.println("User Login ");
		System.out.println("Username:"+username+" password:"+password);
	}
	
	
}
