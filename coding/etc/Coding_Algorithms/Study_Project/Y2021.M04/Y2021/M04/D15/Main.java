package Y2021.M04.D15;

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		int[] a = {-5,0,2,1,2};
		int[][] edges = {
				{0,1},{3,4},{2,3},{0,3}};
		
		int[] a2 = {0,1,0};
		int[][] edges2 = {
				{0,1},{1,2}};
		System.out.println(solution(a,edges));
	}
	 public static long solution(int[] a, int[][] edges) {
	        long res = 0;
	        int n =a.length;
	        NWGraph grp = new NWGraph(n,a);
	        for(int i=0;i<edges.length;i++) {
	        	grp.put(edges[i][0], edges[i][1]);
	        }
	        int temp = grp.findLeaf();
	        while(temp > 0) {
	        	res += temp;
	        	temp = grp.findLeaf();
	        }
	        
	        return Arrays.stream(grp.weight).sum() == 0 ? res : -1;
	 }
	 
	 static class NWGraph {
	        private ArrayList<Integer>[] gr;
	        boolean[] chk;
	        int[] weight;
	        public NWGraph(int size, int[] w){
	            gr = new ArrayList[size];
	            chk = new boolean[size];
	            for(int i=0;i<size;i++){
	            	gr[i] = new ArrayList<Integer>();
	            }
	            weight = new int[size];
	            for(int i=0;i<size;i++) weight[i] = w[i];
	        }
	        public void put(int a, int b){
	        	gr[a].add(b);
	        	gr[b].add(a);
	        }
	        public int findLeaf() {
	        	int sum = 0;
	        	 for(int i=0;i<gr.length;i++){
	        		int sr = gr[i].size(), edNode = 0;
	        		if(!chk[i]) {
	        			for(int j=0;j<gr[i].size();j++){
		                    if(chk[gr[i].get(j)]) sr--;
		                    else edNode = gr[i].get(j);
		                }
		                if(sr == 1) {
		                	this.chk[i] = true;
		                	weight[edNode] += weight[i];
		                	sum += Math.abs(weight[i]);
		                	weight[i] = 0;
		                }
	        		}
		        }
	        	 return sum;
	        } 
	    }
	 
	public static int solution2(String s) {
		StringBuffer str = new StringBuffer(s);
		int res = 0;
		for(int i=0;i<str.length();i++) {
			if(sol2_check(str.toString())) res++;
			str.append(str.charAt(0));
			str.deleteCharAt(0);
		}
        return res;
    }
	public static boolean sol2_check(String s) {
		Stack<Character> st = new Stack<>();
		int n = s.length();
		for(int i=0;i<n;i++) {
			char c = s.charAt(i);
			if(c == '[' || c == '{' || c == '(') {
				st.add(c);
			} else {
				char p = c == ']' ? '[' : c == '}' ? '{' : '(';
				if(st.isEmpty() || st.peek() != p) {
					return false;
				} else st.pop();
			}
		}
		return st.isEmpty();
	}
	public int solution1(int[] absolutes, boolean[] signs) {
		int answer = 0;
		for(int i=0;i<absolutes.length;i++) {
			if(signs[i]) answer += absolutes[i];
			else answer -= absolutes[i];
		}
        return answer;
    }
}
