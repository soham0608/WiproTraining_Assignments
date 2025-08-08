package com.wipro.basic;

public class SecondLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {10, 5, 20, 8, 15};
		int max = arr[0];
		int max2 = arr[1];
		for(int i=1; i<arr.length; i++)
		{
			 if(arr[i] > max) 
			 {
	                max2 = max;
	                max = arr[i];
	         }
			 else if(arr[i] > max2 && arr[i] != max) 
	         {
	                max2 = arr[i];
	         }
		}
		System.out.println(max2);
	}

}
