package Exploring_the_Waters;

public class Exploring_the_Waters_4_arrayChange {
	static int arrayChange(int[] inputArray) {
		int sum = 0;
		for(int i=1;i<inputArray.length;i++) {
			if(inputArray[i]<=inputArray[i-1]) {
				sum+=inputArray[i-1]-inputArray[i]+1;
				inputArray[i] = inputArray[i-1]+1;
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		int a[] = {1,1,1};
		System.out.println(arrayChange(a));
		
	}

}
