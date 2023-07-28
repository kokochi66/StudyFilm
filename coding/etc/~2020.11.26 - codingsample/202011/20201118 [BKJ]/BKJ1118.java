import java.util.*;
import java.io.*;

public class BKJ1118 {
    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    static StringBuilder output = new StringBuilder("");
    static int[][] darr, doper;
    static char[][] carr;
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
        int k = Integer.parseInt(tok.nextToken());
        arr = new int[n];
        for(int i=1;i<=n;i++) arr[i-1] = i;
        if(n <= ((m-1)*k) && n-k>=m-1){
            for(int i=k;i>=1;i--) Write.write(i+" ");
            m--;
            int c = k+1, paring = (n-k)/m;
            while(c <= n){
                if(m==1) {
                    for(int i=n;i>=c;i--) Write.write(i+" ");
                    break;
                }
                else for(int i=c+paring-1;i>=c;i--) Write.write(i+" ");
                c += paring;
                m--;
            }
        } else Write.write("-1");
        Write.flush();
    }
    public static void BKJ1118_2() throws Exception {
        int TestCase = Integer.parseInt(Read.readLine());
        for(int TT=0;TT<TestCase;TT++){
            n = Integer.parseInt(Read.readLine());
            darr = new int[n][n];
            int[] hp = new int[2];
            int[] dp = new int[2];
            tok = new StringTokenizer(Read.readLine());
            hp[0] = Integer.parseInt(tok.nextToken());
            hp[1] = Integer.parseInt(tok.nextToken());
            tok = new StringTokenizer(Read.readLine());
            dp[0] = Integer.parseInt(tok.nextToken());
            dp[1] = Integer.parseInt(tok.nextToken());
            // 입력부 O

            Queue<Integer[]> q = new LinkedList<Integer[]>();
            q.offer(new Integer[]{hp[0],hp[1]});
            dused = new boolean[n][n];
            // 주요 초기 선언부 O

            int count = 0;
            boolean pass = false;
            while(!q.isEmpty() && !pass){
                int Today = q.size();
                for(int i=0;i<Today;i++){
                    Integer[] c = q.poll();
                    if(c[0] == dp[0] && c[1] == dp[1]) {
                        Write.write(count+"");
                        Write.newLine();
                        pass = true;
                        break;
                    }
                    else if(!dused[c[0]][c[1]]){
                        dused[c[0]][c[1]] = true;
                        if(c[0]-2>=0&&c[1]-1>=0) q.offer(new Integer[]{c[0]-2, c[1]-1});
                        if(c[0]-2>=0&&c[1]+1<n) q.offer(new Integer[]{c[0]-2, c[1]+1});
                        if(c[0]-1>=0&&c[1]-2>=0) q.offer(new Integer[]{c[0]-1, c[1]-2});
                        if(c[0]-1>=0&&c[1]+2<n) q.offer(new Integer[]{c[0]-1, c[1]+2});
                        if(c[0]+1<n&&c[1]-2>=0) q.offer(new Integer[]{c[0]+1, c[1]-2});
                        if(c[0]+1<n&&c[1]+2<n) q.offer(new Integer[]{c[0]+1, c[1]+2});
                        if(c[0]+2<n&&c[1]-1>=0) q.offer(new Integer[]{c[0]+2, c[1]-1});
                        if(c[0]+2<n&&c[1]+1<n) q.offer(new Integer[]{c[0]+2, c[1]+1});
                    }
                }
                count++;
            }
        }
        Write.flush();
    }
    public static void BKJ1118_1() throws Exception {
        n = Integer.parseInt(Read.readLine());
        carr = new char[n][n];
        for(int i=0;i<n;i++){
            carr[i] = Read.readLine().toCharArray();
        }
        // 입력부 O
        
        dused = new boolean[n][n];
        int nc = 0, sc=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!dused[i][j]) {
                    BKJ1118_1_bfs(new char[]{carr[i][j]},i,j);
                    nc++; 
                }
            }
        }
        // 100만

        dused = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!dused[i][j]){
                    if(carr[i][j] == 'B'){
                        char[] tem = {'B'};
                        BKJ1118_1_bfs(tem,i,j);
                        sc++;
                    } else {
                        char[] tem = {'R','G'};
                        BKJ1118_1_bfs(tem,i,j);
                        sc++;
                    }
                }
            }
        }
        // 100만
        System.out.println(nc+" "+sc);

    }
    public static void BKJ1118_1_bfs(char[] dir, int hi, int wi) {
        if(dused[hi][wi]) return;
        boolean pass = false;
        for(int i=0;i<dir.length;i++){
            if(dir[i] == carr[hi][wi]) pass = true;
        }
        if(!pass) return;
        dused[hi][wi] = true;
        if(hi>0) BKJ1118_1_bfs(dir,hi-1,wi);
        if(wi>0) BKJ1118_1_bfs(dir,hi,wi-1);
        if(hi<n-1) BKJ1118_1_bfs(dir,hi+1,wi);
        if(wi<n-1) BKJ1118_1_bfs(dir,hi,wi+1);
    }
}