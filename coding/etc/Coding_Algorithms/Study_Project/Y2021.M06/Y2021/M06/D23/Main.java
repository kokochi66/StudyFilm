package Y2021.M06.D23;
import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		 solution(); 
	}
	static boolean clear;
	static int count;
	static int n,m;
	public static void solution() throws Exception {
		tok = new StringTokenizer(rd.readLine());
		n = Integer.parseInt(tok.nextToken());
		m = Integer.parseInt(tok.nextToken());
		
		char[][] Fullmap = new char[n][m];
		Queue<Integer[]> water = new LinkedList<>();
		Queue<Integer[]> swit = new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			String str = rd.readLine();
			for(int j=0;j<m;j++) {
				Fullmap[i][j] = str.charAt(j);
				
				if(Fullmap[i][j] == '*') water.add(new Integer[] {i,j});
				else if(Fullmap[i][j] == 'S') {
					swit.add(new Integer[] {i,j});
					Fullmap[i][j] = '.';
				}
			}
		}
		// insert
		
		clear = false;
		count = 0;
		while(swit.size() > 0 && !clear) {
			count++;
			water = waterMove(water, Fullmap);
			swit = movingSwit(swit, Fullmap);
			
//			for(int i=0;i<n;i++) System.out.println(Arrays.toString(Fullmap[i]));
//			for(int i=0;i<swit.size();i++) {
//				Integer[] c = swit.peek();
//				swit.add(swit.poll());
//				System.out.println(Arrays.toString(c));
//			}
//			System.out.println("===================== " + swit.size());
		}
		System.out.println(clear ? count : "KAKTUS");
		
	}
	
	public static boolean canMove(int i, int j, char[][] map) {
		if(map[i][j] == 'X' || map[i][j] == '*') return false;
		return true;
	}	// 현재 위치가 이동이 가능한 위치인지를 체크한다.
	public static Queue<Integer[]> movingSwit(Queue<Integer[]> swit, char[][] map) {
		Queue<Integer[]> res = new LinkedList<>();
		HashSet<String> set = new HashSet<String>();
		while(!swit.isEmpty()) {
			Integer[] c = swit.poll();
			moveSetting(res,set,map,c[0]-1,c[1]);
			moveSetting(res,set,map,c[0],c[1]-1);
			moveSetting(res,set,map,c[0]+1,c[1]);
			moveSetting(res,set,map,c[0],c[1]+1);
		}
		return res;
	}

	public static void moveSetting(Queue<Integer[]> res, HashSet<String> set, char[][] map, int i, int j) {
		if(!(i>=0 && i<n && j>=0 && j<m && canMove(i,j,map) && !set.contains(i+"-"+j))) return;
		if(map[i][j] == 'D') clear = true;
		res.add(new Integer[] {i,j});
		set.add(i+"-"+j);
	}
	
	public static Queue<Integer[]> waterMove(Queue<Integer[]> water, char[][] map) {
		Queue<Integer[]> res = new LinkedList<>();
		while(!water.isEmpty()) {
			Integer[] c = water.poll();
			if(c[0]-1 >= 0 && map[c[0]-1][c[1]] == '.') waterSetting(res,map,c[0]-1,c[1]);
			if(c[1]-1 >= 0 && map[c[0]][c[1]-1] == '.') waterSetting(res,map,c[0],c[1]-1);
			if(c[0]+1 < n && map[c[0]+1][c[1]] == '.') waterSetting(res,map,c[0]+1,c[1]);
			if(c[1]+1 < m && map[c[0]][c[1]+1] == '.') waterSetting(res,map,c[0],c[1]+1);
		}
		return res;
	}	// 물을 이동시켜주고, 다음 이동할 물을 반환한다.
	
	public static void waterSetting(Queue<Integer[]> res, char[][] map, int i, int j) {
		map[i][j] = '*';
		res.add(new Integer[] {i, j});
	}	// 물을 이동시켜주고, 결과 큐에 값을 넣어준다.
}