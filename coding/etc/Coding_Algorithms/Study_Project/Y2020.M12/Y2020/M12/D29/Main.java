package Y2020.M12.D29;
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
		int n = Integer.parseInt(rd.readLine());
		tok = new StringTokenizer(rd.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(tok.nextToken());
		}
		ArrayList<Integer> lds = new ArrayList<Integer>();
		lds.add(arr[0]);
		for(int i=1;i<n;i++) {
			int c = lds.size()-1;
			if(lds.get(c) < arr[i]) {
				fs3(lds,arr[i],0,c);
			} else if(lds.get(c) > arr[i]) {
				lds.add(arr[i]);
			}
//			for(int j=0;j<lds.size();j++) System.out.print(lds.get(j)+" ");
//			System.out.println();
		}
		System.out.println(lds.size());
	}
	public static void fs3(ArrayList<Integer> lds, int a, int start, int end) {
		if(end - start <= 1) {
			if(lds.get(start) < a) lds.set(start, a);
			else if(lds.get(start) == a) return;
			else lds.set(end, a);
			return;
		}
		int mid = (start+end)/2;
		if(lds.get(mid) < a) fs3(lds,a,start,mid);
		else if(lds.get(mid) > a) fs3(lds,a,mid,end);
		
	}
	public static void solution2() throws Exception {
		tok = new StringTokenizer(rd.readLine());
		int n = Integer.parseInt(tok.nextToken());
		int m = Integer.parseInt(tok.nextToken());
		BigInteger bi = new BigInteger("1");
		BigInteger mu1 = new BigInteger("1");
		BigInteger mu2 = new BigInteger("1");
		BigInteger temp;
		for(int i=2;i<=n;i++) {
			temp = new BigInteger(i+"");
			bi = bi.multiply(temp);
		}
		for(int i=2;i<=m;i++) {
			temp = new BigInteger(i+"");
			mu1 = mu1.multiply(temp);
		}
		for(int i=2;i<=n-m;i++) {
			temp = new BigInteger(i+"");
			mu2 = mu2.multiply(temp);
		}
		bi = bi.divide(mu1);
		bi = bi.divide(mu2);
		bi = bi.mod(new BigInteger("10007"));
		System.out.println(bi);
	}
	public static void solution() throws Exception {
		tok = new StringTokenizer(rd.readLine());
		int n = Integer.parseInt(tok.nextToken());
		int m =Integer.parseInt(tok.nextToken());
		int[][] arr = new int[n][m];
		for(int i=0;i<n;i++) {
			tok = new StringTokenizer(rd.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(tok.nextToken());
			}
		}
		
		int[][] dp = new int[n][m];
		dp[0][0] = arr[0][0];
		for(int cen=0;cen<Math.min(m, n);cen++) {
			for(int i=cen;i<n;i++) {
				if(cen>0) {
					dp[i][cen] = Math.max(dp[i-1][cen], Math.max(dp[i-1][cen-1], dp[i][cen-1]))+arr[i][cen];
				} else if(i>0) {
					dp[i][cen] = dp[i-1][cen]+arr[i][cen];
				}
			}
			for(int i=cen;i<m;i++) {
				if(cen>0) {
					dp[cen][i] = Math.max(dp[cen-1][i], Math.max(dp[cen-1][i-1], dp[cen][i-1]))+arr[cen][i];
				} else if(i>0) {
					dp[cen][i] = dp[cen][i-1]+arr[cen][i];
				}
			}
		}
		wr.write(dp[n-1][m-1]+"");
		wr.flush();
	}
}