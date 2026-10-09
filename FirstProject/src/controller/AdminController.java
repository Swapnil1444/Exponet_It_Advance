package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Student;

public class AdminController {

	public static void main(String[] args) {

		Configuration cf = new Configuration().configure("HibernateConfiction.xml");
		SessionFactory sf = cf.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx=s.beginTransaction();
		
		System.out.println("Student Information: "+s.get(Student.class,101));
		
		Student stud=s.get(Student.class,101);
		stud.setId(101);
		stud.setMoblieNo(9309144437l);
		stud.setName("jay");
		stud.setAge(21);
		
		s.saveOrUpdate(stud);
		tx.commit();
		System.out.println("Update data");
		
		System.out.println("Student Information: "+s.get(Student.class,101));
		
		s.delete(stud);
		System.out.println("delate rocord...!");
		
		
	

	}

}
