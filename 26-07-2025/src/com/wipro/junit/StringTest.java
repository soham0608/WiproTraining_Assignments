package com.wipro.junit;

public class StringTest {
	
	public static boolean isUpperCase(String input) {
        if (input == null || input.isEmpty()) {
        	return false;
        }
        return input.equals(input.toUpperCase());
    }
}
