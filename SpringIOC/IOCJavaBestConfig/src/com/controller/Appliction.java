package com.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.AppConfig;
import com.entity.Employee;

public class Appliction {
	
	public static void main(String[] args) {
		 ApplicationContext confi=new AnnotationConfigApplicationContext(AppConfig.class);
		Employee emp= confi.getBean("emp",Employee.class);
		System.out.println(emp);
		 
	}

}
