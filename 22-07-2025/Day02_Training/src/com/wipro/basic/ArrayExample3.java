package com.wipro.basic;

public class ArrayExample3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] arr = {2,7,11,15};
		for(int i=0; i<arr.length-1; i++)
		{
			for(int j=i+1; j<arr.length; j++)
			{
				if(arr[i]+arr[j]==9)
				{
					System.out.println(i +" "+ j);
				}
			}
		}
	}

}
