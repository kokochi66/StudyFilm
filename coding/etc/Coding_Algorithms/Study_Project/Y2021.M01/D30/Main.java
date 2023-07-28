package Y2021.M1.D30;
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
		StringBuilder com = new StringBuilder();
		for(int i=0;i<n;i++) {
			if(i == 0) com = new StringBuilder(rd.readLine());
			else {
				StringBuilder c = new StringBuilder(rd.readLine());
				for(int j=0;j<c.length();j++) {
					if(com.charAt(j) != c.charAt(j)) com.setCharAt(j, '?');
				}
			}
		}
		System.out.println(com);
	}
	/*
	 * public static void solution() throws Exception { int[][] brd = new int[9][9];
	 * boolean[][] used = new boolean[9][9]; ArrayList<Integer[]> swit = new
	 * ArrayList<Integer[]>(); for(int i=0;i<9;i++) { tok = new
	 * StringTokenizer(rd.readLine()); for(int j=0;j<9;j++) { brd[i][j] =
	 * Integer.parseInt(tok.nextToken()); if(brd[i][j] == 0) swit.add(new Integer[]
	 * {i,j}); } } btk(brd,swit,0); wr.flush(); } public static boolean btk(int[][]
	 * brd, ArrayList<Integer[]> swit, int c) throws Exception { if(swit.size() <=
	 * c) { for(int i=0;i<9;i++) { for(int j=0;j<9;j++) { wr.write(brd[i][j]+" "); }
	 * wr.newLine(); } return true; } else { Integer[] curr = swit.get(c); for(int
	 * i=1;i<=9;i++) { if(check(brd,curr[0],curr[1],i)) { brd[curr[0]][curr[1]] = i;
	 * if(btk(brd,swit,c+1)) return true; brd[curr[0]][curr[1]] = 0; } } } return
	 * false; } public static boolean check(int[][] brd, int x, int y, int c) {
	 * for(int i=0;i<9;i++) { if(brd[x][i] == c || brd[i][y] == c) return false; }
	 * int cx = (x/3)*3; int cy = (y/3)*3; for(int i=cx;i<cx+3;i++) { for(int
	 * j=cy;j<cy+3;j++) { if(brd[i][j] == c) return false; } } return true; }
	 */
	/*
	 * public static void solution() throws Exception { int n =
	 * Integer.parseInt(rd.readLine()); PriorityQueue<Integer> que = new
	 * PriorityQueue<Integer>(Collections.reverseOrder()); for(int i=0;i<n;i++) {
	 * int c = Integer.parseInt(rd.readLine()); if(c == 0) { wr.write((que.isEmpty()
	 * ? 0 : que.poll())+""); wr.newLine(); } else que.add(c); } wr.flush(); }
	 */
}