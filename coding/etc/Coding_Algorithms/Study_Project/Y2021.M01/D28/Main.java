package Y2021.M1.D28;
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
		int n = Integer.parseInt(tok.nextToken()),
				m = Integer.parseInt(tok.nextToken());
		LinkedList<Integer> que = new LinkedList<Integer>();
		for(int i=1;i<=n;i++) que.add(i);
		
		int res = 0;
		tok = new StringTokenizer(rd.readLine());
		for(int i=0;i<m;i++) {
			int c = Integer.parseInt(tok.nextToken());
			int swit = finds(que, c),
					front = swit,
					back =  (que.size() - swit);
			if(swit == 0) que.remove(0);
			else if(front < back) {
				res += (front);
				for(int j=0;j<front;j++) {
					que.add(que.remove(0));
				}
				que.remove(0);
			} else {
				res += back;
				for(int j=0;j<back;j++) {
					que.add(0,que.remove(que.size()-1));
				}
				que.remove(0);
			}
		}
		System.out.println(res);
	}
	public static int finds(LinkedList<Integer> que, int a) {
		for(int i=0;i<que.size();i++) {
			if(que.get(i) == a) return i;
		}
		return -1;
	}
	/*
	 * public static void solution() throws Exception { tok = new
	 * StringTokenizer(rd.readLine()); int n = Integer.parseInt(tok.nextToken());
	 * int m = Integer.parseInt(tok.nextToken()); int[] parent = new int[n+1];
	 * for(int i=0;i<n+1;i++) parent[i] = i; for(int i=0;i<m;i++) { tok = new
	 * StringTokenizer(rd.readLine()); int c = Integer.parseInt(tok.nextToken()), a
	 * = Integer.parseInt(tok.nextToken()), b = Integer.parseInt(tok.nextToken());
	 * if(c == 0) { unip(parent,a,b); } else if(c == 1) { if(finp(parent,a,b))
	 * wr.write("YES"); else wr.write("NO"); wr.newLine(); } } wr.flush(); } public
	 * static int getp(int[] p, int x){ if(p[x] == x) return x; return p[x] =
	 * getp(p,p[x]); } public static void unip(int[] p, int a, int b){ a = getp(p,
	 * a); b = getp(p, b); if(a<b) p[b] = a; else p[a] = b; } public static boolean
	 * finp(int[] p, int a, int b){ a = getp(p, a); b = getp(p, b); return a==b; }
	 */
	/*
	 * public static void solution() throws Exception { int n =
	 * Integer.parseInt(rd.readLine()); tok = new StringTokenizer(rd.readLine());
	 * int[] arr = new int[40000001]; for(int i=0;i<n;i++) {
	 * arr[Integer.parseInt(tok.nextToken())+20000000]++; } int m =
	 * Integer.parseInt(rd.readLine()); tok = new StringTokenizer(rd.readLine());
	 * for(int i=0;i<m;i++) {
	 * wr.write(arr[Integer.parseInt(tok.nextToken())+20000000]+" "); } wr.flush();
	 * }
	 */
}