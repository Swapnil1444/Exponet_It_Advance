package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Student;
import com.util.HiabernateUtil;

public class StudentDAO {

	private static SessionFactory sf= HiabernateUtil.getSessionFactory();
	
	public static int AddStudent(Student s) {
		Session session=sf.openSession();
		 int id=(int) session.save(s);
		 session.beginTransaction().commit();
		return  id;
	}
	
	

}
