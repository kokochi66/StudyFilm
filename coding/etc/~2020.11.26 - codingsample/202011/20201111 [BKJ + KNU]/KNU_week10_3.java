import java.util.*;
import java.io.*;

public class KNU_week10_3 {
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
        doper = new int[n][n];
        for(int i=0;i<n;i++){
            tok = new StringTokenizer(Read.readLine());
            for(int j=0;j<n;j++) darr[i][j] = Integer.parseInt(tok.nextToken());
        }
        int count = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(darr[i][j]==1) {
                    bfs(i,j,count);
                    count++;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Write.write(doper[i][j]+" ");
            }
            Write.newLine();
        }
        Write.flush();
    }
    public static void bfs(int h, int w, int c) {
        doper[h][w] = c;
        darr[h][w] = 0;
        if(h>0 && darr[h-1][w]==1) bfs(h-1,w,c);
        if(w>0 && darr[h][w-1]==1) bfs(h,w-1,c);
        if(w<n-1 && darr[h][w+1]==1) bfs(h,w+1,c);
        if(h<n-1 && darr[h+1][w]==1) bfs(h+1,w,c);
    }
}
