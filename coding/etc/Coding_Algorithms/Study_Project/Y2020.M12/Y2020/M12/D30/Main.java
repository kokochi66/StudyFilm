package Y2020.M12.D30;
import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		solution3();
	}
	public static void solution3() throws Exception {
		tok = new StringTokenizer(rd.readLine());
		int n = Integer.parseInt(tok.nextToken());
		int m = Integer.parseInt(tok.nextToken());
		int[][] arr = new int[n][m];
		int[][] dp = new int[n][m];
		for(int i=0;i<n;i++) {
			tok = new StringTokenizer(rd.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(tok.nextToken());
				int l=0, u=0, e=0;
				if(j>0) l = dp[i][j-1];
				if(i>0) u = dp[i-1][j];
				if(i>0 && j>0) e = dp[i-1][j-1];
				dp[i][j] = l + (u-e) + arr[i][j];
			}
		}
		
		int k = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<k;TT++) {
			tok = new StringTokenizer(rd.readLine());
			int[] s = new int[4];
			for(int i=0;i<4;i++) {
				s[i] = Integer.parseInt(tok.nextToken())-1;
			}
			int a=dp[n-1][m-1],l=0,u=0,e=0,c=dp[s[2]][s[3]];
			if(s[1] > 0) l = dp[s[2]][s[1]-1];
			if(s[0] > 0) u = dp[s[0]-1][s[3]];
			if(s[0] > 0 && s[1] > 0) e = dp[s[0]-1][s[1]-1];
			long ans = a - (a-c) - l - (u-e);
			wr.write(ans+"");
			wr.newLine();
		}
		wr.flush();
	}
	public static void solution2() throws Exception {
		int n = Integer.parseInt(rd.readLine());
		int[] dp = new int[n+5];
		dp[0] = 1;
		dp[1] = 0;
		dp[2] = 3;
		for(int i=4;i<=n;i+=2) {
			dp[i] = 3*dp[i-2];
			for(int j=i-4;j>=0;j-=2) {
				dp[i] += 2*dp[j];
			}
		}
		System.out.println(dp[n]);
	}
	public static void solution() throws Exception {
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			tok = new StringTokenizer(rd.readLine());
			int n = Integer.parseInt(tok.nextToken());
			int m = Integer.parseInt(tok.nextToken());
			int c = n%10;
			for(int i=2;i<=m;i++) {
				c *= n;
				c %= 10;
			}
			if(c==0) wr.write("10");
			else wr.write(c+"");
			wr.newLine();
		}
		wr.flush();
	}
}