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
		Student s=new Student();
		s.setName(ValidationUtil.inputString("Enter Name:"));
		s.setAge(ValidationUtil.inputInt("Enter Age:"));
		s.setGender(ValidationUtil.inputGendar("Enter Gendar(male/female/other):"));
		s.setPhoneNo(ValidationUtil.inputPhoneNo("Enter Phone No:"));
		s.setAddress(ValidationUtil.inputlongString("Enter Address:"));
		int num=ValidationUtil.inputInt("how wont to num of subject add:");
		List<Subject> subs=new ArrayList<Subject>();
		for(int i=0;i<num;i++) {
			Subject sub=new Subject();
			sub.setName("Enter Subject Name:");
			subs.add(sub);
		}
		s.setSubList(subs);
		
		int id=StudentDAO.AddStudent(s);
		if(id!=0) {
			System.out.println("Add Student Data");
			System.out.println("Gen Id:"+id);
		}

	}

	@Override
	public void addSubject() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAllStudents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getStudentById() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getSubjectsByStudentId() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStudent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSubject() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStudent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSubject() {
		// TODO Auto-generated method stub
		
	}

}
