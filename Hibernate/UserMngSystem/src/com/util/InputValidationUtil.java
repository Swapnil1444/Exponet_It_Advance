package com.util;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputValidationUtil {

	private static Scanner sc = new Scanner(System.in);

	public static int  inputInt(String promt) {
		System.out.print(promt);
		String num = sc.next();
		if (Pattern.matches("[0-9]+", num)) {
			return Integer.parseInt(num);
		}
		System.out.println("Invalid Input");
		return inputInt(promt);
	}

	public static String inputString(String promt) {
		System.out.print(promt);
		String value = sc.next();
		return value;
	}
	
	public static String validPhoneNo(String promt) {
		System.out.print(promt);
		String num = sc.next();
		if (Pattern.matches("[6-9]{1}[0-9]{9}", num)) {
			return num;
		}
		System.out.println("Invalid Input");
		return validPhoneNo(promt);
	}
	
	public static String validEmail(String promt) {
		System.out.print(promt);
		String email = sc.next();
		if (Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",email)){
			return email;
		}
		System.out.println("Invalid Input "+email);
		return validPhoneNo(promt);
	}

	
}
