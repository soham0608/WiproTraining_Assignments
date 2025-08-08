package com.wipro.basic;

public class ReverseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5};
		int temp=0;
		int len = arr.length;
		for(int i=0;i<len/2;i++)
		{
			temp = arr[i];
			arr[i] = arr[len-1];
			arr[len-1] = temp;
			len--;
		}
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}

}
