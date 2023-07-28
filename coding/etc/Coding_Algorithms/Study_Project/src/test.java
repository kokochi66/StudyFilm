import java.util.*;
import java.io.*;
public class test {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		int[][] arr =  {
			{1,2},{3,4}
		};
		Arrays.sort(arr, (int[] a,int[] b) -> {
			return 0;
		});
		
	}
	
	public static int Pib(int n) throws Exception {
		if(n ==  0) return 1;
		else if(n == 1) return 1;
		return Pib(n-1) + Pib(n-2);
	}
}