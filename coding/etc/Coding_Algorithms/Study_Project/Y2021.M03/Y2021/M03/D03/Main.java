package Y2021.M03.D03;
import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		solution5();
	}
	public static void solution5() throws Exception {
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			tok = new StringTokenizer(rd.readLine());
			int n = Integer.parseInt(tok.nextToken());
			int Ud = Integer.parseInt(tok.nextToken());
			int Rd = Integer.parseInt(tok.nextToken());
			int Dd = Integer.parseInt(tok.nextToken());
			int Ld = Integer.parseInt(tok.nextToken());
			boolean pass = false;
			for(int i=0;i<16;i++) {
				int u = Ud, r = Rd, d = Dd, l = Ld;
				if(((i>>0)&1) == 1) {d--; l--;}
				if(((i>>1)&1) == 1) {d--; r--;}
				if(((i>>2)&1) == 1) {u--; l--;}
				if(((i>>3)&1) == 1) {u--; r--;}
				
				if(u>=0 && r>=0 && d>=0 && l>=0 && u<=n-2 && r<=n-2 && d<=n-2 && l<=n-2) pass = true;
			}
			if(pass) System.out.println("YES");
			else System.out.println("NO");
		}
	}
	public static void solution4() throws Exception {
		int n = Integer.parseInt(rd.readLine());
		boolean[] used = new boolean[n+1];
		int[] arr = new int[n];
		solution4_btk(0,n,used,arr);
	}
	public static void solution4_btk(int k, int m, boolean[] used, int[] arr) {
		if(k == m) {
			for(int i=0;i<m;i++) System.out.print(arr[i] +" ");
			System.out.println();
		} else {
			for(int i=1;i<=m;i++) {
				if(!used[i]) {
					arr[k] = i;
					used[i] = true;
					solution4_btk(k+1,m,used,arr);
					used[i] = false;
				}
			}
		}
	}
	
	public static void solution3() throws Exception {
		tok = new StringTokenizer(rd.readLine());
		int h = Integer.parseInt(tok.nextToken());
		int m = Integer.parseInt(tok.nextToken());
		int n = Integer.parseInt(rd.readLine());
		m += n;
		h = (h + (m/60))%24;
		m %= 60;
		System.out.println(h+" "+m);
	}
	static boolean res;
	public static void solution2() throws Exception {
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			tok = new StringTokenizer(rd.readLine());
			int n = Integer.parseInt(tok.nextToken());
			int[] prog = new int[4];
			for(int i=0;i<4;i++) prog[i] = Integer.parseInt(tok.nextToken());
			boolean[] grid = new boolean[4];
			res = false;
			solution2_DFS(grid,prog,0,n);
			System.out.println(res ? "YES" : "NO");
		}
	}
	public static void solution2_DFS(boolean[] grid, int[] pr, int dir, int n) {
		if(dir == 3) {
			int lrp = (grid[0] ? 1 : 0) + (grid[3] ? 1 : 0);
			if(lrp <= pr[dir] && pr[dir] <= n-(2-lrp)) {
				res = true;
			}
			return;
		}
		if(pr[dir] >= n-2 && pr[dir] > 1) {
			grid[dir] = true;
			grid[dir+1] = true;
			solution2_DFS(grid,pr,dir+1,n);
			grid[dir] = false;
			grid[dir+1] = false;
		}
		if(pr[dir] >= 1 && pr[dir] <= n-1) {
			grid[dir] = true;
			solution2_DFS(grid,pr,dir+1,n);
			grid[dir] = false;
			grid[dir+1] = true;
			solution2_DFS(grid,pr,dir+1,n);
			grid[dir+1] = false;
		}
		if(pr[dir] <= n-2) {
			solution2_DFS(grid,pr,dir+1,n);
		}
	}
	public static void solution() throws Exception {
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			char[] str = rd.readLine().toCharArray();
			int[] alp = new int[3];
			boolean pass = true;
			alp[str[0] - 'A'] = 1;	// 최초값은 여는괄호로 설정
			if(alp[str[str.length-1]-'A'] == 1) pass = false;	//최초값과 마지막값이 일치하면 false
			else {
				alp[str[str.length-1]-'A'] = 2;							// 마지막값은 닫는괄호로 설정
				Stack<Integer> st = new Stack<Integer>();
				for(int i=0;i<str.length;i++) {
					if(alp[str[i] - 'A'] == 0) {			// 설정되지 않은 중간값일 경우
						if(st.isEmpty()) {					// 배열이 비어있다면 여는괄호로 설정
							alp[str[i] - 'A'] = 1;
							st.add(1);
						} else {									// 배열이 비어있지 않다면 앞뒤상황 확인 후 결정
							int open = 0;
							int close = 0;
							int my = 0;
							for(int j=i+1;j<str.length;j++) {
								if(alp[str[j] - 'A'] == 1) open++;
								else if(alp[str[j] - 'A'] == 2) close++;
								else my++;
							}
							if(st.size() + my + open + 1 == close) {
								alp[str[i] - 'A'] = 1;
								st.add(1);
							} else {
								alp[str[i] - 'A'] = 2;
								st.pop();
							}
						}
					} else if(alp[str[i] - 'A'] == 1) {
						st.add(1);
					} else {
						if(st.isEmpty()) {
							pass = false;
							break;
						} else {
							st.pop();
						}
					}
				}
				if(!st.isEmpty()) pass = false;
			}
			
			if(pass)  System.out.println("YES");
			else System.out.println("NO");
		}
	}
}