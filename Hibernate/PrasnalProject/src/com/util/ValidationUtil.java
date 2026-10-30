package com.util;

import java.util.InputMismatchException;
import java.util.regex.Pattern;

public class ValidationUtil {

	public static int validInt(String num) {
		if(!(Pattern.matches("[0-9]", num))) {
			System.err.println("Invalid Input..!");
		}
		return Integer.parseInt(num);
	}
	
}
