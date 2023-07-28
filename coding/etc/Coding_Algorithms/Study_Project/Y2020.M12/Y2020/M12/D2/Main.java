package Y2020.M12.D2;
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
		int k = Integer.parseInt(tok.nextToken());
		boolean[] arr = new boolean[n+1];
		if(k>0) {
			for(int i=0;i<k;i++) arr[Integer.parseInt(rd.readLine())] = true;
		}
		int[] dp = new int[n+10];
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(i-j>=0 && !arr[i-j]) dp[i] += dp[i-j];
			}
		}
		
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[n]);
	}
//	public static void solution() throws Exception {
//		int n = Integer.parseInt(rd.readLine());
//		int[] arr = new int[n+5];
//		tok = new StringTokenizer(rd.readLine());
//		for(int i=1;i<=n;i++) arr[i] = Integer.parseInt(tok.nextToken());
//		int[][] dp = new int[n+5][2];
//		dp[0][0] = 0;
//		dp[0][1] = 0;
//		dp[1][0] = arr[1];
//		dp[1][1] = arr[1];
//		dp[2][0] = arr[2]+arr[1];
//		dp[2][1] = arr[2];
//		int max = 0;
//		max = dp[2][0];
//		for(int i=3;i<=n;i++) {
//			dp[i][0] = arr[i] + dp[i-1][1];
//			dp[i][1] = arr[i] + Math.max(Math.max(dp[i-2][0], dp[i-2][1])
//					, Math.max(dp[i-3][0], dp[i-3][1]));
//			if(max < Math.max(dp[i][0], dp[i][1]))
//				max = Math.max(dp[i][0], dp[i][1]);
//		}
//		System.out.println(max);
//	}
//	public static void solution() throws Exception {
//		str1 = rd.readLine().toCharArray();
//		str2 = rd.readLine().toCharArray();
//		int n = str1.length;
//		int m = str2.length;
//		dp = new Integer[n+1][m+1];
//		for(int i=0;i<=n;i++) {
//			dp[i][0] = i*3;
//		}
//		for(int i=0;i<=m;i++) {
//			dp[0][i] = i*2;
//		}
//		sol1(n,m);
//		for(int i=0;i<=n;i++) System.out.println(Arrays.toString(dp[i]));
//		System.out.println(dp[n][m]);
//		
//	}
//	static char[] str1;
//	static char[] str2;
//	static Integer[][] dp;
//	public static int sol1(int a, int b) {
//		if(a<0 || b<0) return 0;
//		if(dp[a][b] == null) {
//			dp[a][b] = 0;
//			int alp = 0;
//			if(str1[a-1] == str2[b-1]) alp = 0;
//			else alp = 1;
//			dp[a][b] = Math.min(sol1(a-1,b-1)+alp,Math.min(
//					sol1(a,b-1)+alp+2, sol1(a-1,b)+3));
//		}
//		return dp[a][b];
//	}
//	public static void solution() throws Exception {
//		int n = Integer.parseInt(rd.readLine());
//		int SqrtPoint = (int)Math.sqrt(n);
//		int min = 10000000;
//		for(int i=SqrtPoint;i>=1;i--) {
//			int count = 0, num = n;
//			for(int j=i;j>=1;j--) {
//				count += num/(j*j);
//				num %= (j*j);
//				System.out.println(j+" "+count+" "+num);
//			}
//			if(min > count) min = count;
//		}
//		System.out.println(min);
//	}
//	public static void solution2() throws Exception {
//		int n = Integer.parseInt(rd.readLine());
//		long[] dp = new long[n+10];
//		dp[0] = 0;
//		dp[1] = 1;
//		dp[2] = 2;
//		for(int i=3;i<=n;i++) {
//			dp[i] = (dp[i-1]+dp[i-2])%15746;
//		}
//		System.out.println(dp[n]);
//	}
//	public static void solution1() throws Exception {
//		str1 = rd.readLine().toCharArray();
//		str2 = rd.readLine().toCharArray();
//		int n = str1.length;
//		int m = str2.length;
//		dp = new Integer[n][m];
////		s1(n-1,m-1);
//		for(int i=0;i<n;i++) System.out.println(Arrays.toString(dp[i]));
//		System.out.println(dp[n-1][m-1]);
//	}
//	static Integer[][] dp;
//	static char[] str1;
//	static char[] str2;
//	public static int s1(int a, int b) {
//		if(a<0 || b<0) return 0;
//		if(dp[a][b] == null) {
//			dp[a][b] = 0;
//			if(str1[a] == str2[b]) {
//				dp[a][b] = s1(a-1,b-1)+1;
//			} 
//			else {
//				dp[a][b] = Math.max(s1(a-1,b), s1(a,b-1));
//			}
//		}
//		
//		return dp[a][b];
//	}
}