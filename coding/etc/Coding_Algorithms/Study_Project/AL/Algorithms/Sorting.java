package Algorithms;

import java.util.Arrays;

public class Sorting {

	public static void main(String[] args) {
		int[] arr = {1,5,9,3,2,8,6,7};
		InsertSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void BubbileSort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length - i - 1;j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	public static void InsertSort(int[] arr) {
		for(int i=0;i<arr.length-1 ;i++) {
			int j = i;
			while(arr[j] > arr[j+1]) {
				int temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
				j--;
			}
		}
	}
	public static void QuickSort(int[] arr) {
		
	}
}
