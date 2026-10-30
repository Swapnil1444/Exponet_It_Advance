package com.Util;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidationUtil {
	
 static	Scanner sc=new Scanner(System.in);
	public static int inputInt(String Promt) {
		System.out.print(Promt);
		String num=sc.next().trim();
		if(Pattern.matches("[0-9]+", num)) {
			return Integer.parseInt(num);
		}
		System.err.println("Invalid Input ");
		return inputInt(Promt);
	}
	
	public static String inputString(String promt) {
		System.out.print(promt);
		String value=sc.next().trim();
		return value;
	}
	
	public static boolean inputBool(String promt) {
		System.out.println(promt);
		String value=sc.next();
		if(value.equalsIgnoreCase("true")||value.equalsIgnoreCase("false")) {
			return Boolean.parseBoolean(value);
		}
		System.out.print("Invalid Input..!");
		return inputBool(promt);
	}

}
