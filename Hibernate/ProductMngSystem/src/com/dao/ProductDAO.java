package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Util.HibernateUtil;
import com.model.Product;

public class ProductDAO {

	public int addProduct(Product p) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		int id = (int) s.save(p);
		s.beginTransaction().commit();
		return id;
	}

	public Product getProductById(int id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		return s.get(Product.class, id);
	}

	public List<Product> displayAllProduct() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		return s.createQuery("from Product").getResultList();
	}

	public void deleteProduct(Product p) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.delete(p);
		s.beginTransaction().commit();
		System.out.println("Delete Prodect...!");
	}

	public Product updateProdect(Product product) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Product p = (Product) s.merge(product);
		s.beginTransaction().commit();
		return p;
	}

	public List<Product> getProductByCategory(String catagory) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		return s.createQuery("from Product where catagory  like :catagory ")
				.setParameter("catagory", "%" + catagory + "%").getResultList();
	}

}
