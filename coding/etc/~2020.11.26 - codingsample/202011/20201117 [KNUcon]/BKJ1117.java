import java.util.*;
import java.io.*;

public class BKJ1117 {
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
        n = Integer.parseInt(tok.nextToken());
        m = Integer.parseInt(tok.nextToken());
        h = Integer.parseInt(tok.nextToken());
        short[][][] tarr = new short[h][m][n];
        Queue<Short[]> q = new LinkedList<Short[]>();
        int ZC = 0;
        for(int i=0;i<h;i++){
            for(int j=0;j<m;j++){
                tok = new StringTokenizer(Read.readLine());
                for(int k=0;k<n;k++){
                    tarr[i][j][k] = Short.parseShort(tok.nextToken());
                    if(tarr[i][j][k] == 1) {
                        tarr[i][j][k] = 0;
                        q.offer(new Short[]{(short)i,(short)j,(short)k});
                    }
                    if(tarr[i][j][k] == 0) ZC++;
                }
            }
        }
        // 입력부 O(200만)
        // 큐 저장되는 정수 => 최대 300만, 현재 배열 저장한 변수 100만 = 400만

        int day = 0, cv = 0;
        while(!(q.isEmpty() || ZC<=0)){
            day++;
            cv = -1;
            int Today = q.size();
            // Write.write(Today+" ");
            // Write.newLine();
            // 현재 큐에 저장되는 부분만큼만 돌면 됨.
            for(int i=0;i<Today;i++){
                Short[] c = q.poll();
                if(tarr[c[0]][c[1]][c[2]] == 0) {
                    ZC--;
                    tarr[c[0]][c[1]][c[2]] = (short)1;
                    if(c[0]>0 && tarr[c[0]-1][c[1]][c[2]]==0) q.add(new Short[]{(short)(c[0]-1),c[1],c[2]});
                    if(c[0]<h-1 && tarr[c[0]+1][c[1]][c[2]]==0) q.add(new Short[]{(short)(c[0]+1),c[1],c[2]});
                    if(c[1]>0 && tarr[c[0]][c[1]-1][c[2]]==0) q.add(new Short[]{c[0],(short)(c[1]-1),c[2]});
                    if(c[1]<m-1 && tarr[c[0]][c[1]+1][c[2]]==0) q.add(new Short[]{c[0],(short)(c[1]+1),c[2]});
                    if(c[2]>0 && tarr[c[0]][c[1]][c[2]-1]==0) q.add(new Short[]{c[0],c[1],(short)(c[2]-1)});
                    if(c[2]<n-1 && tarr[c[0]][c[1]][c[2]+1]==0) q.add(new Short[]{c[0],c[1],(short)(c[2]+1)});
                }
            }
            // for(int i=0;i<h;i++){
            //     for(int j=0;j<m;j++){
            //         for(int k=0;k<n;k++){
            //             Write.write(tarr[i][j][k]+" ");
            //         }
            //         Write.newLine();
            //     }
            //     Write.newLine();
            // }
        }   
        // 너비우선탐색 100^3 => 100만 // O(300)만
        // 큐로 탐색하면서 저장되게될 추가 최대정수 => 300만
        if(ZC>0) Write.write("-1");
        else Write.write((day+cv)+"");

