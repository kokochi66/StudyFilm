package D25;
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
		final int IM = 10000000;
		int n = Integer.parseInt(rd.readLine());
		int[][] darr = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j) darr[i][j] = 0;
				else darr[i][j] = IM;
			}
		}
		for(int i=0;i<n;i++) {
			tok = new StringTokenizer(rd.readLine());
			tok.nextToken();
			for(int j=0;j<n;j++) {
				int temp = Integer.parseInt(tok.nextToken());
				if(temp != 0) darr[i][j] = temp;
			}
		}
		int m = Integer.parseInt(rd.readLine());
		int[] item = new int[m];
		for(int i=0;i<m;i++) {
			item[i] = Integer.parseInt(rd.readLine());
		}
		// 입력부 O
		
		for(int cr=0;cr<n;cr++) {
			int[] w = new int[n];
			PriorityQueue<Edge4> pq = new PriorityQueue<Edge4>();
			for(int i=0;i<n;i++) {
				w[i] = darr[cr][i];
				if(w[i] != 0 && w[i]<IM) pq.offer(new Edge4(cr,i,w[i]));
			}
			while(!pq.isEmpty()) {
				Edge4 c = pq.poll();
				if(w[c.b] < c.weight) continue;
				for(int i=0;i<n;i++) {
					if(darr[c.b][i] !=0 && w[i] > w[c.b] + darr[c.b][i]) {
						w[i] = w[c.b] + darr[c.b][i];
						pq.offer(new Edge4(c.b,i,w[i]));
					}
				}
			}
			for(int i=0;i<n;i++) darr[cr][i] = w[i];
		}
		
		int sum = 0, curr = 0;
		for(int i=0;i<m;i++) {
			sum += darr[curr][item[i]];
			curr = item[i];
		}
		System.out.println(sum);
//		for(int i=0;i<n;i++) System.out.println(Arrays.toString(darr[i]));
//		for(int i=0;i<n;i++) System.out.println(Arrays.toString(darr[i]));
//		System.out.println(Arrays.toString(item)+"   item");
				
	}
	public static class Edge4 implements Comparable<Edge4> {
		int a, b, weight;
		public Edge4 (int ai, int bi, int w) {
			this.a = ai;
			this.b = bi;
			this.weight = w;
		}
		@Override
		public int compareTo(Edge4 o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}

    }
	
	public static void solution3() throws Exception {
		final int IM = 1000000;
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			tok = new StringTokenizer(rd.readLine());
			int n = Integer.parseInt(tok.nextToken());
			int m = Integer.parseInt(tok.nextToken());
			int[][] darr = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(i==j) darr[i][j]=0;
					else darr[i][j] = IM;
				}
			}
			for(int i=0;i<m;i++) {
				tok = new StringTokenizer(rd.readLine());
				int a1 = Integer.parseInt(tok.nextToken());
				int a2 = Integer.parseInt(tok.nextToken());
				int w = Integer.parseInt(tok.nextToken());
				darr[a1-1][a2-1] = w;
				darr[a2-1][a1-1] = w;
			}
			tok = new StringTokenizer(rd.readLine());
			int root = Integer.parseInt(tok.nextToken())-1;
			int next = Integer.parseInt(tok.nextToken())-1;
			int end = Integer.parseInt(tok.nextToken())-1;
			
//			for(int i=0;i<n;i++) System.out.println(Arrays.toString(darr[i]));
			
			int[] weight = new int[n];
			PriorityQueue<Edge3> pq = new PriorityQueue<Edge3>();
			for(int i=0;i<n;i++) {
				weight[i] = darr[root][i];
				if(weight[i] != 0) pq.offer(new Edge3(root,i,weight[i]));
			}
			
			while(!pq.isEmpty()) {
				Edge3 c = pq.poll();
				if(weight[c.b] < c.weight) continue;
				for(int i=0;i<n;i++) {
					if(darr[c.b][i] !=0 && weight[i] > weight[c.b] + darr[c.b][i]) {
						weight[i] = weight[c.b] + darr[c.b][i];
						pq.offer(new Edge3(c.b,i,weight[i]));
					}
				}
			}
			
			int[] wnext = new int[n];
			pq = new PriorityQueue<Edge3>();
			for(int i=0;i<n;i++) {
				wnext[i] = darr[next][i];
				if(wnext[i] != 0) pq.offer(new Edge3(next,i,wnext[i]));
			}
			
			while(!pq.isEmpty()) {
				Edge3 c = pq.poll();
				if(wnext[c.b] < c.weight) continue;
				for(int i=0;i<n;i++) {
					if(darr[c.b][i] !=0 && wnext[i] > wnext[c.b] + darr[c.b][i]) {
						wnext[i] = wnext[c.b] + darr[c.b][i];
						pq.offer(new Edge3(c.b,i,wnext[i]));
					}
				}
			}
			if(weight[next]+wnext[end] >= IM) System.out.println("-1");
			else System.out.println(weight[next]+wnext[end]);
			
