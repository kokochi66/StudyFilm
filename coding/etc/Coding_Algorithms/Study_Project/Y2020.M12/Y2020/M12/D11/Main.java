package Y2020.M12.D11;

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
		BigInteger a = new BigInteger("1");
		BigInteger c = new BigInteger("1");
		for(int i=1;i<n;i++) {
			c = c.add(new BigInteger("1"));
			a = a.multiply(c);
		}
		String numb = a.toString();
		int m = numb.length()-1;
		int count=0;
		while(numb.charAt(m) == '0') {
			m--;
			count++;
		}
		System.out.println(count);
	}
//	public static void solution() throws Exception {
//		int n = Integer.parseInt(rd.readLine());
//		tok = new StringTokenizer(rd.readLine());
//		int[] arr = new int[n];
//		for(int i=0;i<n;i++) {
//			arr[i] = Integer.parseInt(tok.nextToken());
//		}
//		int[] dp = new int[n];
//		for(int i=0;i<n;i++) dp[i] = arr[i];
//		for(int i=n-1;i>=0;i--) {
//			for(int j=i+1;j<n;j++) {
//				if(arr[i] < arr[j]) {
//					dp[i] = Math.max(dp[i], arr[i] + dp[j]);
//				}
//			}
//		}
//		System.out.println(Arrays.stream(dp).max().getAsInt());
//	}
}