package Edge_of_the_Ocean;

public class Main {
	public static void main(String[] args) {
		func f = new func();
		int a[] = {1,333,555,4,222};
		int[][] mat = {
				{0,1,1,2},
				{0,5,0,0},
				{2,0,3,3},
		};
		System.out.println(f.adjacentElementsProduct(a));
		System.out.println(f.shapeArea(5));
		System.out.println(f.makeArrayConsecutive2(a));
		System.out.println(f.almostIncreasingSequence(a));
		System.out.println(f.matrixElementsSum(mat));
		
	}

}
