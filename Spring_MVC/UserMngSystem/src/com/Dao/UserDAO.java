package com.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.User;

@Repository
public class UserDAO {

	@Autowired
	public SessionFactory sf;

	public int addUser(User user) {
		System.out.println("User Info:" + user);

		Session session = sf.openSession();
		int id = (int) session.save(user);
		session.beginTransaction().commit();
		return id;
	}

	public List<User> getUserList() {
		return sf.openSession().createQuery("from User", User.class).getResultList();
	}

	public User getUser(String username, String password) {
		return sf.openSession().createQuery("from User where username=:user and password=:pass", User.class)
				.setParameter("user", username).setParameter("pass", password).getSingleResult();
	}

}
