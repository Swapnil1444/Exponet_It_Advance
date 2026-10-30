package com.controller;

import com.service.PersonServices;
import com.service.PersonServicesImp;
import com.util.ValidetionUtil;

public class AdminController {

	PersonServices service=new PersonServicesImp();
	public void mainMenu() {
		
		boolean flag=true;

	    do {
	        menu();
	        int key=ValidetionUtil.validInt("Enter your choice:");

	        switch (key) {

	            case 1:
	                service.addPerson();
	                break;

	            case 2:
	                service.getAll();
	                break;

	            case 3:
	                service.getPersonOnlyUsingPid();
	                break;

	            case 4:
	                service.getAdharOnlyUsingPid();
	                break;

	            case 5:
	                service.updatePersonDetailsUsingPid();
	                break;

	            case 6:
	                service.updateAdharDetailsUsingPid();
	                break;

	            case 7:
	                service.deletePersonOnlyUsingPid();
	                break;

	            case 8:
	                service.deleteAdharOnlyUsingPid();
	                break;

	            case 9:
	                service.getPersonOnlyUsingAid();
	                break;

	            case 10:
	                service.getAdharOnlyUsingAid();
	                break;

	            case 11:
	                service.updatePersonDetailsUsingAid();
	                break;

	            case 12:
	                service.updateAdharDetailsUsingAid();
	                break;

	            case 13:
	                service.deletePersonOnlyUsingAid();
	                break;

	            case 14:
	                service.deleteAdharOnlyUsingAid();
	                break;

	            case 0:
	                System.out.println("Thank you for using the system!");
	                flag=false;
	                break;

	            default:
	                System.out.println("Invalid choice! Please try again.");
	        }

	    } while (flag);
	}

	public void menu() {

		System.out.println("==============================================");
		System.out.println("       PERSON AND AADHAAR MANAGEMENT SYSTEM");
		System.out.println("==============================================");

		System.out.println(" 1. Add Person");
		System.out.println(" 2. Get All");
		System.out.println(" 3. Get Person Using PID");
		System.out.println(" 4. Get Aadhaar Using PID");
		System.out.println(" 5. Update Person Using PID");
		System.out.println(" 6. Update Aadhaar Using PID");
		System.out.println(" 7. Delete Person Using PID");
		System.out.println(" 8. Delete Aadhaar Using PID");
		System.out.println(" 9. Get Person Using AID");
		System.out.println("10. Get Aadhaar Using AID");
		System.out.println("11. Update Person Using AID");
		System.out.println("12. Update Aadhaar Using AID");
		System.out.println("13. Delete Person Using AID");
		System.out.println("14. Delete Aadhaar Using AID");

		System.out.println("0. Exit");

		System.out.println("==============================================");

	}

}
