package Island_of_Knowledge;

public class Island_of_Knowledge_4_avoidObstacles {
	static int avoidObstacles(int[] inputArray) {
		int len = inputArray.length;
		for(int i=2;i<1002;i++) {
			for(int j=0;j<len;j++) {
				if(inputArray[j]%i==0) break;
				else if(inputArray[j]%i!=0&&j==len-1) return i;
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		int[] a = {5,3,6,7,9};
		System.out.println(avoidObstacles(a));

	}

}
