package com.util;

import java.util.Scanner;
import java.util.regex.Pattern;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Gender;

public class ValidationUtil {

	private static Scanner sc = new Scanner(System.in);

	public static int inputInt(String promt) {

		System.out.print(promt);
		String num = sc.next().trim();
		if (Pattern.matches("[0-9]+", num)) {
			return Integer.parseInt(num);
		}
		return inputInt("Error: Please " + promt);
	}

	public static String inputString(String promt) {
		System.out.print(promt);
		String valuseString = sc.next().trim();
		if (Pattern.matches("[a-zA-Z]+", valuseString)) {
			return valuseString;
		}
		return inputString("Error: Please " + promt);
	}

	public static String inputlongString(String promt) {
		sc.nextLine();
		System.out.print(promt);
		String valuseString = sc.nextLine().trim();
		return valuseString;
	}

	public static Gender inputGendar(String promt) {
		System.out.print(promt);
		String valuse = sc.next().trim();
		if (valuse.equalsIgnoreCase("male") || valuse.equalsIgnoreCase("female") || valuse.equalsIgnoreCase("other")) {
			return Gender.valueOf(valuse.toUpperCase());
		}
		return inputGendar("Error: Please " + promt);
	}

	public static String inputPhoneNo(String promt) {
		System.out.print(promt);
		String valuse = sc.next().trim();
		if (!Pattern.matches("[6-9]{1} [0-9][9]", valuse)) {
			return valuse;
		}
		return inputPhoneNo("Error: Please " + promt);
	}

}