//			System.out.println(Arrays.toString(weight));
		}
	}
	static class Edge3 implements Comparable<Edge3>{
		int a, b, weight;
		public Edge3 (int ai, int bi, int w) {
			this.a = ai;
			this.b = bi;
			this.weight = w;
		}
		@Override
		public int compareTo(Edge3 o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
		
	}
	
	public static void solution2() throws Exception {
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			int n = Integer.parseInt(rd.readLine());
			NWGraph grp = new NWGraph(n);
			int[][] darr = new int[n][2];
			for(int i=0;i<n;i++) {
				tok = new StringTokenizer(rd.readLine());
				darr[i][0] = Integer.parseInt(tok.nextToken());
				darr[i][1] = Integer.parseInt(tok.nextToken());
			}
			for(int i=0;i<n;i++) {
				for(int j=i+1;j<n;j++) {
					if(j!=i && (darr[i][0] == darr[j][0] || darr[i][0] == darr[j][1] ||
							darr[i][1] == darr[j][0] || darr[i][1] == darr[j][1])) {
						grp.put(i, j);
					}
				}
			}
//			grp.printNode();
			
			int[] oper = new int[n];
			boolean[] used = new boolean[n];
			boolean res = dfs(0,0,grp,used,oper);
			System.out.println(res);
		}
	}
	public static boolean dfs(int k, int node, NWGraph grp, boolean[] used, int[] oper) {
		if(k==grp.size()) {
			System.out.println(Arrays.toString(oper));
			return true;
		}
		ArrayList<Integer> ndl = grp.getNode(node);
		for(int i=0;i<ndl.size();i++) {
			if(!used[ndl.get(i)]) {
				used[ndl.get(i)] = true;
				oper[k] = ndl.get(i);
				if(dfs(k+1, ndl.get(i), grp, used, oper)) return true;
				used[ndl.get(i)] = false;
			}
		}
		return false;
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
	public static void solution1() throws Exception {
		int Testcase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<Testcase;TT++) {
			rd.readLine();
			int n = Integer.parseInt(rd.readLine());
			double[][] arr = new double[n][2];
			for(int i=0;i<n;i++) {
				tok = new StringTokenizer(rd.readLine());
				arr[i][0] = Double.parseDouble(tok.nextToken());
				arr[i][1] = Double.parseDouble(tok.nextToken());
			}
			// 입력 O
			
			
			ArrayList<Edge> egr = new ArrayList<Edge>();
			for(int i=0;i<n-1;i++) {
				for(int j=i+1;j<n;j++) {
					double temp = Math.sqrt(Math.pow(Math.abs(arr[i][0]-arr[j][0]),2) + 
							Math.pow(Math.abs(arr[i][1]-arr[j][1]),2));
					egr.add(new Edge(i,j,temp));
				}
			}
			Collections.sort(egr);
			
			int[] par = new int[n];
			double res = 0;
			for(int i=0;i<n;i++) par[i] = i;
			for(int i=0;i<egr.size();i++) {
				Edge c = egr.get(i);
				if(!finp(par,c.a,c.b)) {
					res += c.dist;
					unip(par,c.a,c.b);
				}
			}
			System.out.printf("%.2f", res);
			
//			for(int i=0;i<egr.size();i++) {
//				System.out.println(egr.get(i).a+" "+egr.get(i).b+" "+egr.get(i).dist);
//			}
//			for(int i=0;i<n;i++) System.out.println(Arrays.toString(darr[i]));
		}
	}
	static class Edge implements Comparable<Edge>{
		double dist;
		int a, b;
		public Edge(int ai, int bi, double d) {
			this.a = ai;
			this.b = bi;
			this.dist = d;
		}
		@Override
		public int compareTo(Edge o) {
			return this.dist > o.dist ? 1 : -1;
		}
	}
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

}
