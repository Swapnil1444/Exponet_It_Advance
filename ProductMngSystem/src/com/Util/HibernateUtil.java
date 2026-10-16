package com.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Product;

public class HibernateUtil {
	
	private static SessionFactory sf;
	
	private HibernateUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static SessionFactory getSessionFactory() {
		if(sf==null) {
			
			Configuration cfg=new Configuration();
			cfg.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
			cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/Hibernate");
			cfg.setProperty("hibernate.connection.username", "root");
			cfg.setProperty("hibernate.connection.password", "9309");

			cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
			cfg.setProperty("hibernate.hbm2ddl.auto", "update");
			cfg.setProperty("hibernate.show_sql", "true");
			
			cfg.addAnnotatedClass(Product.class);
			
			sf=cfg.buildSessionFactory();
		}
		return sf;
	
	}
}
