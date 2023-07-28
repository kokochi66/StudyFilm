import java.util.*;
import java.io.*;

public class BKJ1116 {
    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    static StringBuilder output = new StringBuilder("");
    static int[][] darr, doper;
    static boolean[][] dused, dcheck;
    static int[] arr, oper;
    static boolean[] used, check;
    static int h, w, n, m;
    public static void main(String[] args) throws Exception {
        Solution();
    }
    public static void Solution() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        final int IM = 1000000000;
        int ver = Integer.parseInt(tok.nextToken());
        int edg = Integer.parseInt(tok.nextToken());
        int root = Integer.parseInt(Read.readLine());
        graph grp = new graph(ver);
        for(int i=0;i<edg;i++){
            tok = new StringTokenizer(Read.readLine());
            grp.putSingle(Integer.parseInt(tok.nextToken()),Integer.parseInt(tok.nextToken()),Integer.parseInt(tok.nextToken()));
        }
        int[] weight = new int[ver];
        for(int i=0;i<ver;i++) weight[i] = IM;
        weight[root-1] = 0;
        PriorityQueue<edge> pq = new PriorityQueue<>();
        pq.offer(new edge(root-1,weight[root-1]));
        while(!pq.isEmpty()){
            edge c = pq.poll();
            if(weight[c.next] < c.weight) continue;
            ArrayList<Integer[]> node = grp.getNode(c.next+1);
            for(int i=0;i<node.size();i++){
                if(weight[node.get(i)[0]] > weight[c.next] + node.get(i)[1]){
                    weight[node.get(i)[0]] = weight[c.next] + node.get(i)[1];
                    pq.offer(new edge(node.get(i)[0], weight[node.get(i)[0]]));
                }
            }
        }
        for(int i=0;i<ver;i++){
            if(weight[i] == IM) Write.write("INF ");
            else Write.write((int)weight[i]+" ");
            Write.newLine();
        }
        Write.flush();
        
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
    static class graph {
        private ArrayList<ArrayList<Integer[]>> gr;
        public graph(int size){
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
    }
}
