package Y2021.M05.D03;
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
		tok = new StringTokenizer(rd.readLine());
		int h = Integer.parseInt(tok.nextToken());
		int w = Integer.parseInt(tok.nextToken());
		int[][] off = new int[h][w];
		Queue<Integer[]> camq = new LinkedList<Integer[]>();
		for(int i=0;i<h;i++) {
			tok = new StringTokenizer(rd.readLine());
			for(int j=0;j<w;j++) {
				off[i][j] = Integer.parseInt(tok.nextToken());
				if(off[i][j] > 0 && off[i][j] < 6) camq.add(new Integer[] {i,j});
			}
		}
		
		int camCount = camq.size();
		int[][] cam = new int[camCount][3];
		for(int i=0;i<camCount;i++) {
			Integer[] c = camq.poll();
			cam[i][0] = c[0];
			cam[i][1] = c[1];
			cam[i][2] = 0; 	// 0 위, 1 오른, 2 아래, 3 왼
		}
		// 입력부
		
		min = 100;
		sol2_btk(camCount, 0, cam, off);
		System.out.println(min);
	}
	static int min;
	public static void sol2_btk(int m, int k, int[][] cam, int[][] off) {
		if(m == k) {
			int count = 0;
			for(int i=0;i<off.length;i++) {
				for(int j=0;j<off[0].length;j++) {
					if(off[i][j] == 0) count++;
				}
			}
			min = Math.min(min, count);
		} else { 
			for(int i=0;i<4;i++) {
				sol2_camArr(off, cam[k][0], cam[k][1], off[cam[k][0]][cam[k][1]], i, true);
				sol2_btk(m, k+1, cam, off);
				sol2_camArr(off, cam[k][0], cam[k][1], off[cam[k][0]][cam[k][1]], i, false);
			}
		}
	}
	public static void sol2_camArr(int[][] off, int h, int w, int num, int dir, boolean onf) {
		int[][] dirc = { {-1,0}, {0 , 1}, {1,0}, {0, -1} };
		Queue<Integer[]> q = new LinkedList<>();
		q.add(new  Integer[] {dir, 1});
		if(num == 3 || num == 4 || num == 5) q.add(new  Integer[] {(dir+1)%4, 1});
		if(num == 2 || num == 5) q.add(new  Integer[] {(dir+2)%4, 1});
		if(num == 4 || num == 5) q.add(new  Integer[] {(dir+3)%4, 1});
		while(!q.isEmpty()) {
			Integer[] c = q.poll();
			int ch = h + ( dirc[c[0]][0] * c[1] );
			int cw = w + ( dirc[c[0]][1] * c[1] );
			if(ch < 0 || ch >= off.length || cw < 0 || cw >= off[0].length || off[ch][cw] == 6) continue;
			else if(off[ch][cw] == 0 || off[ch][cw] >= 10) {
				if(onf) off[ch][cw] = off[ch][cw] >= 10 ? off[ch][cw]+1 : 10;
				else off[ch][cw] = off[ch][cw] - 1 < 10 ? 0 : off[ch][cw]-1 ;
				q.add(new Integer[] {c[0], c[1]+1});
			} else {
				q.add(new Integer[] {c[0], c[1]+1});
			}
		}
	}
	public static void solution() throws Exception {
		int res = Integer.parseInt(rd.readLine());
		for(int i=0;i<9;i++) {
			res -= Integer.parseInt(rd.readLine());
		}
		System.out.println(res);
	}
}