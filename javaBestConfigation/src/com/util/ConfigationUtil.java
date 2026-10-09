package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConfigationUtil {

	private static SessionFactory sf;
	
	public static SessionFactory getSessionFactory() {
		
		Configuration configuration=new Configuration();
		configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/Hibernate");
		configuration.setProperty("hibernate.connection.username", "root");
		configuration.setProperty("hibernate.connection.password", "9309");

		configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		configuration.setProperty("hibernate.hbm2ddl.auto", "update");
		configuration.setProperty("hibernate.show_sql", "true");
		
		configuration.addAnnotatedClass(com.model.Employee.class);
		
		sf=configuration.buildSessionFactory();

		return sf;
		
	}
	
}
