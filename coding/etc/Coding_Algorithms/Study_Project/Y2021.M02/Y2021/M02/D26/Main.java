package Y2021.M02.D26;
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
		int[] arr = new int[n];
		tok = new StringTokenizer(rd.readLine());
		int sum = 0;
		int res = 0;
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(tok.nextToken());
		}
		int left = 0;
		for(int i=0;i<n;i++) {
			sum += arr[i];
			if(sum > k) {
				while(sum>k) {
					sum -= arr[left];
					left++;
				}
			}
			if(sum == k) {
				res++;
			}
		}
		System.out.println(res);
	}
}