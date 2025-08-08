package com.wipro.basic;

public class VowelsConstants {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int countVowels = 0;
		int countConsonants = 0;
		
		String str = "SohamTanavade";
		for(int i=0; i<str.length(); i++)
		{
			if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u' )
			{
				countVowels++;
			}
			else
			{
				countConsonants++;
			}
		}
		System.out.println("VOwels: "+countVowels);
		System.out.println("VOwels: "+countConsonants);
	}

}
