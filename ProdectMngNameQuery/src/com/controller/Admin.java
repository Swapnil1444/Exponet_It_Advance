package com.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Manufactures;
import com.model.Product;
import com.util.HiabernateUtil;

public class Admin {

	static SessionFactory sf = HiabernateUtil.getSessionFactory();

	public static void main(String[] args) {

		//addProductManufactures();
		
		Session s = sf.openSession();
		List<Product> p=s.createQuery("getAllProduct").getResultList();
		System.out.println(p);
		

	}
	private static void addProductManufactures() {
		Session s = sf.openSession();
		
		Manufactures m=new Manufactures();
		m.setName("Honda");
		
		Product p=new Product();
		p.setpName("car");
		p.setPrice(290000);
		p.setManufactures(m);
		
		Product p1=new Product();
		p1.setpName("bike");
		p1.setPrice(400000);
		p1.setManufactures(m);
		
		s.save(m);
		s.beginTransaction().commit();
	}
}
