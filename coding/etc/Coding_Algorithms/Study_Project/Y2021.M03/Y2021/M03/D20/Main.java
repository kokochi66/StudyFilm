package Y2021.M03.D20;
import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		solution2();
	}
	
	public static void solution2() throws Exception {
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			int n = Integer.parseInt(rd.readLine());
			tok = new StringTokenizer(rd.readLine());
			int[] arr = new int[n];
			for(int i=0;i<n;i++) arr[i] = Integer.parseInt(tok.nextToken());
			// ют╥б
			
//			System.out.println(Arrays.toString(arr));
			int sum = 0;
			for(int i=0;i<n-1;i++) {
				sum += sol2_rec(arr[i] , arr[i+1]);
			}
			System.out.println(sum);
		}
	}
	public static int sol2_rec(int a, int b) {
		if(Math.max(a, b) > 2 * Math.min(a, b)) return 1 + sol2_rec(Math.max(a, b), 2 * Math.min(a, b));
		return 0;
	}
	
	
	public static void solution() throws Exception {
		int n = Integer.parseInt(rd.readLine());
		int[][] sal = new int[n][n];
		int m = (n*(n-1))/2;
		int k = n+n-1;
		Integer[] sal_side = new Integer[m];
		
		int[] p = new int[k];
		int[] q = new int[k];
		int[] emp = new int[k];
		
		for(int i=0;i<n;i++) {
			tok = new StringTokenizer(rd.readLine());
			for(int j=0;j<n;j++) {
				sal[i][j] = Integer.parseInt(tok.nextToken());
			}
			emp[i] = sal[i][i];
		}
		
		int count = 0;
		for(int i=0;i<n;i++)
			for(int j=i+1;j<n;j++)
				sal_side[count++] = (i*n)+j;
		Arrays.sort( sal_side, (u,v) -> {
			int u_ = sal[u/n][u%n];
			int v_ = sal[v/n][v%n];
			return u_ - v_;
		});
		
		
		for(int i=0;i<k;i++) {
			p[i] = i;
			q[i] = i;
		}
		int index = n;
		
		for(int i=0;i<sal_side.length;i++) {
			int c = sal_side[i] , h = c/n, w = c%n, s = sal[h][w];
			h = find(q,h);
			w = find(q,w);
			if( h != w) {
				p[h] = p[w] = q[h] = q[w] = index;
				emp[index++] = s;
			}
		}
		System.out.println(Arrays.toString(p));
		System.out.println(Arrays.toString(q));
		System.out.println(Arrays.toString(emp));
		
		wr.write(index+"");
		wr.newLine();
		for(int i=0;i<emp.length;i++) wr.write(emp[i]+" ");
		wr.newLine();
		wr.write(index+"");
		wr.newLine();
		for(int i=0;i<p.length-1;i++) {
			wr.write((i+1)+" "+(p[i]+1));
			wr.newLine();
		}
		wr.flush();
		
	}
	
	public static int find(int[] q, int n ) {
		if(q[n] == n) return n;
		return q[n] = find(q,q[n]);
	}
}