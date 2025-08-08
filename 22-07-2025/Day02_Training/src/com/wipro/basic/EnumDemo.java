package com.wipro.basic;

public class EnumDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		enum Month {
			JAN,
			FEB,
			MAR,
			APR,
			MAY,
			JUN,
			JULY,
			AUG,
			SEPT,
			OCT,
			NOV,
			DEC
		}
		Month monthOfType = Month.FEB;
		if(monthOfType==Month.FEB)
		{
			System.out.println("FEBRURAY");
		}
	}

}
