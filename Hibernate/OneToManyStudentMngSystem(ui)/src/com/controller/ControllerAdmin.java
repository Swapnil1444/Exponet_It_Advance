package com.controller;

import com.services.StudentServiceImp;
import com.services.StudentServices;
import com.util.ValidationUtil;

public class ControllerAdmin {

	public static void meinMenu() {
		StudentServices s = new StudentServiceImp();
		boolean flag = true;
		while (flag) {
			menu();
			int key = ValidationUtil.inputInt("Enter your choice: ");
			switch (key) {
			case 0:
				flag = false;
				System.out.println("Exit..!");
				break;
			case 1:
				s.addStudent();
				break;
			case 2:
				s.addSubject();
				break;
			case 3:
				s.getAllStudents();
				break;
			case 4:
				s.getStudentById();
				break;
			case 5:
				s.getSubjectsByStudentId();
				break;
			case 6:
				s.updateStudent();
				break;
			case 7:
				s.updateSubject();
				break;

			case 8:
				s.deleteStudent();
				break;
			case 9:
				s.deleteSubject();
				break;
			default:
				System.out.println("Invalid Input..!");
				break;
			}

		}

	}

	public static void menu() {

		System.out.println("==================================");
		System.out.println("      STUDENT MANAGEMENT SYSTEM");
		System.out.println("==================================");

		System.out.println("1. Add Student");
		System.out.println("2. Add Subject to Student");
		System.out.println("3. Display All Students");
		System.out.println("4. Display Student by ID");
		System.out.println("5. Display Subjects by Student ID");
		System.out.println("6. Update Student Details");
		System.out.println("7. Update Subject Details");
		System.out.println("8. Delete Student");
		System.out.println("9. Delete Subject");
		System.out.println("0. Exit");

		System.out.println("==================================");
	}

}
