
import java.util.*;

public class AL_Dijkstra {
    
    final static int IM = 100000;
    public static void main(String[] args){
        int[][] a = {
            {0,2,5,1,IM,IM},
            {2,0,3,2,IM,IM},
            {5,3,0,3,1,5},
            {1,2,3,0,1,IM},
            {IM,IM,1,1,0,2},
            {IM,IM,5,IM,2,0}
        };
        Dijkstra2(a,0);
    }
    public static int[][] Dijkstra2(int[][] a, int root) {
        int n = a.length;
        int[][] output = new int[n][n]; 
        HashSet<Integer> set = new HashSet<>();
        int[] weight = new int[n];
        for(int i=0;i<n;i++) {
            set.add(i);
            weight[i] = IM;
        }
        weight[root] = 0;
        while(!set.isEmpty()){
            Iterator<Integer> it = set.iterator();
            int minv = it.next();
            int minw = weight[minv];
            while(it.hasNext()){
                int v = it.next();
                if(weight[v] < minw) {
                    minw = weight[v];
                    minv = v;
                }
            }
            set.remove(minv);
            for(int i=0;i<n;i++){
                if(set.contains(i) && weight[i] > weight[minv]+a[minv][i]){
                    weight[i] = weight[minv]+a[minv][i];
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
        for(int i=0;i<n;i++) {
            weight[i] = a[root][i];
            if(weight[i]!=0) pq.offer(new edge(i,weight[i]));
        }
        while(!pq.isEmpty()){
            edge c = pq.poll();
            if(weight[c.next] < c.weight) continue;
            for(int i=0;i<n;i++){
                System.out.println(c.next+" "+i+"   "+a[c.next][i]+" "+weight[i]+" "+weight[c.next]);
                if(a[c.next][i]!=0 && weight[i] > weight[c.next] + a[c.next][i]){
                    System.out.println("매칭성공");
                    weight[i] =  weight[c.next] + a[c.next][i];
                    pq.offer(new edge(i, weight[i]));
                }
            }
        }
        System.out.println(Arrays.toString(weight));
        int[][] output = new int[n][n];
        return output;
    }

    static class edge implements Comparable<edge>{
        int next;
        int weight;
        public edge(int n, int w){
            this.next = n;
            this.weight = w;
        }
        @Override
        public int compareTo(edge ed){
            return this.weight - ed.weight;
        }
    }
}
