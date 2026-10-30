package com.controller;

import com.services.PersonAdharServices;
import com.util.ValidetionUtil;

public class Controller {

	PersonAdharServices services = new PersonAdharServices();

	public void MainMenu() {

		boolean flag = true;
		while (flag) {
			menu();
			int key = ValidetionUtil.validInt("Enter your choice:");
			switch (key) {
			case 1:
				services.addPerson();
				break;
			case 2:
				services.addAadhar();
				break;
			case 3:
				services.getPerson();
				break;
			case 4:
				services.getAdharUsingPersonId();
				break;
			case 5:
				services.updatePerson();
				break;
			case 6:
				services.updateAdharUsingPersonId();
				break;

			case 7:
				services.deletePerson();
				break;

			case 8:
				services.deleteAdharUsingPersonId();
				break;

			case 0:
				flag = false;
				System.out.println("Exit..!");
				break;

			default:
				System.out.println("Invalid Input..!");
				break;
			}
		}

	}

	public void menu() {
		System.out.println("=========================================");
		System.out.println("       Person Management System");
		System.out.println("=========================================");
		System.out.println("1. Add Person");
		System.out.println("2. Add Aadhaar");
		System.out.println("3. Get Person");
		System.out.println("4. Get Aadhaar Using Person ID");
		System.out.println("5. Update Person");
		System.out.println("6. Update Aadhaar Using Person ID");
		System.out.println("7. Delete Person");
		System.out.println("8. Delete Aadhaar Using Person ID");
		System.out.println("0. Exit");
		System.out.println("=========================================");
	}
}
