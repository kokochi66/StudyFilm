package N6_Rains_of_Reason;

import java.util.Arrays;

public class Rains_of_Reason_1_arrayReplace {
	static int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {
		for(int i=0;i<inputArray.length;i++) if(inputArray[i]==elemToReplace) inputArray[i] = substitutionElem;
		return inputArray;
	}
	
	static int[] arrayReplace2(int[] inputArray, int elemToReplace, int substitutionElem) {
		return Arrays.stream(inputArray).map(i -> i == elemToReplace ? substitutionElem : i).toArray();
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,1};
		for(int i=0;i<a.length;i++) System.out.print(arrayReplace(a,1,3)[i]+" ");
		System.out.println();
		for(int i=0;i<a.length;i++) System.out.print(arrayReplace2(a,1,3)[i]+" ");
		System.out.println();
	}
	
}
