package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.User;
import com.util.HiabernateUtil;

public class AccountDAO {

	static SessionFactory sf = HiabernateUtil.getSessionFactory();

	public static int addnewAccount(User user) {
		Session s = sf.openSession();
		int id=(int)s.save(user);
		s.beginTransaction().commit();
		return id;
	}

	public static List<User> getAllAccount() {
		Session s = sf.openSession();
		return s.createQuery("from User").getResultList();
	}

	public static User getUser(int id) {
		Session s = sf.openSession();
		return s.get(User.class, id);

	}

}
