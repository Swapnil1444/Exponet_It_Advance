package com.services;

import com.dao.PrasanDAO;
import com.model.Adhar;
import com.model.Parson;
import com.util.ValidetionUtil;

public class PersonAdharServices {

	public void addPerson() {
		Parson p = new Parson();
		p.setpName(ValidetionUtil.validString("Enter Name:"));
		Adhar adhar = new Adhar();
		adhar.setAdharNo(ValidetionUtil.ValidAdhar("Enter Adhar No:"));
		p.setAdhar(adhar);
		int id = PrasanDAO.addPerson(p);
		if (id != 0) {
			System.out.println("Add Person");
			System.out.println("Genreted id:" + id);
		}
	}

	public void addAadhar() {

		Adhar a = new Adhar();
		a.setAdharNo(ValidetionUtil.ValidAdhar("Enter Adhar :"));
		int id = PrasanDAO.addAdhar(a);
		if (id != 0) {
			System.out.println("Add Adhar");
			System.out.println("Genreted id:" + id);
		}
	}

	public void getPerson() {
		int id = ValidetionUtil.validInt("Enter Person Id:");
		Parson person = PrasanDAO.getPerson(id);
		if (person == null) {
			System.out.println("Person Not Found ");
		} else {
			System.out.println(person);
		}

	}

	public void getAdharUsingPersonId() {

		int id = ValidetionUtil.validInt("Enter Person Id:");
		Parson person = PrasanDAO.getPerson(id);
		if (person == null) {
			System.out.println("Person Not Found ");
		} else {
			System.out.println(person.getAdhar());
		}

	}

	public void updatePerson() {
		int id = ValidetionUtil.validInt("Enter Person Id:");
		Parson person = PrasanDAO.getPerson(id);
		if (person == null) {
			System.out.println("Person Not Found ");
		} else {
			person.setpName(ValidetionUtil.validString("Enter Person Name:"));
			PrasanDAO.UpdatePerson(person);
		}
	}

	public void updateAdharUsingPersonId() {

		int id = ValidetionUtil.validInt("Enter Person Id:");
		Parson person = PrasanDAO.getPerson(id);
		if (person == null) {
			System.out.println("Person Not Found ");
		} else {
			Adhar adhar = person.getAdhar();
			adhar.setAdharNo(ValidetionUtil.ValidAdhar("Enter Adhar No:"));
			PrasanDAO.UpdatePerson(person);
		}

	}

	public void deletePerson() {
		int id = ValidetionUtil.validInt("Enter Person Id:");
		Parson person = PrasanDAO.getPerson(id);
		if (person == null) {
			System.out.println("Person Not Found ");
		} else {
			PrasanDAO.deletePerson(person);
		}

	}

	public void deleteAdharUsingPersonId() {
		int id = ValidetionUtil.validInt("Enter Person Id:");
		Parson person = PrasanDAO.getPerson(id);
		if (person == null) {
			System.out.println("Person Not Found ");
		} else {
			PrasanDAO.deleteAdharusingPersonId(person);
		}

	}

}
