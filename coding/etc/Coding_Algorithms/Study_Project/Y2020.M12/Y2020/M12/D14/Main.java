package Y2020.M12.D14;
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
		long s = 0;
		for(int TT=0;TT<n;TT++) {
			arr[TT] = Integer.parseInt(rd.readLine());
			s += (long)arr[TT];
		}
		s = (s/m);
		int[][] dp = new int[2][n];
		int item = 0;
		for(int i=0;i<n;i++) item += arr[i]/s;
		for(int i=0;i<n;i++) {
			dp[0][i] = (int)(arr[i]/s);
			int mod = (int)(arr[i]%s);
			int c = (s-mod)%(dp[0][i]+1) == 0 ? (int)((s-mod)/(dp[0][i]+1))
					: (int)((s-mod)/(dp[0][i]+1)+1);
			dp[1][i] = (int)(s-c);
		}
		while(item < m) {
			if(m-item > n) {
				s = Arrays.stream(dp[1]).min().getAsInt();
				for(int i=0;i<n;i++) item += arr[i]/s;
				for(int i=0;i<n;i++) {
					dp[0][i] = (int)(arr[i]/s);
					int mod = (int)(arr[i]%s);
					int c = (int)Math.ceil((double)(s - mod)/(double)(dp[0][i]+1));
					dp[1][i] = (int)(s-c);
				}
			} else {
				Arrays.sort(dp[1]);
				wr.write(dp[1][n-(m-item)]+"");
				wr.flush();
				return;
			}
			
		}
		wr.write(s+"");
		wr.flush();
	}
//	public static void solution() throws Exception {
//		int n = Integer.parseInt(rd.readLine());
//		int index = 2;
//		while(n>1) {
//			while(n%index==0) {
//				n /= index;
//				wr.write(index+"");
//				wr.newLine();
//			}
//			index++;
//		}
//		wr.flush();
//	}
//	public static void solution() throws Exception {
//		int n = Integer.parseInt(rd.readLine());
//		for(int i=1;i<=n;i++) {
//			for(int j=1;j<=n-i;j++) {
//				wr.write(" ");
//			}
//			for(int j=1;j<=i;j++) {
//				wr.write("*");
//			}
//			wr.newLine();
//		}
//		for(int i=n-1;i>=1;i--) {
//			for(int j=1;j<=n-i;j++) {
//				wr.write(" ");
//			}
//			for(int j=1;j<=i;j++) {
//				wr.write("*");
//			}
//			wr.newLine();
//		}
//		
//		wr.flush();
//	}
}