package com.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.User;
import com.util.HibernateUtil;

public class UserDAO {

	public static int insertUser(User user) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		Serializable id = s.save(user);
		tx.commit();
		return (int) id;
	}
	
	
	public static User getUserbyId(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session s = sf.openSession();
		return s.get(User.class, id);
	}
	public static void updateUser(User user) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		//Serializable id = s.save(user);
		s.saveOrUpdate(user);
		tx.commit();
		System.out.println("Update User..!");
	}
	
	public static void deleteUser(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		User userData=s.get(User.class, id);
		if(userData!=null) {
			s.delete(userData);
			System.out.println("Delete User..!");
		}else {
			System.out.println("User not Found");
		}
		tx.commit();
	}


	public static List<User> getAllUsers() {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		return s.createQuery("from User").getResultList();
		
	}
	
	public static List<User> getUserByName(String name){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.openSession();
		return s.createQuery("from User where username like :name").setParameter("name", name+"%").getResultList();
		
	}
	
}
