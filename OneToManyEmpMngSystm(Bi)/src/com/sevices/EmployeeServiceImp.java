package com.sevices;

import java.util.ArrayList;
import java.util.List;

import com.dao.EmployeeDAO;
import com.model.Deparment;
import com.model.Employee;
import com.util.ValidationUtil;

public class EmployeeServiceImp implements EmployeeServices {

	@Override
	public void addDeptOnly() {
		Deparment dept = new Deparment();
		System.out.println("--------------------------------------");
		dept.setdName(ValidationUtil.inputString("Enter Dept Name:"));
		System.out.println("--------------------------------------");
		List<Employee> emps = new ArrayList<Employee>();
		dept.setEmps(emps);
		int id = EmployeeDAO.addDeptOnly(dept);

		if (id != 0) {
			System.out.println("Department added successfully!");
			System.out.println("Department ID: " + id);
		} else {
			System.out.println("Failed to add department.");
		}

	}

	@Override
	public void addEmp() {
		// List<Employee> emps = new ArrayList<Employee>();
		System.out.println("--------------------------------------");
		int num = ValidationUtil.inputInt("what num of Employee Add:");
		System.out.println("--------------------------------------");
		for (int i = 0; i < num; i++) {
			Employee employee = new Employee();
			System.out.println("--------------------------------------");
			employee.seteName(ValidationUtil.inputString("Enter Name:"));
			employee.setGender(ValidationUtil.inputGendar("Enter Gendar(male/female/other):"));
			employee.setPhoneNo(ValidationUtil.inputPhoneNo("Enter Phone No:"));
			employee.setAge(ValidationUtil.inputInt("Enter Age:"));
			System.out.println("--------------------------------------");
			getAllDept();
			System.out.println("--------------------------------------");
			Deparment dept = EmployeeDAO.getDeptById(ValidationUtil.inputInt("Enter Dept Id:"));
			System.out.println("--------------------------------------");
			if (dept != null) {
				employee.setDept(dept);
				int id = EmployeeDAO.addEmployee(employee);
				if (id != 0) {
					System.out.println("Employee added successfully!");
					System.out.println("Employee ID: " + id);
				} else {
					System.out.println("Failed to add Employee.");
				}
			} else {
				System.out.println("This dept not pregent..!");
				EmployeeDAO.getDeptById(ValidationUtil.inputInt("Enter Dept Id:"));
			}

		}
	}

	@Override
	public void getAllEmpByDept() {
		System.out.println("--------------------------------------");
		Deparment dept = EmployeeDAO.getDeptById(ValidationUtil.inputInt("Enter Dept Id:"));
		if (dept != null) {
			System.out.println(dept);
		} else {
			System.out.println("Dept Not Existing...!");
		}

	}

	@Override
	public void getAllDept() {
		System.out.println("--------------------------------------");
		List<Deparment> dept = EmployeeDAO.getAllDept();
		for (Deparment d : dept) {
			System.out.println("Id:" + d.getdId() + " Name:" + d.getdName());
		}
	}

	@Override
	public void updateEmp() {
		System.out.println("--------------------------------------");
		int eid = ValidationUtil.inputInt("Enter Emp Id:");
		System.out.println("--------------------------------------");
		Employee employee = EmployeeDAO.getEmployee(eid);
		if (employee != null) {
			System.out.println(employee);
			System.out.println("--------------------------------------");
			employee.seteName(ValidationUtil.inputString("Enter new Name:"));
			employee.setGender(ValidationUtil.inputGendar("Enter Gendar(male/female/other):"));
			employee.setPhoneNo(ValidationUtil.inputPhoneNo("Enter Phone No:"));
			employee.setAge(ValidationUtil.inputInt("Enter Age:"));
			System.out.println("--------------------------------------");
			getAllDept();
			Deparment dept = EmployeeDAO.getDeptById(ValidationUtil.inputInt("Enter Dept Id:"));
			System.out.println("--------------------------------------");
			if (dept != null) {
				employee.setDept(dept);
				System.out.println("--------------------------------------");
				EmployeeDAO.updateEmployee(employee);
			} else {
				System.out.println("Dept Not Found..!");
				dept = EmployeeDAO.getDeptById(ValidationUtil.inputInt("Enter Dept Id:"));
			}
		} else {
			System.out.println("Employee Not Found..!");
		}
	}

