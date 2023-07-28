package Y2021.M03.D04;
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
		 int v = Integer.parseInt(rd.readLine());
		 int e = Integer.parseInt(rd.readLine());
		 Dijkstra_pq dik = new Dijkstra_pq(v);
		 for(int i=0;i<e;i++) {
			 tok = new StringTokenizer(rd.readLine());
			 int a = Integer.parseInt(tok.nextToken()) -1;
			 int b = Integer.parseInt(tok.nextToken()) -1;
			 int w = Integer.parseInt(tok.nextToken());
			 dik.putSingleEdge(a, b, w);
		 }
		
		 tok = new StringTokenizer(rd.readLine());
		 int start = Integer.parseInt(tok.nextToken()) -1;
		 int end = Integer.parseInt(tok.nextToken()) -1;
		 dik.rot(start);
//		 System.out.println(Arrays.toString(dik.res));
		 System.out.println(dik.res[end]);
	}
	static class Dijkstra_pq {	// 리스트와 우선순위 큐를 이용해 구현한 다익스트라 알고리즘
		final int INF = 1000000000;
		List<Edge>[] grp;
		int[] res;
		boolean[] visited;
		static class Edge implements Comparable<Edge> { // 간선 클래스를 생성해줌
			int v, weight;
			public Edge(int v, int w) {
				this.v = v;
				this.weight = w;
			}
			@Override
			public int compareTo(Edge o) {
				return Integer.compare(this.weight, o.weight); // 우선순위 큐를 위해 비교값 재정의
			}
		}
		
		public Dijkstra_pq(int v) {
			grp = new ArrayList[v];
			res = new int[v];
			visited = new boolean[v];
			for(int i=0;i<v;i++) grp[i] = new ArrayList<>();
		} 	// 다익스트라 초기 선언 v는 정점의 개수
		
		public void putEdge(int a, int b, int w) {
			grp[a].add(new Edge(b, w));
			grp[b].add(new Edge(a,w));
		} // 양방향 간선 삽입
		public void putSingleEdge(int a, int b, int w) {
			grp[a].add(new Edge(b,w));
		} // 단방향 간선 삽입
		
		public void rot(int start) {
			PriorityQueue<Edge> pq = new PriorityQueue<>(); 	// 우선순위 큐 초기화
			Arrays.fill(visited, false);
			Arrays.fill(res, INF);
			res[start] = 0;
			pq.add(new Edge(start,0));

			while(!pq.isEmpty()) {
				Edge curr = pq.poll();
				if(!visited[curr.v]) {
					visited[curr.v] = true;		// 우선순위 큐에서 꺼낸 정점은 방문처리함
					for(Edge next : grp[curr.v]) { // for문을 통해 현재 정점의 값에서 간선을 하나씩 꺼냄
						if(!visited[next.v] && res[curr.v] + next.weight < res[next.v]) {
							res[next.v] = res[curr.v] + next.weight;
							pq.add(new Edge(next.v, res[next.v]));
						}	// 각 위치값을 교체해줌
					}
				}
				
			}
		} // 알고리즘을 이용하여 최단거리를 찾아냄
	}
}