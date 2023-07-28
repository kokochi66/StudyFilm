package Y2020.M12.D1;

import java.util.*;
import java.io.*;

public class problem_solving_Dynamic {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;

	public static void main(String[] args) throws Exception {
		week13_1();

	}
	
	public static void week13_1() throws Exception {
		final int IM = 10000000;
		tok = new StringTokenizer(rd.readLine());
		int n = Integer.parseInt(tok.nextToken());
		int m = Integer.parseInt(tok.nextToken());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(rd.readLine());
		}
		int[][] dynC = new int[110][50];
		int[][] dynP = new int[110][50];
		int cost = 0, laststop = 0;
		for(int i=0;i<110;i++) {
			dynC[i][0] = week13_1_cost(0,IM , arr);
			dynP[i][0] = -1;
		}
//		for(int i=0;i<20;i++) {
//			wr.write(Arrays.toString(dynC[i]));
//			wr.newLine();
//		}
//		for(int i=0;i<20;i++) {
//			wr.write(Arrays.toString(dynP[i]));
//			wr.newLine();
//		}
		
		for(int j=1; j<=3;j++)
			for(int i=0;i<20;i++) {
				dynC[i][j] = IM;
				for(int k=0;k<=i;k++) {
					cost = dynC[k][j-1] - week13_1_cost(k,IM,arr) +
							week13_1_cost(k,i,arr) + week13_1_cost(i,IM,arr);
					wr.write(dynC[k][j-1]+" - "+week13_1_cost(k,IM,arr)+" + "+
							week13_1_cost(k,i,arr)+" + "+week13_1_cost(i,IM,arr)
							+" = "+cost+"      "+i+" "+k);
					wr.newLine();
					if(cost < dynC[i][j]) {
						dynC[i][j] = cost;
						dynP[i][j] = k;
					}
				}
			}
		for(int i=1;i<110;i++) {
			if(dynC[i][m] < dynC[laststop][m]) laststop = i;
		}
		System.out.println(laststop);
//		for(int i=0;i<20;i++) {
//			wr.write(Arrays.toString(dynC[i]));
//			wr.newLine();
//		}
		for(int i=0;i<20;i++) {
			wr.write(Arrays.toString(dynP[i]));
			wr.newLine();
		}
		wr.flush();
	}
	public static int week13_1_cost(int p, int c, int[] arr) {
		int nsteps = 0;
		for(int i=0;i<arr.length;i++) {
			if((arr[i]>p)&&(arr[i]<=c)) 
				nsteps += Math.min(arr[i]-p, c-arr[i]);
		} 
		return nsteps;
	}

}
