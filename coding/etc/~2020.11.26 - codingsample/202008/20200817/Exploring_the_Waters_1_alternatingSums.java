package Exploring_the_Waters;

public class Exploring_the_Waters_1_alternatingSums {
	static int[] alternatingSums(int[] a) {
		int[] output = new int[2];
		for(int i=0;i<a.length;i++) output[i%2]+=a[i];
		return output;
	}


	public static void main(String[] args) {
		int[] var = {50, 60, 60, 45, 70};
		var = alternatingSums(var);
		for(int i=0;i<var.length;i++) System.out.print(var[i]+" ");

	}

}
