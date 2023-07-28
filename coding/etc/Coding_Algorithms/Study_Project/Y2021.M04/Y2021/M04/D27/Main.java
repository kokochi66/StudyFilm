package Y2021.M04.D27;
import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		solution();
	}
	static int[][] bus, res;
	public static void solution() throws Exception {
		int n = Integer.parseInt(rd.readLine());
		int m = Integer.parseInt(rd.readLine());
		bus = new int[n][n];
		res = new int[n][n];
		int INF = 1000000000;
		for(int i=0;i<n;i++) Arrays.fill(bus[i], INF);
		for(int i=0;i<m;i++) {
			tok = new StringTokenizer(rd.readLine());
			int a = Integer.parseInt(tok.nextToken());
			int b = Integer.parseInt(tok.nextToken());
			int c = Integer.parseInt(tok.nextToken());
			if(c < bus[a-1][b-1]) bus[a-1][b-1] = c;
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				res[i][j] = bus[i][j];
			}
		}
		
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(i != j && res[i][k] + res[k][j] < res[i][j]) {
						res[i][j] = res[i][k] + res[k][j];
					}
				}
			}
		}
		
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				wr.write((res[i][j] >= INF ? 0 : res[i][j])+" ");
			}
			wr.newLine();
		}
		wr.flush();
	}

}