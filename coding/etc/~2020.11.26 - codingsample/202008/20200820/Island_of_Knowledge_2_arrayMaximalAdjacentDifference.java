package Island_of_Knowledge;

import java.util.stream.IntStream;

public class Island_of_Knowledge_2_arrayMaximalAdjacentDifference {
	
	static int arrayMaximalAdjacentDifference(int[] inputArray) {
		return IntStream.range(1,inputArray.length).map(i->Math.abs(inputArray[i]-inputArray[i-1])).max().getAsInt();
	}


	public static void main(String[] args) {
		int a[] = {2,4,1,0};
		System.out.println(arrayMaximalAdjacentDifference(a));

	}

}
