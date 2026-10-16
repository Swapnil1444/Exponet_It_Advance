package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Adhar;
import com.model.Parson;
import com.services.PersonAdharServices;
import com.util.HiabernateUtil;

public class PrasanDAO {

	public static int addPerson(Parson p) {

		SessionFactory sf = HiabernateUtil.getSessionFactory();
		Session s = sf.openSession();
		int id = (int) s.save(p);
		s.beginTransaction().commit();
		return id;

	}

	public static Parson getPerson(int id) {
		SessionFactory sf = HiabernateUtil.getSessionFactory();
		Session s = sf.openSession();
		return s.get(Parson.class, id);
	}

	public static void deletePerson(Parson person) {
		SessionFactory sf = HiabernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.delete(person);
		s.beginTransaction().commit();
		System.out.println("Delete Parson...!");
	}

	public static void deleteAdharusingPersonId(Parson person) {

		SessionFactory sf = HiabernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Adhar a = person.getAdhar();
		System.out.println(a);
		person.setAdhar(null);
		s.update(person);
		s.delete(a);
		s.beginTransaction().commit();
		System.out.println("Delete Adhar...!");
	}

	public static void UpdatePerson(Parson person) {
		SessionFactory sf = HiabernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.saveOrUpdate(person);
		s.beginTransaction().commit();
		System.out.println("Update Person...!");
	}

	public static int addAdhar(Adhar a) {
		SessionFactory sf = HiabernateUtil.getSessionFactory();
		Session s = sf.openSession();
		int id =(int) s.save(a);
		s.beginTransaction().commit();
		System.out.println("Update Person...!");

		return id;
	}

}
