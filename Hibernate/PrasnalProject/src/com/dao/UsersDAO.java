package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.menu.HomeMenu;
import com.model.Users;
import com.util.HibernateUtil;

public class UsersDAO {

	public static int insertUser(Users user) {
		SessionFactory sf = HibernateUtil.getSessionFactor();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		System.out.println("Create new User Account...!");
		session.close();
		return user.getId();
	}

	public static Users getUser(int userId) {
		SessionFactory sf = HibernateUtil.getSessionFactor();
		Session session = sf.openSession();
		session.close();
		return session.get(Users.class, userId);
	}

	public static Users getUserByUserNameAndPassword(String username, String password) {

		SessionFactory sf = HibernateUtil.getSessionFactor();
		Session session = sf.openSession();

		String hql = "FROM Users WHERE userName = :username AND password = :password";

		Users user = session.createQuery(hql, Users.class).setParameter("username", username)
				.setParameter("password", password).uniqueResult();
		session.close();
		if (user == null) {
			System.out.println("Invalid Username and password");
		}
		session.close();
		return user;
	}
	
	public static Users getUserbyUsername(String username) {
		SessionFactory sf = HibernateUtil.getSessionFactor();
		Session session = sf.openSession();

		String hql = "FROM Users WHERE userName = :username";

		Users user = session.createQuery(hql, Users.class)
				.setParameter("username", username)
				.uniqueResult();
		session.close();
		if (user == null) {
			System.out.println("Invalid Username");
		}
		session.close();
		return user;
	}

	public static void updateUser(Users user) {
		
		SessionFactory sf = HibernateUtil.getSessionFactor();
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
	    System.out.println("Update Deta...!");
	    session.close();

	}

}
