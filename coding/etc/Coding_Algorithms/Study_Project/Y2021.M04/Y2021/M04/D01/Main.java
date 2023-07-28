package Y2021.M04.D01;
import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		solution2();
	}
	public static void solution5() throws Exception {
		tok = new StringTokenizer(rd.readLine());
		int h = Integer.parseInt(tok.nextToken());
		int w = Integer.parseInt(tok.nextToken());
		char[][] arr = new char[h][w];
		int[][] dp = new int[h][w];
		for(int i=0;i<h;i++) arr[i] = rd.readLine().toCharArray();
		
		for(int i=h-1;i>=0;i--) {
			for(int j=w-1;j>=0;j--) {
				int cc = arr[i][j] == '*' ? 1 : 0;
				int cch = i+1 < h ? dp[i+1][j] : 0;
				int ccw = j+1 < w ? dp[i][j+1] : 0;
				dp[i][j] = cc + Math.max(cch , ccw);
			}
		}
		for(int i=0;i<h;i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		
		System.out.println(dp[0][0]);
	}
	
	public static void solution3() throws Exception {
		String str = rd.readLine();
		
		boolean pass = true;
		for(int i=2;i<str.length();i++) {
			char c = str.charAt(i);
			int comp = (str.charAt(i-1) - 'A') + (str.charAt(i-2) - 'A');
			comp = comp >= 26 ? comp-26 : comp;
			if( c - 'A' != comp) {
				pass = false;
				break;
			}
		}
		System.out.println( pass ? "YES" : "NO");
	}
	
	public static void solution2() throws Exception {
		int n = Integer.parseInt(rd.readLine());
		System.out.println((int)Math.ceil(Math.sqrt(n)));
	}
	
	public static void solution() throws Exception {
		String str = rd.readLine(); 
		while(str  !=  null && !str.equals("")) {
			System.out.println("NO");
			
			str = rd.readLine();
		}
	}
}