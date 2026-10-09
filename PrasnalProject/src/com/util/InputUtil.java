package com.util;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.exception.InputMissMatchException;

public class InputUtil {

	static Scanner sc = new Scanner(System.in);

	public static int inputInt(String promt) {
		//sc.nextLine();
		System.out.print(promt);
		String num = sc.next();
		try {
			return ValidationUtil.validInt(num);
		} catch (Exception e) {
			
			return inputInt(promt);
		}
	}
	
	public static String inputString(String promt) {
		//sc.nextLine();
		System.out.print(promt);
		return sc.next().trim();
	}

}
