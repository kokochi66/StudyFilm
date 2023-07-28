

import java.util.*;

public class AL_TopoLogy_Sort {
    public static void main(String[] args){
        Graph grp = new Graph(7);
        int[] drg = {0,1,1,1,1,2,1};
        grp.putSingle(1, 2, 1);
        grp.putSingle(1, 5, 1);
        grp.putSingle(2, 3, 1);
        grp.putSingle(3, 4, 1);
        grp.putSingle(4, 6, 1);
        grp.putSingle(5, 6, 1);
        grp.putSingle(6, 7, 1);
        Topology_Sort(grp,drg);
    }
    public static void Topology_Sort(Graph grp,int[] degree) {
        int n = grp.size();
        int[] res = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i] == 0) q.offer(i+1);
        }
        for(int i=0;i<n;i++){
            if(q.isEmpty()){
                System.out.println("오류:: 사이클이 발생함");
                return;
            }
            // 노드를 다 돌지도 않았는데 큐가 비면 사이클이 발생한 것이다.
            int cq = q.poll();
            res[i] = cq;
            System.out.println(cq);
            ArrayList<Integer[]> node = grp.getNode(cq);
            for(int j=0;j<node.size();j++){
                int c = node.get(j)[0]+1;
                // System.out.println(cq+"번과 연결된 노드 = "+c);
                if(--degree[c-1] == 0){
                    q.offer(c); 
                }
            }
        }
        System.out.println(Arrays.toString(res));
        // 결과로 순차적으로 돌게된 순번이 res배열에 담긴다.
        // 시간복잡도 O(V+E) => 정점의 개수+간선의 개수
    }

    static class Graph {
        private ArrayList<ArrayList<Integer[]>> gr;
        public Graph(int size){
            gr = new ArrayList<ArrayList<Integer[]>>();
            for(int i=0;i<size;i++){
                gr.add(new ArrayList<Integer[]>());
            }
        }

        public void putSingle(int a, int b, int weight){
            gr.get(a-1).add(new Integer[]{b-1,weight});
        }
        public void put(int a, int b, int weight){
            gr.get(a-1).add(new Integer[]{b-1,weight});
            gr.get(b-1).add(new Integer[]{a-1,weight});
        }

        public void printNode(){
            for(int i=0;i<gr.size();i++){
                System.out.print((i+1)+"번째 노드 연결값 :: ");
                System.out.print("[ ");
                for(int j=0;j<gr.get(i).size();j++){
                    System.out.print("("+(gr.get(i).get(j)[0]+1)+","+gr.get(i).get(j)[1]+") ");
                }
                System.out.println("]");
            }
        }
        public ArrayList<ArrayList<Integer[]>> getGraph(){
            return gr;
        }
        public ArrayList<Integer[]> getNode(int a){
            return gr.get(a-1);
        }
        public int size() {
            return gr.size();
        }
    }
}
