package com.Controller;

import com.service.UserService;
import com.util.InputValidationUtil;

public class UserMenu {

    private final UserService service = new UserService();

    public void show() {

        boolean flag = true;

        while (flag) {

            displayMenu();

            int key = InputValidationUtil.inputInt("Select Option: ");

            switch (key) {

            case 1:
                service.inserUser();
                break;

            case 2:
                service.updateUser();
                break;

            case 3:
                service.getUser();
                break;

            case 4:
                service.deleteUser();
                break;

            case 5:
                service.getAllUser();
                break;

            case 6:
                service.getUserByName();
                break;

            case 0:
                flag = false;
                System.out.println("\nThank you for using User Management System!");
                System.out.println("Application closed successfully.");
                break;

            default:
                System.out.println("\nInvalid option! Please select from 0 to 6.");
                break;
            }
        }
    }

    private void displayMenu() {

        System.out.println("\n");
        System.out.println("==============================================");
        System.out.println("          USER MANAGEMENT SYSTEM");
        System.out.println("==============================================");
        System.out.println("  1. Insert User");
        System.out.println("  2. Update User");
        System.out.println("  3. Get User By ID");
        System.out.println("  4. Delete User");
        System.out.println("  5. Display All Users");
        System.out.println("  6. Search User By Name");
        System.out.println("  0. Exit");
        System.out.println("----------------------------------------------");
    }
}