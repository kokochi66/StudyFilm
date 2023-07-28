package D01;
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
		int m = Integer.parseInt(tok.nextToken());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(rd.readLine());
		}
		Arrays.sort(arr);
		
		int left = 1;
		int right = arr[n-1] - arr[0];
		
		while(left <= right) {
			int mid = (left + right) / 2;
			int point = arr[0], cnt = 1;
			boolean pass = true;
			
			for(int i=1;i<n;i++) {
				if(arr[i] - point >= mid) {
					point = arr[i];
					cnt++;
				}
			}
			
			if(cnt >= m) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
			
		}
		System.out.println(right);
	}
}