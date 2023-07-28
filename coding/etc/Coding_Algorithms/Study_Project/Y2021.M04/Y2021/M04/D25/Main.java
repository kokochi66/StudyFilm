package Y2021.M04.D25;
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
		int[][] pan = new int[n][n];
		int kh=0, kw=0;
		for(int i=0;i<n;i++) {
			tok = new StringTokenizer(rd.readLine());
			for(int  j=0;j<n;j++) {
				pan[i][j] = Integer.parseInt(tok.nextToken());
				if(pan[i][j] == 9) {
					kh = i;
					kw = j;
				}
			}
		} // 입력부
		int stack = 0;
		int shk = 2;
		int res = 0;
		sol_BFS(kh,kw,shk,pan);
		if(th != -1 && tw != -1)  {
			res += tmin;
			pan[th][tw] = 9;
			pan[kh][kw] = 0;
			kh = th;
			kw = tw;
			stack++;
		}
		while(th != -1 && tw != -1) {
			sol_BFS(kh,kw,shk,pan);
			if(th != -1 && tw != -1) {
				res += tmin;
				pan[th][tw] = 9;
				pan[kh][kw] = 0;
				kh = th;
				kw = tw;
				stack++;
				pan[kh][kw] = 0;
			}
			if(stack >= shk) {
				stack = 0;
				shk++;
			}
		}
		System.out.println(res);
		
	}
	static int th, tw, tmin;
	public static void sol_BFS(int ch, int cw, int shk, int[][] pan) {
		Queue<Integer[]> q = new LinkedList<>();
		q.add(new Integer[] {ch,cw,0});
		int n = pan.length;
		boolean[][] chk = new boolean[n][n];
		th =-1;
		tw =-1; 
		tmin = 1000000000;
		
		while(!q.isEmpty()) {
			Integer[] c = q.poll();
			if(pan[c[0]][c[1]] < shk && pan[c[0]][c[1]] >0) {
				if(c[2] < tmin) {
					th = c[0];
					tw = c[1];
					tmin = c[2];
					continue;
				} else if(c[2] == tmin) {
					if(c[0] < th) {
						th = c[0];
						tw = c[1];
						tmin = c[2];
						continue;
					} else if (c[0] == th && c[1] < tw) {
						th = c[0];
						tw = c[1];
						tmin = c[2];
						continue;
					}
				}
			}
			
			if(c[0] + 1 < n && pan[c[0]+1][c[1]] <=shk && !chk[c[0]+1][c[1]]) {
				chk[c[0]+1][c[1]] = true;
				q.add(new Integer[] {c[0]+1,c[1],c[2]+1});
			}
			if(c[1] + 1 < n && pan[c[0]][c[1]+1] <=shk && !chk[c[0]][c[1]+1]) {
				chk[c[0]][c[1]+1] = true;
				q.add(new Integer[] {c[0],c[1]+1,c[2]+1});
			}
			if(c[0] - 1 >= 0 && pan[c[0]-1][c[1]] <=shk && !chk[c[0]-1][c[1]]) {
				chk[c[0]-1][c[1]] = true;
				q.add(new Integer[] {c[0]-1,c[1],c[2]+1});
			}
			if(c[1] - 1 >= 0 && pan[c[0]][c[1]-1] <=shk && !chk[c[0]][c[1]-1]) {
				chk[c[0]][c[1]-1] = true;
				q.add(new Integer[] {c[0],c[1]-1,c[2]+1});
			}
		}
		
	} // 최단거리 찾기
}