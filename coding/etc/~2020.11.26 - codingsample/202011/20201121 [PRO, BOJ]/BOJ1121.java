import java.util.*;
import java.io.*;

public class BOJ1121 {
    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    static int[][] darr, doper;
    static boolean[][] dused;
    static int count, n, m, timecom;
    static int[] vect_h = {0,1,0,-1,0};
    static int[] vect_w = {0,0,1,0,-1};
    public static void main(String[] args) throws Exception {
        // Solution();
    }
    public static void BOJ1121_2() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        n = Integer.parseInt(tok.nextToken());
        m = Integer.parseInt(tok.nextToken());
        darr = new int[n][m];
        dused = new boolean[n][m];
        doper = new int[n][m];
        for(int i=0;i<n;i++){
            tok = new StringTokenizer(Read.readLine());
            for(int j=0;j<m;j++) darr[i][j] = Integer.parseInt(tok.nextToken());
        }
        // 입력부 O
        
        count = 0;
        timecom = 0;
        BOJ1121_2_dfs(0,0);
        Write.write(doper[0][0]+"");
        // Write.newLine();
        // Write.write("Time Complexity = "+timecom);
        // Write.newLine();
        // Write.newLine();
        // for(int i=0;i<n;i++) {
        //     Write.write(Arrays.toString(doper[i]));
        //     Write.newLine();
        // }
        Write.flush();
        
    }
    public static int BOJ1121_2_dfs(int hi, int wi) throws Exception {
        // for(int i=0;i<n;i++) {
        //     Write.write(Arrays.toString(doper[i]));
        //     Write.newLine();
        // }
        // Write.newLine();
        // Write.newLine();
        if(hi==n-1 && wi == m-1) {
            return 1;
        } else if(dused[hi][wi]) {
            return doper[hi][wi];
        }
        for(int i=1;i<=4;i++){
            int hn = hi + vect_h[i];
            int wn = wi + vect_w[i];
            if(hn>=0 && wn>=0 && hn<n && wn<m && darr[hn][wn] < darr[hi][wi]) {
                doper[hi][wi] += BOJ1121_2_dfs(hn,wn);
            }
        }
        dused[hi][wi] = true;
        return doper[hi][wi]; 
    }
    public static void BOJ1121_1() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int m= Integer.parseInt(tok.nextToken());
        BOJ1121_Graph grp = new BOJ1121_Graph(n+1);
        int[] degree = new int[n+1];
        for(int i=0;i<m;i++){
            tok = new StringTokenizer(Read.readLine());
            int c1 = Integer.parseInt(tok.nextToken());
            int c2 = Integer.parseInt(tok.nextToken());
            grp.putSingle(c2,c1);
            degree[c1]++;
        }
        //입력부 O

        Queue<Integer> q = new LinkedList<>();
        int[] res = new int[n+1];
        for(int i=1;i<=n;i++) if(degree[i]==0) q.offer(i);
        for(int i=1;i<=n;i++) {
            if(q.isEmpty()) return;
            // 노드를 안돌았는데 큐가 비었으면 사이클
            int c = q.poll();
            res[i] = c;
            ArrayList<Integer> list = grp.getNode(c);
            for(int j=0;j<list.size();j++){
                int temp = list.get(j);
                if(--degree[temp] == 0) q.offer(temp);
            }
        }
        for(int i=n;i>=1;i--) Write.write(res[i]+" ");
        Write.flush();
    }
    static class BOJ1121_Graph{
        private ArrayList<ArrayList<Integer>> gr;
        public BOJ1121_Graph(int size){
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