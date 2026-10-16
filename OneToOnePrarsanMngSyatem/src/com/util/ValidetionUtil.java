package com.util;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidetionUtil {

	static Scanner scanner = new Scanner(System.in);

	public static String validString(String promt) {
		scanner.nextLine();
         System.out.print(promt);
         String value=scanner.nextLine().trim();
         return value;
	}
	
	public static int validInt(String promt) {
		System.out.print(promt);
		String num=scanner.next().trim();
		if(Pattern.matches("[0-9]+", num)) {
			return Integer.parseInt(num);
		}
		return validInt("Invalid: Please "+promt);
	}
	
	public static String ValidAdhar(String promt) {
		System.out.print(promt);
		String adhar=scanner.next().trim();
		if(Pattern.matches("[0-9]+", adhar)) {
			return adhar;
		}
		return ValidAdhar("Invalid: Please "+promt);
	}
}
