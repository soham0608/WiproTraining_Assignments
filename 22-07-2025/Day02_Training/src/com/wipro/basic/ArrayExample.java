package com.wipro.basic;

public class ArrayExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {100, 67, 98, 678, 45, 1 ,23};
		int max = arr[0];
		for(int i=1; i<arr.length; i++)
		{
			if(arr[i]>max)
			{
				max=arr[i];
			}
		}
		System.out.println(max);
	}

}
