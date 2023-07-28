package Y2021.M04.D09;
import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		solution();
	}
	public static void solution() throws Exception {
		tok = new StringTokenizer(rd.readLine());
		int n = Integer.parseInt(tok.nextToken());
		int k = Integer.parseInt(tok.nextToken());
		tok = new StringTokenizer(rd.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(tok.nextToken());
		}
		int l = 1, r = n+1; 
		while(r - l > 1) {
			 int m = (l+r)/2 ;
			 int[] brr = new int[n];
			 for(int i=0;i<n;i++) {
				 if(arr[i] < m) brr[i] = -1;
				 else brr[i] = 1;
			 }
			 for(int i=1;i<n;i++) brr[i] = brr[i] + brr[i-1];
			 int min = 0, max = brr[k-1];
			 for(int i=k;i<n;i++) {
				 min = Math.min(min, brr[i-k]);
				 max = Math.max(max, brr[i] - min);
			 }
			 if(max > 0) l = m;
			 else r = m;
		}
		System.out.println(l);
	}
}