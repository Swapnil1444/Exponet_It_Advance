package com.util;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.model.Gender;

public class InputValidUtil {

	private static Scanner sc = new Scanner(System.in);

	public static int inputInt(String promt) {
		System.out.print(promt);
		String num = sc.next();
		if (Pattern.matches("[0-9]+", num)) {
			return Integer.parseInt(num);
		}
		System.err.println("Invalid Input");
		return inputInt(promt);
	}
	public static String inputString(String promt) {
		System.out.print(promt);
		String value = sc.next();
		return value;
	}
	
	public static String validName(String promt) {

		System.out.print(promt);
		String name = sc.next();
		if (Pattern.matches("[A-Za-z]+", name)) {
			return name;
		}
		System.err.println("Invalid Name...!");
		return validName(promt);
	}

	public static String validAdharNo(String promt) {
		System.out.print(promt);
		String no = sc.next();
		if (Pattern.matches("[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}", no)) {
			return no;
		}
		System.err.println("Invalid Aadhar Number...!");
		return validAdharNo(promt);
	}

	public static String validPanNo(String promt) {
		System.out.print(promt);
		String panNo = sc.next();
		if (Pattern.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}", panNo)) {
			return panNo;
		}
		System.err.println("Invalid Pan Card Number...!");
		return validPanNo(promt);
	}

	public static long validContectNo(String promt) {
		System.out.print(promt);
		String contectNo = sc.next();
		if (Pattern.matches("[6-9]{1}[0-9]{9}", contectNo)) {
			return Long.parseLong(contectNo);
		}
		System.err.println("Invalid Contect Number...!");
		return validContectNo(promt);
	}

	public static String validEmail(String promt) {
		System.out.print(promt);
		String email = sc.next();
		if (Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", email)) {
			return email;
		}
		System.err.println("Invalid Email Address...!");
		return validEmail(promt);
	}

	public static long validAccountNo(String p) {

		System.out.print(p);
		String no = sc.next();
		if (Pattern.matches("[0-9]{12}", no)) {
			return Long.parseLong(no);
		}
		System.err.println("Invalid Account No..!");
		return validAccountNo(p);
	}

	public static String validAccountType(String promt) {
		System.out.print(promt);
		String accType = sc.next();
		if ("Savings".equalsIgnoreCase(accType) || "Current".equalsIgnoreCase(accType)) {
			return accType.toUpperCase();
		}
		System.err.println("Invalid Account Type..!");
		return validAccountType(promt);
	}

	public static double ValidAmount(String p) {
		System.out.print(p);
		String amount = sc.next();
		if (Pattern.matches("[0-9]+", amount)) {

			double amount1 = Double.parseDouble(amount);
			if (amount1 >0) {
				System.out.println("---------------------------------------");
				return amount1;
			}else {
				System.err.println("Invalid Amount...!");
			}
		}
		System.err.println("Invalid");
		return ValidAmount(p);
	}

	public static long autoGenAccountNo() {
		return(long) (Math.random() * Math.pow(10, 12));
	}
	
	public static Gender inputGendar(String prompt) {
        System.out.print(prompt);
        String value = sc.next().trim();

        try {
            return Gender.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid gender! Enter Male, Female.");
            return inputGendar(prompt);
        }
    }

}
