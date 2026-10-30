package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Deparment;
import com.model.Employee;
import com.util.HiabernateUtil;

public class EmployeeDAO {

	static SessionFactory sf = HiabernateUtil.getSessionFactory();

	public static int addDeptOnly(Deparment dept) {
		Session s = sf.openSession();
		int id = (int) s.save(dept); 
		s.beginTransaction().commit();
		return id;
	}

	public static List<Deparment> getAllDept() {
		Session s = sf.openSession();
		return s.createQuery("from Deparment").getResultList();
	}

	public static Deparment getDeptById(int id) {
		Session s = sf.openSession();
		Deparment dept = s.get(Deparment.class, id);
		s.close();
		return dept;
	}

	public static int addEmployee(Employee employee) {
		Session s = sf.openSession();
		int id = (int) s.save(employee);
		s.beginTransaction().commit();
		return id;
	}

	public static Employee getEmployee(int eid) {
		Session s = sf.openSession();
		return s.get(Employee.class, eid);
	}

	public static void updateEmployee(Employee employee) {
		Session s = sf.openSession();
		s.saveOrUpdate(employee);
		s.beginTransaction().commit();
		System.out.println("Employee Update successfully!");
	}

	public static void updateDept(Deparment dept) {

		Session s = sf.openSession();
		s.saveOrUpdate(dept);
		s.beginTransaction().commit();
		System.out.println("Dept Update successfully!");
	}

	public static void deleteEmp(Employee employee) {
		Session s = sf.openSession();
		s.delete(employee);
		s.beginTransaction().commit();
		System.out.println("Delete Emp successfully!");
		
	}

	public static void deleteDeptAndEmployee(Deparment dept) {
		Session s = sf.openSession();
		s.delete(dept);
		s.beginTransaction().commit();
		System.out.println("Delete dept successfully!");
		
	}

}
