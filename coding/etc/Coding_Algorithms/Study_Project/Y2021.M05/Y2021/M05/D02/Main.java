package Y2021.M05.D02;
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
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			tok = new StringTokenizer(rd.readLine());
			int v = Integer.parseInt(tok.nextToken());
			int e = Integer.parseInt(tok.nextToken());
			List<Integer>[] grp = new ArrayList[v+1];
			for(int i=0;i<=v;i++) grp[i] = new ArrayList<>();
			for(int i=0;i<e;i++) {
				tok = new StringTokenizer(rd.readLine());
				int a = Integer.parseInt(tok.nextToken());
				int b = Integer.parseInt(tok.nextToken());
				grp[a].add(b);
				grp[b].add(a);
			}
			// 입력부
			
			Queue<Integer> q = new LinkedList<>();
			int[] color = new int[v+1]; // r은 1 b는 2
			boolean pass = false;
			for(int j=1;j<=v;j++) {
				if(color[j] != 0) continue;
				q.add(j);
				color[j] = 1;
				while(!q.isEmpty() && !pass) {
					int c = q.poll();
					for(int i=0;i<grp[c].size();i++) {
						if(color[grp[c].get(i)] == color[c]) {
							pass = true;
							break;
						} else {
							if(color[grp[c].get(i)] == 0) q.add(grp[c].get(i));
							color[grp[c].get(i)] = color[c] == 1 ? 2 : 1;
						}
					}
				}
				
			}
			wr.write(pass ? "NO" : "YES");
			wr.newLine();
		}
		wr.flush();
	}
}