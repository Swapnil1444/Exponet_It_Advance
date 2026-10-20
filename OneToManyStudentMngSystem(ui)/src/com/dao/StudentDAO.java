package com.dao;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Student;
import com.model.Subject;
import com.util.HiabernateUtil;

public class StudentDAO {

	private static SessionFactory sf = HiabernateUtil.getSessionFactory();

	public static int AddStudent(Student s) {
		Session session = sf.openSession();
		int id = (int) session.save(s);
		session.beginTransaction().commit();
		return id;
	}

	public static Student getStudentById(int id) {
		Session session = sf.openSession();
		Student std = session.get(Student.class, id);
		session.close();
		return std;
	}

	public static List<Student> getAllStudent() {
		Session session = sf.openSession();
		session.createQuery("from Student").getResultList();
		return session.createQuery("from Student").getResultList();
	}

	public static void updateStudent(Student stud) {
		Session session = sf.openSession();
		session.saveOrUpdate(stud);
		session.beginTransaction().commit();
		System.out.println("Update Student Records..!");
	}

	public static void deleteStudent(Student stud) {
		Session session = sf.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		session.delete(stud);
		tx.commit();
		System.out.println("Delete Student ...!");
	}

	public static void deleteSubject(Subject sub) {
		
		Session session = sf.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		session.delete(sub);
		tx.commit();
		System.out.println("Delete Subject ...!");

	}

}
