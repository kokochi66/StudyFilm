package Y2020.M12.D9;
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
		int[] dp = new int[n+10];
		Arrays.fill(dp, Integer.MAX_VALUE);
		Queue<Integer> sw = new LinkedList<Integer>();
		ArrayList<Integer> op = new ArrayList<Integer>();
		int id = 1;
		while(id*id <= n) {
			dp[id*id] = 1;
			sw.offer(id*id);
			op.add(id*id);
			id++;
		}
		// dp 1 ÃÊ±âÈ­
		
		id = 1;
		while(!sw.isEmpty()) {
			int c = sw.poll();
			for(int i=0;i<op.size();i++) {
				if(c+op.get(i)<=n && dp[c]+1< dp[c+op.get(i)]) {
					dp[c+op.get(i)] = dp[c]+1;
					sw.offer(c+op.get(i));
				}
			}
		}
		
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[n]);
	}
//	public static void solution() throws Exception {
//		tok = new StringTokenizer(rd.readLine());
//		int n = Integer.parseInt(tok.nextToken());
//		int m = Integer.parseInt(tok.nextToken());
//		tok = new StringTokenizer(rd.readLine());
//		int[] sw = new int[2];
//		sw[0] = Integer.parseInt(tok.nextToken());
//		sw[1] = Integer.parseInt(tok.nextToken());
//		int rot = Integer.parseInt(tok.nextToken());
//		char[][] mat = new char[n][m];
//		for(int i=0;i<n;i++) {
//			tok = new StringTokenizer(rd.readLine());
//			for(int j=0;j<m;j++) mat[i][j] = tok.nextToken().charAt(0);
//		}
//		count = 1;
//		mat[sw[0]][sw[1]] = '2';
//		
//		while(rot>=0) {
//			rot = oper(mat,sw,rot,0);
////			System.out.println(Arrays.toString(sw));
//		}
//		System.out.println(count);
////		for(int i=0;i<n;i++) System.out.println(Arrays.toString(mat[i]));
//	}
//	static int[] lx = {0, -1, 0, 1}; 
//	static int[] ly = {-1, 0, 1, 0};
//	static int count;
//	public static int oper(char[][] mat, int[] sw, int rot , int cp) {
//		if(cp == 4) {
//			int back = rot-1 < 0 ? 3 : rot-1;
//			char c = mat[sw[0]+lx[back]][sw[1]+ly[back]];
//			if(c == '1') return -1;
//			else if(c == '2') {
//				sw[0] += lx[back];
//				sw[1] += ly[back];
//				return rot;
//			}
//		}
//		
//		if(mat[sw[0]+lx[rot]][sw[1]+ly[rot]] == '0') {
//			sw[0] += lx[rot];
//			sw[1] += ly[rot];
//			mat[sw[0]][sw[1]] = '2';
//			count++;
//			return rot-1 < 0 ? 3 : rot-1;
//		}
//		rot = rot-1 < 0 ? 3 : rot-1;
//		return oper(mat, sw, rot , cp+1);
//	}
}