package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Employee;
import com.util.ConfigationUtil;

public class Admin {

	public static void main(String[] args) {

		SessionFactory sf = ConfigationUtil.getSessionFactory();
		//Session s = sf.openSession();
		
		//Transaction tx = s.beginTransaction();
		
		//s.save(new Employee(2, "Jay Patil", "CS"));
		
		//Employee emp=s.get(Employee.class,2);
//		if(emp!=null) {
//			System.out.println(emp);
//		}else {
//			System.out.println("Employee not found");
//		}
		
		//System.out.println((emp!=null? emp: "Employee not Found"));
		
		//tx.commit();
		
		
	 Session s1=sf.openSession();
	 
	 Transaction tx = s1.beginTransaction();
	 Employee emp=new Employee("aa", "it");
	//System.out.println( "Genreting id:"+s1.save(emp)); //get method
	// s1.persist(emp);
	 
	 //tx.commit();
	 
	 
	 Employee emp1=s1.get(Employee.class, 1);
	// Employee emp1=new Employee("sss","dddd");
	 System.out.println(emp1);
	 emp1.setName("Swapnil1");
	 //s1.saveOrUpdate(emp); //perfrom the save or update opretion
	 s1.update(emp1);
	 System.out.println(s1.load(Employee.class, emp1.getId()));
	 Employee emp2=new Employee("aa", "hd");
	 emp1.setName("Ram");
	 Employee emp3=(Employee) s1.merge(emp2);
	 System.out.println(emp3); //it adavance of save and update method to retuen object
	 System.out.println(s1.merge(emp1));
	 
	 s1.delete(emp3); //delete data
	 
	 
	 
	 

	}

}
