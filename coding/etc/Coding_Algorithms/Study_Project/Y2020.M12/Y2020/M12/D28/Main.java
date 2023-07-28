package Y2020.M12.D28;
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
		tok = new StringTokenizer(rd.readLine());
		int n = Integer.parseInt(tok.nextToken());
		int m = Integer.parseInt(tok.nextToken());
		int[] sw = new int[2];
		sw[0] = Integer.parseInt(tok.nextToken());
		sw[1]  = Integer.parseInt(tok.nextToken());
		int k = Integer.parseInt(tok.nextToken());
		int[][] board = new int[n][m];
		int[] dice = new int[6];
		for(int i=0;i<n;i++) {
			tok = new StringTokenizer(rd.readLine());
			for(int j=0;j<m;j++) {
				board[i][j] = Integer.parseInt(tok.nextToken());
			}
		}
		tok = new StringTokenizer(rd.readLine());
		for(int i=0;i<k;i++) {
			int c = Integer.parseInt(tok.nextToken());
			if(fs(dice,c,sw,n,m)) {
				if(board[sw[0]][sw[1]] == 0) {
					board[sw[0]][sw[1]] = dice[5];
				} else {
					dice[5] = board[sw[0]][sw[1]];
					board[sw[0]][sw[1]] = 0;
				}
				wr.write(dice[0]+"");
				wr.newLine();
			}
		}
		wr.flush();
	}
	public static boolean fs(int[] dice, int d, int[] sw, int n, int m) {
		int[] temp = new int[6];
		for(int i=0;i<6;i++) temp[i] = dice[i];
		int[] dc = new int[6];
		if(d==1) {
			dc = new int[]{3,1,0,5,4,2};
			if(sw[1]+1>=m) return false;
			else sw[1] +=1;
		} else if(d==2) {
			dc =  new int[] {2,1,5,0,4,3};
			if(sw[1]-1<0) return false;
			else sw[1] -=1;
		} else if(d==3) {
			dc =  new int[] {4,0,2,3,5,1};
			if(sw[0]-1<0) return false;
			else sw[0] -=1;
		} else if(d==4) {
			dc =  new int[] {1,5,2,3,0,4};
			if(sw[0]+1>=n) return false;
			else sw[0] +=1;
		}
		for(int i=0;i<6;i++) {
			dice[i] = temp[dc[i]];
		}
		return true;
	}
//	public static void solution() throws Exception {
//		int n = Integer.parseInt(rd.readLine());
//		tok = new StringTokenizer(rd.readLine());
//		int[] arr = new int[5];
//		for(int i=0;i<5;i++) {
//			arr[i] = Integer.parseInt(tok.nextToken());
//		}
//		
//		int count = 0;
//		for(int i=0;i<5;i++) {
//			if( n == arr[i]%10) count++;
//		}
//		System.out.println(count);
//	}
//	public static void solution() throws Exception {
//		char[][] board = new char[8][8];
//		for(int i=0;i<8;i++) {
//			board[i] = rd.readLine().toCharArray();
//		}
//		int count = 0;
//		for(int i=0;i<8;i++) {
//			for(int j=0;j<8;j++) {
//				if(i%2 == j%2 && board[i][j] == 'F') count++;
//			}
//		}
//		System.out.println(count);
//	}
}