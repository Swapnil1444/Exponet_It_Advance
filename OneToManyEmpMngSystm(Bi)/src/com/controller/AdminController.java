package com.controller;

import com.sevices.EmployeeServiceImp;
import com.sevices.EmployeeServices;
import com.util.ValidationUtil;

public class AdminController {

	public static void main(String[] args) {

		MainMenu();
	}

	private static void MainMenu() {
		EmployeeServices service = new EmployeeServiceImp();
		boolean flag = true;
		while (flag) {
			menu();
			int choice = ValidationUtil.inputInt("Enter your choice: ");

			switch (choice) {

			case 1:
				service.addDeptOnly();
				break;

			case 2:
				service.addEmp();
				break;

			case 3:
				service.getAllEmpByDept();
				break;

			case 4:
				service.getAllDept();
				break;

			case 5:
				service.updateEmp();
				break;

			case 6:
				service.updateDept();
				break;

			case 7:
				service.deleteEmployeeOnly();
				break;

			case 8:
				service.deleleEmployeeAndAllEmp();
				break;

			case 9:
				service.deleteDeptOnly();
				break;

			case 10:
				service.AddDeptToExistingEmp();
				break;

			case 11:
				service.AddEmpToExistingDept();
				break;

			case 0:
				flag = false;
				System.out.println("Exiting Employee Management System...");
				break;

			default:
				System.out.println("Invalid choice! Please try again.");
			}
		}
	}

	public static void menu() {

		System.out.println("======================================");
		System.out.println(" EMPLOYEE & DEPARTMENT MANAGEMENT");
		System.out.println("======================================");
		System.out.println("1.  Add Department Only");
		System.out.println("2.  Add Employee");
		System.out.println("3.  Get All Employees by Department");
		System.out.println("4.  Get All Departments");
		System.out.println("5.  Update Employee");
		System.out.println("6.  Update Department");
		System.out.println("7.  Delete Employee Only");
		System.out.println("8.  Delete Employee and Department");
		System.out.println("9.  Delete Department Only");
		System.out.println("10. Add Department to Existing Employee");
		System.out.println("11. Add Employee to Existing Department");
		System.out.println("0.  Exit");
		System.out.println("======================================");

	}

}
