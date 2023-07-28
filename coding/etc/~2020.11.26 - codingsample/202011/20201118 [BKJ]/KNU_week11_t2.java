import java.io.*;
import java.util.*;

public class KNU_week11_t2 {
    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    public static void main(String[] args) throws Exception {
        From_Dusk_Till_Dawn();
    }

    public static void From_Dusk_Till_Dawn() throws Exception {
        HashMap<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(Read.readLine());
        int count = 0;
        int[][] darr = new int[n][4];
        ArrayList<String> city = new ArrayList<>();
        for(int i=0;i<n;i++){
            tok = new StringTokenizer(Read.readLine());
            String s1 = tok.nextToken();
            String s2 = tok.nextToken();
            if(!map.containsKey(s1)) {
                map.put(s1, count++);
                city.add(s1);
            }
            if(!map.containsKey(s2)) {
                map.put(s2, count++);
                city.add(s2);
            }
            int st = Integer.parseInt(tok.nextToken());
            int tr = Integer.parseInt(tok.nextToken());
            darr[i][0] = map.get(s1);
            darr[i][1] = map.get(s2);
            darr[i][2] = st;
            darr[i][3] = tr;
        }
        tok = new StringTokenizer(Read.readLine());
        int[] travel = new int[2];
        travel[0] = map.get(tok.nextToken());
        travel[1] = map.get(tok.nextToken());
        // 정수 4천, 문자열 8천, 입력부 O
        // for(int i=0;i<n;i++) System.out.println(Arrays.toString(darr[i]));
        // System.out.println(Arrays.toString(travel));

        Graph grp = new Graph(count);
        boolean[][] dused = new boolean[count][count];
        HashMap<String, data> dataMap = new HashMap<>();
        for(int i=0;i<n;i++) {
            if(!dused[darr[i][0]][darr[i][1]]){
                if(darr[i][2]>=18 && darr[i][2]+darr[i][3] <=30){
                    grp.putSingle(darr[i][0], darr[i][1]);
                    dused[darr[i][0]][darr[i][1]] = true;
                    dataMap.put(darr[i][0]+"-"+darr[i][1], 
                    new data(city.get(darr[i][0]), city.get(darr[i][1]), darr[i][2], darr[i][3]));
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(travel[0]);
        boolean[] used = new boolean[count];
        // 주요 선언부 O


        while(!q.isEmpty()){
            int c = q.poll();
            ArrayList<Integer> node = grp.getNode(c);
            for(int i=0;i<node.size();i++){
                if(!used[node.get(i)]){
                    
                }
            }
        }
    }

    static class data {
        String Lp, Rp;
        int St, Dt;
        public data(String l, String r, int s, int d){
            this.Lp = l;
            this.Rp = r;
            this.St = s;
            this.Dt = d;
        }
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
