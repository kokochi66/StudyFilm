package Y2021.M02.D1;
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
		int e = Integer.parseInt(tok.nextToken());
		int[] parent = new int[n+1];
		for(int i=0;i<=n;i++) parent[i] = i;
		PriorityQueue<edge> pq = new PriorityQueue<edge>();
		for(int i=0;i<e;i++) {
			tok = new StringTokenizer(rd.readLine());
			int a = Integer.parseInt(tok.nextToken());
			int b = Integer.parseInt(tok.nextToken());
			int w = Integer.parseInt(tok.nextToken());
			pq.add(new edge(a,b,w));
		}
		int res = 0;
		while(!pq.isEmpty()) {
			edge c = pq.poll();
			System.out.println(c.a +" "+ c.b +" "+ finp(parent,c.a,c.b));
			if(!finp(parent,c.a,c.b)) {
				unip(parent,c.a,c.b);
				res += c.weight;
			}
		}
		System.out.println(res);
	}
	static class edge implements Comparable<edge>  {
		int a;
		int b;
		int weight;
		public edge(int as, int bs, int ws) {
			this.a = as;
			this.b = bs;
			this.weight = ws;
		}
		@Override
		public int compareTo(edge e) {
			return e.weight > this.weight ? -1 : 1;
		}
		
	}
	public static int getp(int[] p, int x){
        if(p[x] == x) return x;
        return p[x] = getp(p,p[x]);
    }
    public static void unip(int[] p, int a, int b){
        a = getp(p, a);
        b = getp(p, b);
        if(a<b) p[b] = a;
        else p[a] = b;
    }
    public static boolean finp(int[] p, int a, int b){
        a = getp(p, a);
        b = getp(p, b);
        return a==b;
    }
//	public static void solution() throws Exception {
//		tok = new StringTokenizer(rd.readLine());
//		int n = Integer.parseInt(tok.nextToken());
//		int k = Integer.parseInt(tok.nextToken());
//		int[][] items = new int[n][2];
//		for(int i=0;i<n;i++) {
//			tok = new StringTokenizer(rd.readLine());
//			items[i][0] = Integer.parseInt(tok.nextToken());
//			items[i][1] = Integer.parseInt(tok.nextToken());
//		}
//		
//		int[][] knaps = new int[n][k+1];
//		for(int i=0;i<n;i++) {
//			int cWeight = items[i][0];
//			int cValue = items[i][1];
//			for(int j=0;j<=k;j++) {
//				if(cWeight > j) knaps[i][j] = i>0 ? knaps[i-1][j] : 0;
//				else {
//					knaps[i][j] = Math.max((i>0 ? knaps[i-1][j-cWeight] : 0) + cValue, i>0 ? knaps[i-1][j] : 0);
//				}
//			}
//		}
//		
////		for(int i=0;i<n;i++) {
////			System.out.println(Arrays.toString(knaps[i]));
////		}
//		System.out.println(knaps[n-1][k]);
//	}
}