	@Override
	public void updateDept() {
		System.out.println("--------------------------------------");
		Deparment dept = EmployeeDAO.getDeptById(ValidationUtil.inputInt("Enter Dept Id:"));
		List<Employee> empList = dept.getEmps();
		System.out.println("--------------------------------------");
		if (dept != null) {
			dept.setdName(ValidationUtil.inputString("Enter New Dept Name:"));
			dept.setEmps(empList);
			EmployeeDAO.updateDept(dept);
		} else {
			System.out.println("Dept Not Found..!");
		}

	}

	@Override
	public void deleteEmployeeOnly() {
		System.out.println("--------------------------------------");
		int eid = ValidationUtil.inputInt("Enter Emp Id:");
		System.out.println("--------------------------------------");
		Employee employee = EmployeeDAO.getEmployee(eid);
		if (employee != null) {
			EmployeeDAO.deleteEmp(employee);
		} else {
			System.out.println("Employee Not Found..!");
		}

	}

	@Override
	public void deleleDeptAndEmp() {
		System.out.println("--------------------------------------");
		Deparment dept = EmployeeDAO.getDeptById(ValidationUtil.inputInt("Enter Dept Id:"));
		List<Employee> empList = dept.getEmps();
		System.out.println("--------------------------------------");
		if (dept != null) {
			EmployeeDAO.deleteDeptAndEmployee(dept);
		} else {
			System.out.println("Dept Not Found..!");
		}

	}

	@Override
	public void deleteDeptOnly() {
		
	}

	@Override
	public void AddDeptToExistingEmp() {
		System.out.println("--------------------------------------");
		int eid = ValidationUtil.inputInt("Enter Emp Id:");
		System.out.println("--------------------------------------");
		Employee employee = EmployeeDAO.getEmployee(eid);
		System.out.println("--------------------------------------");
		if (employee != null) {
			getAllDept();
			System.out.println("--------------------------------------");
			Deparment dept = EmployeeDAO.getDeptById(ValidationUtil.inputInt("Enter Dept Id:"));
			System.out.println("--------------------------------------");
			if (dept != null) {
				employee.setDept(dept);
				EmployeeDAO.updateEmployee(employee);
			} else {
				System.out.println("Dept Not Found..!");
				dept = EmployeeDAO.getDeptById(ValidationUtil.inputInt("Enter Dept Id:"));
			}
		} else {
			System.out.println("Employee Not Found..!");
		}

	}

	@Override
	public void AddEmpToExistingDept() {
		System.out.println("--------------------------------------");
		Deparment dept = EmployeeDAO.getDeptById(ValidationUtil.inputInt("Enter Dept Id:"));
		List<Employee> empList = dept.getEmps();
		System.out.println("--------------------------------------");
		if (dept != null) {
			int num = ValidationUtil.inputInt("what num of Employee Add:");
			System.out.println("--------------------------------------");
			for (int i = 0; i < num; i++) {
				Employee employee = new Employee();
				System.out.println("--------------------------------------");
				employee.seteName(ValidationUtil.inputString("Enter Name:"));
				employee.setGender(ValidationUtil.inputGendar("Enter Gendar(male/female/other):"));
				employee.setPhoneNo(ValidationUtil.inputPhoneNo("Enter Phone No:"));
				employee.setAge(ValidationUtil.inputInt("Enter Age:"));
				System.out.println("--------------------------------------");
				employee.setDept(dept);
				EmployeeDAO.addEmployee(employee);
				empList.add(employee);
			}
			dept.setEmps(empList);
			EmployeeDAO.updateDept(dept);
		} else {
			System.out.println("Dept Not Found..!");
		}
	}

}
