package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerClass {
   
	@RequestMapping("/")
	public void landingPageCall() {
		System.out.println("landing page call...!");
		
	}
	
	
}
