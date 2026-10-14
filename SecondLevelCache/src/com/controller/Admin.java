package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Emp;
import com.util.HibernateUtil;

public class Admin {

	public static void main(String[] args) {
		 
		
	SessionFactory	sf=HibernateUtil.getSessionactory();
	Session s = sf.openSession();
	Session s1=sf.openSession();
	Transaction tx=s.beginTransaction();
	Emp emp=new Emp("prachi", 20);
	//s.save(emp);
	tx.commit();
	
	Emp emp1=s.get(Emp.class, 1);
	System.out.println(emp1);
	Emp emp11=s1.get(Emp.class, 1);
	System.out.println(emp11);

	Emp emp2=s.get(Emp.class, 1);
	System.out.println(emp2);
	
	Emp emp3=s.load(Emp.class, 2);
	System.out.println(emp3);
	}

}
