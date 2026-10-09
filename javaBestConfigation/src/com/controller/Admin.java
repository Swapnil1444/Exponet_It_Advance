package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Employee;
import com.util.ConfigationUtil;

public class Admin {

	public static void main(String[] args) {

		SessionFactory sf = ConfigationUtil.getSessionFactory();
		Session s = sf.openSession();
		
		//Transaction tx = s.beginTransaction();
		
		//s.save(new Employee(2, "Jay Patil", "CS"));
		
		Employee emp=s.get(Employee.class,2);
//		if(emp!=null) {
//			System.out.println(emp);
//		}else {
//			System.out.println("Employee not found");
//		}
		
		System.out.println((emp!=null? emp: "Employee not Found"));
		
		//tx.commit();

	}

}
