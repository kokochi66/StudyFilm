import java.util.*;
import java.io.*;

public class BKJ1111 {
    // 1. 큐 https://www.acmicpc.net/problem/3078 좋은친구

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
        h = Integer.parseInt(tok.nextToken());
        w = Integer.parseInt(tok.nextToken());
        char[][] arr = new char[h][w];
        Queue<Integer[]> birs = new LinkedList<>();
        for(int i=0;i<h;i++){
            arr[i] = Read.readLine().toCharArray();
            for(int j=0;j<w;j++) if(arr[i][j]=='2') birs.add(new Integer[]{i,j,0,0});
            // h, w, 비용, 최종피해
        }
    }
    public static int BKJ1111_BFS() throws Excpetion {
        
    }
    public static void BKJ1111_Queue() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        n = Integer.parseInt(tok.nextToken());
        m = Integer.parseInt(tok.nextToken());
        long[][] darr = new long[30][n+5];
        int[] CS = new int[30];
        for(int i=0;i<n;i++){
            int lenc = Read.readLine().length();
            darr[lenc][CS[lenc]] = i+1;
            CS[lenc]++;
        }

        long count = 0;
        for(int i=1;i<25;i++){
            Queue<Long> q = new LinkedList<>();
            for(int j=0;j<CS[i];j++){
                if(q.isEmpty()) q.offer(darr[i][j]);
                else {
                    long Curr = q.peek();
                    long rem = darr[i][j];
                    if(rem-Curr<=m){
                        // System.out.println(darr[i][j]+"  아바보");
                        q.offer(darr[i][j]);
                    }
                    else {
                        while(!q.isEmpty() && rem-Curr>m){
                            count += q.size()-1;
                            q.poll();
                            if(!q.isEmpty()) Curr = q.peek();
                        }
                        q.offer(darr[i][j]);
                        // System.out.println(count+"  Counting");
                    }
                }
            }
            while(!q.isEmpty()) {
                count += q.size()-1;
                q.poll();
            }
        }
        Write.write(count+"");
        // for(int i=0;i<30;i++) {
        //     Write.write(Arrays.toString(darr[i]));
        //     Write.newLine();
        // }
        Write.flush();
    }
    
}

