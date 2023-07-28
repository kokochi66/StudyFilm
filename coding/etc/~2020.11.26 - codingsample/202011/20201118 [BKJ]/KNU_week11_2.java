import java.util.*;
import java.io.*;

public class KNU_week11_2 {
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
        n = Integer.parseInt(Read.readLine());
        darr = new int[n][n];
        for(int i=0;i<n;i++){
            tok = new StringTokenizer(Read.readLine());
            for(int j=0;j<n;j++) darr[i][j] = Integer.parseInt(tok.nextToken());
            
        }
        // 입력부 O

        Queue<Integer[]> q = new LinkedList<>();
        boolean pass = false;
        dused = new boolean[n][n];
        int count = 0;
        q.offer(new Integer[]{0,0});
        while(!q.isEmpty() && !pass){
            int Today = q.size();
            count++;
            for(int i=0;i<Today;i++){
                Integer[] c = q.poll();
                if(c[0] == n-1 && c[1] == n-1){
                    pass = true;
                    break;
                }
                if(!dused[c[0]][c[1]]){
                    dused[c[0]][c[1]] = true;
                    if(c[0]>0 && darr[c[0]-1][c[1]]==1) q.offer(new Integer[]{c[0]-1,c[1]});
                    if(c[1]>0 && darr[c[0]][c[1]-1]==1) q.offer(new Integer[]{c[0],c[1]-1});
                    if(c[0]<n-1 && darr[c[0]+1][c[1]]==1) q.offer(new Integer[]{c[0]+1,c[1]});
                    if(c[1]<n-1 && darr[c[0]][c[1]+1]==1) q.offer(new Integer[]{c[0],c[1]+1});
                }
            }
        }
        System.out.println(count);
    }
}