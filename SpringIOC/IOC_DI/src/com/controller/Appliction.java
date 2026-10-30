package com.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Employee;

public class Appliction {

	public static void main(String[] args) {
		
		
	ApplicationContext	ac=	new ClassPathXmlApplicationContext("Beans.xml");
	System.out.println(ac.getBean("emp",Employee.class));

	}

}
