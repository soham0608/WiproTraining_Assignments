package com.wipro.basic;

import java.util.Arrays;

public class AnagramsDemo {
	public static void main(String[] args) {
		String str1 = "listen";
        String str2 = "silent";

        if(str1.length()!=str2.length())
        	System.out.println("NOT ANAGRAMS");
        else
        {
        	 char[] arr1 = str1.toCharArray();
             char[] arr2 = str2.toCharArray();
             
             Arrays.sort(arr1);
             Arrays.sort(arr2);
        }
	}
}
