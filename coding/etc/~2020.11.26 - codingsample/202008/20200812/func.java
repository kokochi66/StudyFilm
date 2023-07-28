package Edge_of_the_Ocean;

import java.util.stream.IntStream;

public class func {
	int adjacentElementsProduct(int[] inputArray) {
		return IntStream.range(1, inputArray.length).map(i->inputArray[i]*inputArray[i-1]).max().getAsInt();
	}
	int shapeArea(int n) {
		return (n*n)+((n-1)*(n-1));
	}
	int makeArrayConsecutive2(int[] statues) {
		int max = statues[0];
		int min = statues[0];
		for(int i=0;i<statues.length;i++) {
			if(statues[i]>max) max = statues[i];
			if(statues[i]<min) min = statues[i];
		}
		return max-min-statues.length+1;
	}
	boolean almostIncreasingSequence(int[] sequence) {
		int sum=0;
		int i,j,k;
		boolean swit=false;
		if(sequence.length<=2) return true;		//배열의 길이가 1이나 2라면 무조건 true
		for(i=0;i<sequence.length-1;i++) {
			j=i+1;
			k=j+1;
			if(sequence[i]>=sequence[j]) {
				if(swit) sum++;
				sum++;
				swit=true;
			}
			if(sequence.length-1>=k) {
				if(sequence[i]>=sequence[k]) sum++;
			}
		}
		System.out.println(sum);
		return 3>sum;
	}
	int matrixElementsSum(int[][] matrix) {
		int var=0;
		for(int i=0;i<matrix[0].length;i++) {
			for(int j=0;j<matrix.length;j++) {
				if(matrix[j][i]!=0) var+=matrix[j][i];
				else break;
			}
		}
		return var;
	}

// 1 2 5 4 2


}