        Write.flush();
    }

    public static void BKJ1117_5() throws Exception {
        n = Integer.parseInt(Read.readLine());
        darr = new int[n][n];
        for(int i=0;i<n;i++){
            tok = new StringTokenizer(Read.readLine());
            for(int j=0;j<n;j++){
                darr[i][j] = Integer.parseInt(tok.nextToken());
            }
        }
        // 입력부 O

        int max = 0;
        for(int i=100;i>=1;i--){
            int count = 0;
            dused = new boolean[n][n];
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(!dused[j][k] && darr[j][k] >= i){
                        BKJ1117_5_bfs(j,k,i);
                        count++;
                    }
                }
            }
            if(max < count) max = count;
        }
        System.out.println(max);
    }
    public static void BKJ1117_5_bfs(int hi, int wi, int k) {
        if(darr[hi][wi] >= k && !dused[hi][wi]) {
            dused[hi][wi] = true;
            if(hi>0) bfs(hi-1,wi,k);
            if(wi>0) bfs(hi,wi-1,k);
            if(hi<n-1) bfs(hi+1,wi,k);
            if(wi<n-1) bfs(hi,wi+1,k);
        }
    }
    public static void BKJ1117_4() throws Exception {
        int Case = Integer.parseInt(Read.readLine());
        PriorityQueue<bkj4_str> pq = new PriorityQueue<bkj4_str>();
        ArrayList<StringBuilder> ls = new ArrayList<StringBuilder>();
        for(int i=0;i<Case;i++) {
            ls.add(new StringBuilder(Read.readLine()));
            pq.offer(new bkj4_str(ls.get(i)));
        }
        // 입력부

        long[] arr = new long[30];

        while(!pq.isEmpty()){
            StringBuilder c = pq.poll().str;
            arr[c.charAt(0)-'A'] += Math.pow(10,c.length()-1);
            c.deleteCharAt(0);
            if(c.length()>0) pq.offer(new  bkj4_str(c));
        }
        int count = 9;
        long sum = 0;
        boolean[] used = new boolean[30];
        for(int i=0;i<10;i++){
            int max = 0, mp = 29;
            for(int j=0;j<30;j++){
                if(!used[j] && max < arr[j]) {
                    max = (int)arr[j];
                    mp = j;
                }
            }
            if(mp!=29){
                used[mp] = true;
                sum += (arr[mp]*count);
                arr[mp] = count--;
            }
        }
        
        System.out.println(sum);
        
    }
    static class bkj4_str implements Comparable<bkj4_str> {
        StringBuilder str;
        public bkj4_str(StringBuilder s){
            this.str = s;
        }
        @Override
        public int compareTo(bkj4_str bk){
            return bk.str.length()-this.str.length();
        }
    }
    public static void BKJ1117_3() throws Exception {
        String input = Read.readLine();
        tok = new StringTokenizer(input,"[+-]");
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Character> op = new ArrayList<>();
        while(tok.hasMoreTokens()) list.add(Integer.parseInt(tok.nextToken()));
        for(int i=0;i<input.length();i++){
            if(input.charAt(i) == '+' ||input.charAt(i) == '-' ) op.add(input.charAt(i));
        }
        // 입력부 O
        int index = 0;
        long sum = list.get(0);
        while(index < op.size()){
            if(op.get(index)== '-'){
                int ci = index+1;
                long ct = list.get(index+1);
                while(ci<op.size() && op.get(ci)=='+'){
                    ct += list.get(ci+1);
                    ci++;
                }
                sum -= ct;
                index = ci-1;
            } else {
                sum += list.get(index+1);
            }
            index++;
        }
        System.out.println(sum);
        // for(int i=0;i<list.size()-1;i++){
        //     System.out.print(list.get(i)+" "+op.get(i)+" ");
        // }
        // System.out.println(list.get(list.size()-1));
    }
    public static void BKJ1117_2() throws Exception {
        n = Integer.parseInt(Read.readLine());
        m = 1000-n;
        int[] arr = {1,5,10,50,100,500};
        int index = 5, count=0;
        while(m>0){
            if(arr[index] <=m ){
                count += m/arr[index];
                m %= arr[index];
            }
            index--;
        }
        System.out.println(count);
    }
    public static void BKJ1117_1() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        n = Integer.parseInt(tok.nextToken());
        m = Integer.parseInt(tok.nextToken());
        arr = new int[n+5];
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(Read.readLine());
        //입력부 O

        int index = n-1;
        int count = 0;
        while(m>0){
            if(arr[index]<=m){
                count += m/arr[index];
                m %= arr[index];
            }
            index--;
        }
        System.out.println(count);
    }
}
