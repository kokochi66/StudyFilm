package Y2020.M12.D10;
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
		int[][] arr = new int[n][m];
		for(int i=0;i<n;i++) {
			tok = new StringTokenizer(rd.readLine());
			for(int j=0;j<m;j++) arr[i][j] = Integer.parseInt(tok.nextToken());
		}
//		for(int i=0;i<n;i++) System.out.println(Arrays.toString(arr[i]));
		max = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				check(arr,i,j,n,m);
			}
		}
		System.out.println(max);
	}
	static int max;
	public static void check(int[][] arr, int x, int y, int n, int m) {
		if(x+1<n && y+1 <m) max = Math.max(max, arr[x][y]+arr[x+1][y]+arr[x][y+1]+arr[x+1][y+1]);
		if(y+3<m) max = Math.max(max, arr[x][y]+arr[x][y+1]+arr[x][y+2]+arr[x][y+3]);
		if(x+3<n) max = Math.max(max, arr[x][y]+arr[x+1][y]+arr[x+2][y]+arr[x+3][y]);
		if(x+1<n && y+2<m) {
			max = Math.max(max, arr[x][y]+arr[x][y+1]+arr[x+1][y+1]+arr[x+1][y+2]);
			max = Math.max(max, arr[x+1][y]+arr[x+1][y+1]+arr[x][y+1]+arr[x][y+2]);
			max = Math.max(max, arr[x][y]+arr[x][y+1]+arr[x][y+2]+arr[x+1][y+1]);
			max = Math.max(max, arr[x+1][y]+arr[x+1][y+1]+arr[x+1][y+2]+arr[x][y+1]);
			max = Math.max(max, arr[x][y]+arr[x+1][y]+arr[x][y+1]+arr[x][y+2]);
			max = Math.max(max, arr[x][y]+arr[x][y+1]+arr[x][y+2]+arr[x+1][y+2]);
			max = Math.max(max, arr[x+1][y]+arr[x+1][y+1]+arr[x+1][y+2]+arr[x][y+2]);
			max = Math.max(max, arr[x][y]+arr[x+1][y]+arr[x+1][y+1]+arr[x+1][y+2]);
		}
		if(x+2<n && y+1<m) {
			max = Math.max(max, arr[x][y+1]+arr[x+1][y+1]+arr[x+2][y+1]+arr[x+2][y]);
			max = Math.max(max, arr[x][y]+arr[x+1][y]+arr[x+2][y]+arr[x+2][y+1]);
			max = Math.max(max, arr[x][y]+arr[x][y+1]+arr[x+1][y]+arr[x+2][y]);
			max = Math.max(max, arr[x][y]+arr[x][y+1]+arr[x+1][y+1]+arr[x+2][y+1]);
			max = Math.max(max, arr[x][y+1]+arr[x+1][y+1]+arr[x+1][y]+arr[x+2][y]);
			max = Math.max(max, arr[x][y]+arr[x+1][y]+arr[x+1][y+1]+arr[x+2][y+1]);
			max = Math.max(max, arr[x][y+1]+arr[x+1][y+1]+arr[x+2][y+1]+arr[x+1][y]);
			max = Math.max(max, arr[x][y]+arr[x+1][y]+arr[x+2][y]+arr[x+1][y+1]);
		}
	}
//	public static void solution() throws Exception {
//		tok = new StringTokenizer(rd.readLine());
//		int n = Integer.parseInt(tok.nextToken());
//		int m = Integer.parseInt(tok.nextToken());
//		char[] arr = new char[m];
//		tok = new StringTokenizer(rd.readLine());
//		for(int i=0;i<m;i++) arr[i] = tok.nextToken().charAt(0);
//		Arrays.sort(arr);
////		System.out.println(Arrays.toString(arr));
//		char[] oper = new char[n];
//		btk(0,n,m,oper,arr,0);
//		wr.flush();
//	}
//	public static void btk(int k,int n, int m, char[] oper, char[] arr, int ci) throws Exception {
//		if(k == n) {
//			int count = 0;
//			for(int i=0;i<n;i++) {
//				if(oper[i] == 'a' || oper[i] == 'e' || oper[i] == 'i' || oper[i] == 'o' || oper[i] == 'u') {
//					count++;
//				}
//			}
//			if(count>0 && n-count>1) {
//				wr.write(new String(oper));
//				wr.newLine();
//			}
//		}
//		else {
//			for(int i=ci;i<m-n+k+1;i++) {
//				oper[k] = arr[i];
//				btk(k+1,n,m,oper,arr,i+1);
//			}
//		}
//	}
}