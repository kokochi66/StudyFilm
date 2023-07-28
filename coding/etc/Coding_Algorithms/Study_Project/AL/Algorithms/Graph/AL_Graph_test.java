package Algorithms.Graph;
import java.util.*;
public class AL_Graph_test {
	
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
    }


    static class NWGraph {
        private ArrayList<ArrayList<Integer>> gr;
        public NWGraph(int size){
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
        public int size() {
            return gr.size();
        }
    }
}
