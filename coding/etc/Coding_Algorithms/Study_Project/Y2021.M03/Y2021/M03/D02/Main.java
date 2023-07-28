package Y2021.M03.D02;
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
		int[][] grid = new int[n][n];
		tok = new StringTokenizer(rd.readLine());
		int tA = Integer.parseInt(tok.nextToken())-1;
		int tB = Integer.parseInt(tok.nextToken())-1;
		int m = Integer.parseInt(rd.readLine());
		for(int i=0;i<m;i++) {
			tok = new StringTokenizer(rd.readLine());
			int conA = Integer.parseInt(tok.nextToken())-1;
			int conB = Integer.parseInt(tok.nextToken())-1;
			grid[conA][conB] = grid[conB][conA] = 1;
		}
		Queue<Integer[]> q = new LinkedList<Integer[]>();
		boolean[] used = new boolean[n];
		q.add(new Integer[] {tA,0});
		used[tA] = true;
		while(!q.isEmpty()) {
			Integer[] c = q.poll();
			if(grid[c[0]][tB] == 1) {
				System.out.println(c[1]+1);
				return;
			}
			for(int i=0;i<n;i++) {
				if(grid[c[0]][i] == 1 && !used[i]) {
					used[i] = true;
					q.add(new Integer[] {i,c[1]+1});
				}
			}
		}
		System.out.println(-1);
		//		for(int i=0;i<n;i++) System.out.println(Arrays.toString(grid[i]));
	}
}