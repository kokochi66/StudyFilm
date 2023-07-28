package Algorithms.Graph;
import java.util.*;
import java.io.*;
public class AL_Prim {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(rd.readLine());
		int m = Integer.parseInt(rd.readLine());
		int[][] arr = new int[n][n];
		for(int i=0;i<n;i++) Arrays.fill(arr[i], INF);
		for(int i=0;i<m;i++) {
			tok = new StringTokenizer(rd.readLine());
			int a = Integer.parseInt(tok.nextToken());
			int b = Integer.parseInt(tok.nextToken());
			int c = Integer.parseInt(tok.nextToken());
			arr[a-1][b-1] = c;
			arr[b-1][a-1] = c;
		}
		int res = prim(arr,0);
		System.out.println(res);
	}
	
	static int INF = 1000000000;
	public static int prim(int[][] arr, int root) throws Exception {
		PriorityQueue<Node_t> pq = new PriorityQueue<Node_t>();
		int n = arr.length;
		int sum = 0;
		boolean[] chk = new boolean[n];
		chk[root] = true;
		for(int i=0;i<n;i++) {
			if(arr[root][i] < INF) pq.add(new Node_t(root, i, arr[root][i]));
		}
		while(!pq.isEmpty()) {
			Node_t tc = pq.poll();
			if(chk[tc.end]) continue;
			sum += tc.weight;
			chk[tc.end] = true;
			for(int i=0;i<n;i++) {
				if(arr[tc.end][i] < INF && !chk[i]) pq.add(new Node_t(tc.end, i, arr[tc.end][i]));
			}
		}
		return sum;
	}
	static class Node_t implements Comparable<Node_t> {
		int start, end, weight;
		public Node_t(int s, int e, int w) {
			this.start = s;
			this.end = e;
			this.weight = w;
		}
		@Override
		public int compareTo(Node_t o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
		
	}
}