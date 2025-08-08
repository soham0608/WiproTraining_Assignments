package com.wipro.basic;

public class StringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "SOHAM";
//		String revStr = "";
//		for(int i=str.length()-1 ; i>=0; i--)
//		{	
//		    revStr+= str.charAt(i);
//		}
		
		StringBuilder sb = new StringBuilder("SOHAM");
		sb.reverse();
		System.out.println(sb);
		if(sb.equals(sb))
			System.out.println("Palindrome");
		else
			System.out.println("NOT Palindrome");	
	}
}
