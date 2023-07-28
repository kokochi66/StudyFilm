package Y2021.M06.D01;
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
		
		tok = new StringTokenizer(rd.readLine());
		arr[0] = Integer.parseInt(tok.nextToken());
		for(int i=1;i<n;i++) {
			arr[i] = arr[i-1] + Integer.parseInt(tok.nextToken());
		}
		for(int i=0;i<m;i++) {
			tok = new StringTokenizer(rd.readLine());
			int left = Integer.parseInt(tok.nextToken()) - 1;
			int right = Integer.parseInt(tok.nextToken()) - 1;
			int res = left > 0 ? arr[right] - arr[left-1] : arr[right];
			wr.write(res+"");
			wr.newLine();
		}
		
		wr.flush();
		wr.close();
		rd.close();
	}
}