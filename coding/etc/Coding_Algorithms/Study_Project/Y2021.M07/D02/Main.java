package D02;

import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		solution(6, new int[][] {{3,6},{4,3} ,{3,2},{1,3},{1,2},{2,4},{5,2}});
	}
	public static int solution(int n, int[][] edge) throws Exception {
		NWGraph grp = new NWGraph(n);
		int m = edge.length;
		for(int i=0;i<m;i++) {
			grp.put(edge[i][0]-1, edge[i][1]-1);
		}
		boolean[] used = new boolean[n];
		used[0] = true;
		
		Queue<Integer[]> que = new LinkedList<>();
		ArrayList<Integer> list = grp.getNode(0);
		int max = 1;
		int maxCnt = 0;
		for(int i=0;i<list.size();i++) {
			System.out.println("list Value = "+list.get(i));
			que.add(new Integer[] {list.get(i), 1});
			used[list.get(i)] = true;
			maxCnt++;
		}

		
		while(!que.isEmpty()) {
			Integer[] curr = que.poll();
			System.out.println("curr = " + Arrays.toString(curr)+" "+max+" "+maxCnt);
			ArrayList<Integer> c = grp.getNode(curr[0]);
			boolean isLeaf = true;
			for(int i=0;i<c.size();i++) {
				if(!used[c.get(i)]) {
					isLeaf = false;
					que.add(new Integer[] {c.get(i) ,curr[1] + 1});
					used[c.get(i)] = true;
				}
			}
			if(isLeaf) {
				if(max < curr[1]) {
					max = curr[1];
					maxCnt = 1;
				} else if(max == curr[1]) {
					maxCnt++;
				}
			}
		}
		System.out.println(max+" "+maxCnt);
		
		
		return maxCnt;
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