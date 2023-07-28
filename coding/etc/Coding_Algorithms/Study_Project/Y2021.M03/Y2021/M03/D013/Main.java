package Y2021.M03.D013;
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
		String n = rd.readLine();
		int v = Integer.parseInt(rd.readLine());
		boolean[] tr = new boolean[10];		// 입력 가능한 버튼은 false로 적용
		tok = new StringTokenizer(rd.readLine());
		for(int i=0;i<v;i++) {
			int c = Integer.parseInt(tok.nextToken());
			tr[c] = true;
		}
		StringBuffer pls = new StringBuffer();
		StringBuffer mns = new StringBuffer();
		int index = 0;
		boolean pass =false;
		boolean over = false;
		while(!pass) {	// pls 부분 (최소 큰 값을 적용)
			if(over) {pls.append(String.valueOf(right(tr,0))); index ++;}
			else {
				int cindex = index-1;
				boolean ovp = true;
				while(cindex >= 0 && ovp) {
				}
			}
			
			if(index >= n.length()) pass= true;
		}
	}
	public static int left(boolean[] tr, int n) {
		if(!tr[n]) return n;
		return left(tr,n-1 >= 0 ? n-1 : 9);
	}	// 해당 버튼과 같거나, 낮은 버튼을 찾아냄
	public static int right(boolean[] tr, int n) {
		if(!tr[n]) return n;
		return right(tr,n+1 <= 9 ? n+1 : 0);
	} // 해당 버튼과 같거나 더 큰 버튼을 찾아냄.
}