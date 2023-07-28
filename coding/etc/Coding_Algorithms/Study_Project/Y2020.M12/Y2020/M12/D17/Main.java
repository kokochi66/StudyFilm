package Y2020.M12.D17;
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
		int n = Integer.parseInt(rd.readLine());
		int[] arr = new int[n];
		tok = new StringTokenizer(rd.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(tok.nextToken());
		}
		int[][] dp = new int[2][n];
		Arrays.fill(dp[0], 1);
		Arrays.fill(dp[1], 1);
		for(int i=n-2;i>=0;i--) {
			for(int j=i+1;j<n;j++) {
				if(arr[i] > arr[j]) {
					dp[0][i] = Math.max(dp[0][j]+1, dp[0][i]);
				}
			}
		}
		for(int i=1;i<n;i++) {
			for(int j=i-1;j>=0;j--) {
				if(arr[i] > arr[j]) {
					dp[1][i] = Math.max(dp[1][j]+1, dp[1][i]);
				}
			}
		}
		int max = 0;
		for(int i=0;i<n;i++) {
			if(max < dp[0][i] + dp[1][i]) max = dp[0][i] + dp[1][i];
		}
		System.out.println(max-1);
	}
}