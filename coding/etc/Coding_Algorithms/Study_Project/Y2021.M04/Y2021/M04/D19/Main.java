package Y2021.M04.D19;
import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		solution();
	}
	
	static boolean[] chk;
	static ArrayList<Integer[]>[] nd;
	public static void init() {
		Arrays.fill(chk, false);
	}
	
	public static int dfs(int n, int len) {
		if(nd[n].size() <= 1) return 0;
		int max = len;
		ArrayList<Integer> ed = new ArrayList<Integer>();
		chk[n] = true; 
		for(int i=0;i<nd[n].size();i++) {
			Integer[] c = nd[n].get(i);
			if(!chk[c[0]]) ed.add(dfs(c[0], len + c[1]));
		}
		Collections.sort(ed);
		max = Math.max(ed.size() > 0 ? ed.get(0) + len : len, ed.size() > 1 ? ed.get(1) + ed.get(0) : 0);
		System.out.println(n+" "+max);
		return max;
	}
	public static void solution() throws Exception {
		int n = Integer.parseInt(rd.readLine());
		nd = new ArrayList[n+1];
		chk = new boolean[n+1];
		for(int i=0;i<=n;i++) nd[i] = new ArrayList<Integer[]>();
		for(int i=0;i<n-1;i++) {
			tok = new StringTokenizer(rd.readLine());
			int a = Integer.parseInt(tok.nextToken());
			int b = Integer.parseInt(tok.nextToken());
			int c = Integer.parseInt(tok.nextToken());
			nd[a].add(new Integer[] {b,c});
			nd[b].add(new Integer[] {a,c});
		} // ÀÔ·ÂºÎ
		int max = dfs(1,0);
		System.out.println(max);
	}
}