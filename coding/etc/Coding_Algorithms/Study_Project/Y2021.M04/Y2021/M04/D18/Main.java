package Y2021.M04.D18;
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
		ArrayList<Integer>[] edges = new ArrayList[n+1];
		boolean[] chk = new boolean[n+1];
		for(int i=0;i<=n;i++) edges[i] = new ArrayList<Integer>();
		for(int i=0;i<n-1;i++) {
			tok = new StringTokenizer(rd.readLine()); 
			int a = Integer.parseInt(tok.nextToken());
			int b = Integer.parseInt(tok.nextToken());
			edges[a].add(b);
			edges[b].add(a);
		}
		
		Queue<Integer> cp = new LinkedList<Integer>();
		int[] pa = new int[n+1];
		cp.add(1);
		chk[1] = true;
		while(!cp.isEmpty()) {
			int c = cp.poll();
			for(int i=0;i<edges[c].size();i++) {
				int tc = edges[c].get(i);
				if(!chk[tc]) {
					pa[tc] = c;
					chk[tc] = true;
					cp.add(tc);
				}
			}
		}
		for(int i=2;i<=n;i++) System.out.println(pa[i]);
	} 
}