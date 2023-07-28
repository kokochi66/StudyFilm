package Algorithms.Graph;
import java.util.*;
public class AL_Dijkstra {
	public static void main(String[] args) {
		final int INF = 1000000000;
		int[][] graph = {
				{0, 2, 5, 1, INF, INF},
				{2, 0, 3, 2, INF, INF},
				{5, 3, 0, 3, 1, 5},
				{1, 2, 3, 0, 1, INF},
				{INF, INF, 1, 1, 0, 2},
				{INF, INF, 5, INF, 2, 0}
		};
		
		
		
//		Dijkstra_Array djk = new Dijkstra_Array(6,graph);
//		djk.rot(5);
//		for(int i=0;i<6;i++) {
//			System.out.println(Arrays.toString(djk.graph[i]));
//		}
		Dijkstra_pq djk = new Dijkstra_pq(6);
		djk.putEdge(0, 1, 2);
		djk.putEdge(0, 2, 5);
		djk.putEdge(0, 3, 1);
		djk.putEdge(1, 2, 3);
		djk.putEdge(1, 3, 2);
		djk.putEdge(2, 3, 3);
		djk.putEdge(2, 4, 1);
		djk.putEdge(2, 5, 5);
		djk.putEdge(3, 4, 1);
		djk.putEdge(4, 5, 2);
		djk.rot(0);
		System.out.println(Arrays.toString(djk.res));
	}

	static class Dijkstra_Array {	// 배열을 이용하여 구현한 다익스트라 알고리즘 (간선이 적을 때 비효율적임)
		final int INF = 1000000000;	// 노드가 연결되지 않은 부분을 치환하기 위한 무한대값
		boolean[] visited;							// 방문여부를 따질 수 있는 불리언 배열
		int[] res;											// 원하는 위치로부터의 최단거리를 출력할 res배열
		int[][] graph;									// 입력받은 그래프를 저장할 2차원 배열
		
		public Dijkstra_Array(int n, int[][] grp) {
			visited = new boolean[n];
			res = new int[n];
			graph = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					this.graph[i][j] = grp[i][j];
				}
			}
		}	// 클래스 초기화
		
		private int getSmallIndex() {
			int min = INF;
			int index = 0;
			for(int i=0;i<res.length;i++) {
				if(res[i] < min && !visited[i]) {	// 최솟값이면서, 아직 방문하지 않은 값을 찾아냄
					min = res[i];
					index = i;
				}
			}
			return index;
		}	// 현재 노드의 최소 가중치의 인덱스값을 출력하는 함수
		
		public void rot(int start) {
			for(int i=0;i<res.length;i++) res[i] = graph[start][i];		// 최단거리 배열을 초기 시작값의 거리로 초기화
			visited[start] = true;
			 for(int i=0;i<res.length-1;i++) {
				 int c = getSmallIndex();		// 현재 가장 짧은 거리가 남은 인덱스를 찾아줌(우선순위 큐 역할)
				 visited[c] = true;
				 for(int j=0; j< res.length;j++) {
					 if(!visited[j]) {
						 res[j] = res[c] + graph[c][j] < res[j] ? res[c] + graph[c][j] : res[j];	// 다른 정점을 방문한 거리가 더 짧으면 최단거리 배열을 수정해줌
					 }
				 }
			 }
		}	// 로테이션을 통해 현재 최단거리 배열에 원하는 값으로부터의 최단거리를 저장함
		
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
