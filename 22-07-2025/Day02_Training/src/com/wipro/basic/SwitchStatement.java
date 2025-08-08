package com.wipro.basic;

public class SwitchStatement {
	public static void Main(String[] args)
	{
		char shape = 'C';
		switch(shape)
		{
		case 'R' :
			System.out.println("Rectangle");
			break;
		case 'S' :
			System.out.println("Square");
			break;
		case 'C' :
			System.out.println("Circle");
		default : 
			System.out.println("Unknown");
			break;
		}
	}
}
