import java.io.*;
import java.util.*;

public class KNU_week11_t1 {
    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    public static void main(String[] args) throws Exception {
        Bicoloring();
    }

    public static void Bicoloring() throws Exception {
        int node = Integer.parseInt(Read.readLine());
        int edge = Integer.parseInt(Read.readLine());
        Graph grp = new Graph(node);
        for(int i=0;i<edge;i++){
            tok = new StringTokenizer(Read.readLine());
            int c = Integer.parseInt(tok.nextToken());
            int n = Integer.parseInt(tok.nextToken());
            grp.put(c, n);
        }
        // 입력부 O

        Queue<Integer> q = new LinkedList<>();
        int[] used = new int[node];
        used[0] = 1;
        q.offer(0);
        while(!q.isEmpty()){
            int c = q.poll();
            ArrayList<Integer> cn = grp.getNode(c);
            for(int i=0;i<cn.size();i++) {
                // System.out.println("현재값과 비교 = "+used[c]+"    비교값 = "+used[cn.get(i)]);
                if(used[cn.get(i)] == 0){
                    used[cn.get(i)] = used[c]==1 ? 2 : 1;
                    q.offer(cn.get(i));
                } else if(used[c] == used[cn.get(i)]) {
                    System.out.println("NOT BICOLORABLE.");
                    return;
                }
            }
        }
        System.out.println("BICOLORABLE.");
    }
    static class Graph {
        private ArrayList<ArrayList<Integer>> gr;
        public Graph(int size){
            gr = new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<size;i++){
                gr.add(new ArrayList<Integer>());
            }
        }

        public void putSingle(int a, int b){
            gr.get(a).add(b);
        }
        public void put(int a, int b){
            gr.get(a).add(b);
            gr.get(b).add(a);
        }

        public void printNode(){
            for(int i=0;i<gr.size();i++){
                System.out.print((i)+"번째 노드 연결값 :: ");
                System.out.print("[ ");
                for(int j=0;j<gr.get(i).size();j++){
                    System.out.print("("+(gr.get(i).get(j))+") ");
                }
                System.out.println("]");
            }
        }
        public ArrayList<ArrayList<Integer>> getGraph(){
            return gr;
        }
        public ArrayList<Integer> getNode(int a){
            return gr.get(a);
        }
    }
}
