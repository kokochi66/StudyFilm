package Y2020.M12.D4;
import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		solution();
//		System.out.println(area(8, new int[]{2,0}, new int[]{6,7}));
	}
	public static void solution() throws Exception {
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			int n = Integer.parseInt(rd.readLine());
			char[][] carr = new char[n][n];
			for(int i=0;i<n;i++) {
				carr[i] = rd.readLine().toCharArray();
			}
//			for(int i=0;i<n;i++) System.out.println(Arrays.toString(carr[i]));
			int[] dp = new int [10];
			int[][] swit = new int[10][4];
			final int inf = 50000;
			for(int i=0;i<10;i++) {
				swit[i][0] = inf;
				swit[i][2] = inf;
			}
			// 0 = left
			// 1 = right
			// 2 = top
			// 3 = bottom
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++) {
					int c = carr[i][j] - '0';
					check(swit[c],i,j);
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					int c = carr[i][j] - '0';
					dp[c] = Math.max(dp[c], Math.max(i-swit[c][2], swit[c][3]-i)*Math.max(n-j-1, j));
					dp[c] = Math.max(dp[c], Math.max(j-swit[c][0], swit[c][1]-j)*Math.max(n-i-1, i));
				}
			}
//			for(int i=0;i<10;i++) System.out.println(Arrays.toString(swit[i]));
//			System.out.println(Arrays.toString(dp));
			for(int i : dp) System.out.print(i+" ");
			System.out.println();
		}
	}
	public static void check(int[] swit, int x, int y) {
		swit[0] = Math.min(swit[0],  y);
		swit[1] = Math.max(swit[1],  y);
		swit[2] = Math.min(swit[2],  x);
		swit[3] = Math.max(swit[3],  x);
	}
//	public static void solution() throws Exception {
//		int TestCase = Integer.parseInt(rd.readLine());
//		for(int TT=0;TT<TestCase;TT++) {
//			int n = Integer.parseInt(rd.readLine());
//			tok = new StringTokenizer(rd.readLine());
//			int[] arr = new int[n];
//			long sum = 0;
//			for(int i=0;i<n;i++) {
//				arr[i] = Integer.parseInt(tok.nextToken());
//				if(i>0) sum += Math.abs(arr[i]-arr[i-1]);
//			}
//			long[] dp = new long[n];
//			dp[0] = sum - Math.abs(arr[0]-arr[1]);
//			dp[n-1] = sum - Math.abs(arr[n-2]-arr[n-1]);
//			for(int i=1;i<n-1;i++) {
//				dp[i] = sum - Math.abs(arr[i-1]-arr[i]) - Math.abs(arr[i]-arr[i+1])
//						+ Math.abs(arr[i-1]-arr[i+1]);
//			}
////			System.out.println(Arrays.toString(dp));
//			System.out.println(Arrays.stream(dp).min().getAsLong());
////			System.out.println(Arrays.toString(arr));
//			
//			
//			
//		}
//	}
//	public static void solution() throws Exception {
//		int TestCase = Integer.parseInt(rd.readLine());
//		for(int TT=0;TT<TestCase;TT++) {
//			tok = new StringTokenizer(rd.readLine());
//			int n = Integer.parseInt(tok.nextToken());
//			int m = Integer.parseInt(tok.nextToken());
//			int[] arrn = new int[n];
//			int[] arrm = new int[m];
//			tok = new StringTokenizer(rd.readLine());
//			for(int i=0;i<n;i++) {
//				arrn[i] = Integer.parseInt(tok.nextToken());
//			}
//			int count = 0;
//			tok = new StringTokenizer(rd.readLine());
//			for(int i=0;i<m;i++) {
//				arrm[i] = Integer.parseInt(tok.nextToken());
//			}
//			
//			for(int i=0;i<n;i++) {
//				for(int j=0;j<m;j++) {
//					if(arrn[i] == arrm[j]) count++;
//				}
//			}
//			System.out.println(count);
//		}
//	}
}