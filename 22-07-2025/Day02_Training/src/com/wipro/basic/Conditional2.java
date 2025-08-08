package com.wipro.basic;

public class Conditional2 {
	public static void main(String[] args) 
	{
//		double number = 5;
//		
//		if (number == 0) 
//		{
//            System.out.println("Zero");
//        }
//		else
//		{
//            if (number > 0) 
//            {
//                System.out.print("Positive");
//            } else 
//            {
//                System.out.print("Negative");
//            }
//
//            double absValue = Math.abs(number);
//
//            if (absValue < 1)
//            {
//                System.out.print(" and small");
//            } else if (absValue > 1000000) 
//            {
//                System.out.print(" and large");
//            }
//        }
		
		double no = 25.586;
		double no2 = 25.579;
		
		if(no == no2)
		{
			System.out.println("Number is same "+ no + " & " + no2);
		}
		else
		{
			System.out.println("Number is Different "+ no + " & " + no2);
		}
		
		if(Math.round(no)==Math.round(no2))
		{
			System.out.println("Number is same "+ no + " & " + no2);
		}
		else
		{
			System.out.println("Number is Different "+ no + " & " + no2);
		}
	}
}
