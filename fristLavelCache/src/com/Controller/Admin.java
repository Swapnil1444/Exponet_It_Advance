package com.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Student;
import com.util.HaibernetUtil;

public class Admin {

	public static SessionFactory sf = HaibernetUtil.getSestionFactory();

	public static void main(String[] args) {

		Session s1 = sf.openSession();
		Session s2 = sf.openSession(); //this is create new session

		Transaction tx = s1.beginTransaction();
//
//		Student s=new Student();
//		s.setName("jay");
//		s.setAge(21);
//		s1.save(s);
//		tx.commit();
		
		Session s3=sf.getCurrentSession();
		Session s4=sf.getCurrentSession(); //this is return the current sestion of appliction
		
		System.out.println(s3==s4);
		System.out.println(s1==s2);
		
		Student stud1=s1.get(Student.class, 1);
		System.out.println(stud1);
		Student stud2=s1.get(Student.class, 2);
		System.out.println(stud2);	
		Student stud3=s2.get(Student.class, 1);
		System.out.println(stud3);
		
		Student stud4=s2.get(Student.class, 2);
		System.out.println(stud4);
		
		//sf.close();
		Student stud5=s1.get(Student.class, 1);
		System.out.println(stud5);
		
		Student stud6=s2.get(Student.class, 2);
		System.out.println(stud6);
		s2.evict(stud3);
		s1.clear();
		Student stud7=s1.get(Student.class, 2);
		System.out.println(stud7);
		s1.clear();
		s2.clear();
		
		System.out.println(" using load"+s1.load(Student.class, 1));
		
		Student st1=s2.load(Student.class, 2);  //this is lazy method and return proxiObject
		System.out.println("load: "+st1);
		
		s2.clear();
		Student st2=s2.getReference(Student.class, 2); //same as load method but it modarn version 6+
		
	
		System.out.println("get Reference:"+st2);
		
		
	}

}
