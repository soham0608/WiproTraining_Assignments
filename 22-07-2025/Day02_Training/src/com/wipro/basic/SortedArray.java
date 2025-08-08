package com.wipro.basic;

public class SortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {1,1,2,2,3,4,4,5};
		int n = arr.length;
		int[] arr2 = new int[n]; 
        int j = 0; 

        arr2[j] = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                j++;
                arr2[j] = arr[i];
            }
        }

        System.out.println("Length = " + (j + 1));
        for (int i = 0; i <= j; i++) {
            System.out.print(arr2[i] + " ");
        }
	}

}
