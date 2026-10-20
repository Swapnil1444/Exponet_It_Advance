package com.services;

import java.util.ArrayList;
import java.util.List;

import com.dao.StudentDAO;
import com.model.Student;
import com.model.Subject;
import com.util.ValidationUtil;

public class StudentServiceImp implements StudentServices {

	@Override
	public void addStudent() {
		Student s = new Student();
		s.setName(ValidationUtil.inputString("Enter Name: "));
		s.setAge(ValidationUtil.inputInt("Enter Age: "));
		s.setGender(ValidationUtil.inputGendar("Enter Gender (male/female/other): "));
		s.setPhoneNo(ValidationUtil.inputPhoneNo("Enter Phone No: "));
		s.setAddress(ValidationUtil.inputlongString("Enter Address: "));
		s.setSubList(addSubjectList());
		int id = StudentDAO.AddStudent(s);
		if (id != 0) {
			System.out.println("Student added successfully!");
			System.out.println("Generated Student ID: " + id);
		} else {
			System.out.println("Failed to add student.");
		}

	}

	public List<Subject> addSubjectList() {
		int num = ValidationUtil.inputInt("How many subjects do you want to add? ");
		List<Subject> subs = new ArrayList<Subject>();
		for (int i = 0; i < num; i++) {
			Subject sub = new Subject();
			sub.setName(ValidationUtil.inputString("Enter Subject Name " + (i + 1) + " :"));
			subs.add(sub);

		}
		return subs;
	}

	@Override
	public void addSubject() {
		int id = ValidationUtil.inputInt("Enter Student Id:");
		Student stud = StudentDAO.getStudentById(id);
		if (stud != null) {
			System.out.println(stud);
			stud.setSubList(addSubjectList());
			StudentDAO.updateStudent(stud);
		} else {
			System.out.println("Student not found..!");
		}
	}

	@Override
	public void getAllStudents() {
		List<Student> studList = StudentDAO.getAllStudent();
		if (studList != null) {
			for (Student s : studList) {
				System.out.println(s);
			}
		} else {
			System.out.println("Not Any Student Exating..!");
		}

	}

	@Override
	public void getStudentById() {
		int id = ValidationUtil.inputInt("Enter Student Id:");
		Student stud = StudentDAO.getStudentById(id);
		if (stud != null) {
			System.out.println(stud);
		} else {
			System.out.println("Student not found..!");
		}

	}

	@Override
	public void getSubjectsByStudentId() {

		int id = ValidationUtil.inputInt("Enter Student Id:");
		Student stud = StudentDAO.getStudentById(id);
		if (stud != null) {
			List<Subject> sub = stud.getSubList();
			if (sub != null) {
				for (Subject subject : sub) {
					System.out.println(subject);
				}
			} else {
				System.out.println("Subject not assin");
			}
		} else {
			System.out.println("Student not found..!");
		}

	}

	@Override
	public void updateStudent() {
		int id = ValidationUtil.inputInt("Enter Student Id:");
		Student stud = StudentDAO.getStudentById(id);
		if (stud != null) {
			System.out.println(stud + "\n");
			stud.setName(ValidationUtil.inputString("Enter Name: "));
			stud.setAge(ValidationUtil.inputInt("Enter Age: "));
			stud.setGender(ValidationUtil.inputGendar("Enter Gender (male/female/other): "));
			stud.setPhoneNo(ValidationUtil.inputPhoneNo("Enter Phone No: "));
			stud.setAddress(ValidationUtil.inputlongString("Enter Address: "));
			stud.setSubList(addSubjectList());
			StudentDAO.updateStudent(stud);

		} else {
			System.out.println("Student not found..!");
		}

	}

	@Override
	public void updateSubject() {

		int id = ValidationUtil.inputInt("Enter Student Id: ");

		Student stud = StudentDAO.getStudentById(id);

		if (stud != null) {

			List<Subject> subList = stud.getSubList();

			if (subList != null && !subList.isEmpty()) {

				System.out.println("Subjects:");

				for (Subject subject : subList) {
					System.out.println("Subject ID: " + subject.getId() + ", Name: " + subject.getName());
				}

				int subjectId = ValidationUtil.inputInt("Enter Subject Id to Update: ");

				boolean found = false;

				for (Subject subject : subList) {

					if (subject.getId() == subjectId) {

						String newName = ValidationUtil.inputString("Enter New Subject Name: ");

						subject.setName(newName);
						found = true;
						break;
					}
				}

				if (found) {
					StudentDAO.updateStudent(stud);
					System.out.println("Subject updated successfully!");
				} else {
					System.out.println("Subject not found!");
				}

			} else {
				System.out.println("No subjects assigned to this student.");
			}

		} else {
			System.out.println("Student not found!");
		}
	}

	@Override
	public void deleteStudent() {
		int id = ValidationUtil.inputInt("Enter Student Id:");
		Student stud = StudentDAO.getStudentById(id);
		if (stud != null) {
			StudentDAO.deleteStudent(stud);
		} else {
			System.out.println("Student not found..!");
		}
	}

	@Override
	public void deleteSubject() {

		int id = ValidationUtil.inputInt("Enter Student Id:");
		Student stud = StudentDAO.getStudentById(id);
		boolean found = true;
		Subject subject = null;
		if (stud != null) {
			List<Subject> subList = stud.getSubList();
			if (subList != null) {
				System.out.println(subList);
				int subId = ValidationUtil.inputInt("Enter Id wont to Delete Subject:");
				for (Subject sub : subList) {
					if (sub.getId() == subId) {
						subject = sub;
						// StudentDAO.deleteSubject(sub);
						found = false;  
					}
				}
				if (!found) {
					subList.remove(subject);
					StudentDAO.deleteSubject(subject);

				} else {
					System.out.println(subId + " this Subject Id not Found..!");
				}

			} else {
				System.out.println("no Subject Found..!");
			}

		} else {
			System.out.println("Student not found..!");
		}

	}

}
