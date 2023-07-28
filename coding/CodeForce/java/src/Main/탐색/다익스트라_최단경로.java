package src.Main.탐색;

import java.util.*;

public class 다익스트라_최단경로 {
    final static int IM = 100000;

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


//		다익스트라_배열 djk = new 다익스트라_배열(6,graph);
//		djk.rot(5);
//		for(int i=0;i<6;i++) {
//			System.out.println(Arrays.toString(djk.graph[i]));
//		}
        Dikstra_prq djk = new Dikstra_prq(6);
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

    static class 다익스트라_배열 {
        final int INF = 1000000000;
        boolean[] visited;
        int[] res;
        int[][] graph;

        public 다익스트라_배열(int n, int[][] grp) {
            visited = new boolean[n];
            res = new int[n];
            graph = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    this.graph[i][j] = grp[i][j];
                }
            }
        }

        private int 최소인덱스찾기() {
            int min = INF;
            int index = 0;
            for (int i = 0; i < res.length; i++) {
                if (res[i] < min && !visited[i]) {
                    min = res[i];
                    index = i;
                }
            }
            return index;
        }

        public void rot(int start) {
            for (int i = 0; i < res.length; i++) res[i] = graph[start][i];
            visited[start] = true;
            for (int i = 0; i < res.length - 1; i++) {
                int c = 최소인덱스찾기();
                visited[c] = true;
                for (int j = 0; j < res.length; j++) {
                    if (!visited[j]) {
                        res[j] = res[c] + graph[c][j] < res[j] ? res[c] + graph[c][j] : res[j];
                    }
                }
            }
        }

    }

    static class Dikstra_prq {
        final int INF = 1000000000;
        List<Edge>[] grp;
        int[] res;
        boolean[] visited;

        static class Edge implements Comparable<Edge> {
            int v, weight;

            public Edge(int v, int w) {
                this.v = v;
                this.weight = w;
            }

            @Override
            public int compareTo(Edge o) {
                return Integer.compare(this.weight, o.weight);
            }
        }

        public Dikstra_prq(int v) {
            grp = new ArrayList[v];
            res = new int[v];
            visited = new boolean[v];
            for (int i = 0; i < v; i++) grp[i] = new ArrayList<>();
        }

        public void putEdge(int a, int b, int w) {
            grp[a].add(new Edge(b, w));
            grp[b].add(new Edge(a, w));
        }

        public void putSingle(int a, int b, int w) {
            grp[a].add(new Edge(b, w));
        }

        public void rot(int start) {
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            Arrays.fill(visited, false);
            Arrays.fill(res, INF);
            res[start] = 0;
            pq.add(new Edge(start, 0));

            while (!pq.isEmpty()) {
                Edge curr = pq.poll();
                if (!visited[curr.v]) {
                    visited[curr.v] = true;
                    for (Edge next : grp[curr.v]) {
                        if (!visited[next.v] && res[curr.v] + next.weight < res[next.v]) {
                            res[next.v] = res[curr.v] + next.weight;
                            pq.add(new Edge(next.v, res[next.v]));
                        }
                    }
                }

            }
        }
    }

    public static int[][] Dijkstra2(int[][] a, int root) {
        int n = a.length;
        int[][] output = new int[n][n];
        HashSet<Integer> set = new HashSet<>();
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            set.add(i);
            weight[i] = IM;
        }
        weight[root] = 0;
        while (!set.isEmpty()) {
            Iterator<Integer> it = set.iterator();
            int minv = it.next();
            int minw = weight[minv];
            while (it.hasNext()) {
                int v = it.next();
                if (weight[v] < minw) {
                    minw = weight[v];
                    minv = v;
                }
            }
            set.remove(minv);
            for (int i = 0; i < n; i++) {
                if (set.contains(i) && weight[i] > weight[minv] + a[minv][i]) {
                    weight[i] = weight[minv] + a[minv][i];
                }
            }
        }
        System.out.println(Arrays.toString(weight));
        return output;
    }

    public static int[][] Dijkstra1(int[][] a, int root) {
        // 1. 출발노드를 설정한다( 없으면 기본 1로 설정해둔다)
        // 2. 출발노드를 기준으로 각 노드의 최소 비용을 저장한다.
        // 3. 방문하지 않은 노드 중 가장 비용이 적은 노드를 선택한다.
        // 4. 해당 노드를 거치는 엣지중 가장 비용이 적은 엣지를 선택한다.
        int n = a.length;
        int[] weight = new int[n];
        PriorityQueue<edge> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            weight[i] = a[root][i];
            if (weight[i] != 0) pq.offer(new edge(i, weight[i]));
        }
        while (!pq.isEmpty()) {
            edge c = pq.poll();
            if (weight[c.next] < c.weight) continue;
            for (int i = 0; i < n; i++) {
                System.out.println(c.next + " " + i + "   " + a[c.next][i] + " " + weight[i] + " " + weight[c.next]);
                if (a[c.next][i] != 0 && weight[i] > weight[c.next] + a[c.next][i]) {
                    System.out.println("매칭성공");
                    weight[i] = weight[c.next] + a[c.next][i];
                    pq.offer(new edge(i, weight[i]));
                }
            }
        }
        System.out.println(Arrays.toString(weight));
        int[][] output = new int[n][n];
        return output;
    }

    static class edge implements Comparable<edge> {
        int next;
        int weight;

        public edge(int n, int w) {
            this.next = n;
            this.weight = w;
        }

        @Override
        public int compareTo(edge ed) {
            return this.weight - ed.weight;
        }
    }
}
