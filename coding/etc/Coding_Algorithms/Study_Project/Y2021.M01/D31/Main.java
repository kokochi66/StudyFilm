package Y2021.M1.D31;
import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		solution();
	}
	public static void solution() throws Exception {
		int n = Integer.parseInt(rd.readLine());
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-1-i;j++) wr.write(" ");
			for(int j=0;j<=i;j++) wr.write("* ");
			wr.newLine();
		}
		wr.flush();
	}
//	public static void solution() throws Exception {
//		int n = Integer.parseInt(rd.readLine());
//		max = 0;
//		tok = new StringTokenizer(rd.readLine());
//		int[] arr = new int[n];
//		for(int i=0;i<n;i++) arr[i] = Integer.parseInt(tok.nextToken());
//		int[] oper = new int[n];
//		boolean[] used = new boolean[n];
//		btk(arr,used,oper,0);
//		System.out.println(max);
//	}
//	static int max;
//	public static void btk(int[] arr, boolean[] used, int[] oper, int k) {
//		if(k == arr.length) {
//			max = Math.max(max, calcul(oper));
//		} else {
//			for(int i=0;i<arr.length;i++) {
//				if(!used[i]) {
//					oper[k] = arr[i];
//					used[i] = true;
//					btk(arr,used,oper,k+1);
//					used[i] = false;
//				}
//			}
//		}
//	}
//	public static int calcul(int[] arr) {
//		int sum = 0;
//		for(int i=0;i<arr.length-1;i++) sum += Math.abs(arr[i] - arr[i+1]);
//		return sum;
//	}
//	public static void solution() throws Exception {
//		tok = new StringTokenizer(rd.readLine());
//		BigInteger a = new BigInteger(tok.nextToken());
//		BigInteger b = new BigInteger(tok.nextToken());
//		System.out.println(a.add(b));
//	}
}