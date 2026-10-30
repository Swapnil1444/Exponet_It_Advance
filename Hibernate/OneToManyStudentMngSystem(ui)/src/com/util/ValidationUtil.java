
package com.util;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.model.Gender;

public class ValidationUtil {

    private static final Scanner sc = new Scanner(System.in);

    // Integer input
    public static int inputInt(String prompt) {
        System.out.print(prompt);
        String num = sc.next().trim();

        if (Pattern.matches("[0-9]+", num)) {
            try {
                return Integer.parseInt(num);
            } catch (NumberFormatException e) {
                System.out.println("Number is too large. Try again.");
            }
        } else {
            System.out.println("Invalid input! Enter numbers only.");
        }

        return inputInt(prompt);
    }

    // String input: letters only
    public static String inputString(String prompt) {
        System.out.print(prompt);
        String value = sc.next().trim();

        if (Pattern.matches("[a-zA-Z]+", value)) {
            return value;
        }

        System.out.println("Invalid input! Enter letters only.");
        return inputString(prompt);
    }

    // Long string input: accepts spaces
    public static String inputlongString(String prompt) {
        System.out.print(prompt);

        String value = sc.nextLine().trim();

        // Handle a pending newline from nextInt()/next()
        if (value.isEmpty()) {
            value = sc.nextLine().trim();
        }

        if (!value.isEmpty()) {
            return value;
        }

        System.out.println("Input cannot be empty.");
        return inputlongString(prompt);
    }

    // Gender input
    public static Gender inputGendar(String prompt) {
        System.out.print(prompt);
        String value = sc.next().trim();

        try {
            return Gender.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid gender! Enter Male, Female, or Other.");
            return inputGendar(prompt);
        }
    }

    // Indian mobile number validation
    public static String inputPhoneNo(String prompt) {
        System.out.print(prompt);
        
        String value = sc.next().trim();

        if (Pattern.matches("[6-9][0-9]{9}", value)) {
            return value;
        }

        System.out.println("Invalid mobile number! Enter a valid 10-digit number.");
        return inputPhoneNo(prompt);
    }
}
