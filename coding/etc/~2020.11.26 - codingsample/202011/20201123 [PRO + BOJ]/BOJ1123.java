import java.util.*;
import java.io.*;

public class BOJ1123 {
    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    public static void main(String[] args) throws Exception {
        Solution();
    }
    
    public static void Solution() throws Exception {
        int n = Integer.parseInt(Read.readLine());
        int[][] arr = new int[n+1][2];
        for(int i=0;i<n;i++){
            tok = new StringTokenizer(Read.readLine());
            arr[i][0] = Integer.parseInt(tok.nextToken());
            arr[i][1] = Integer.parseInt(tok.nextToken());
        }
        // Insert O
        int[][] oper = new int[n+5][2];
        long max = 0;
        for(int i=n-1;i>=0;i--){
            if(arr[i][0]+i<n+1) {
                oper[i][0] += arr[i][1] + Math.max(oper[i+arr[i][0]][0],oper[i+arr[i][0]][1]);
            }
            if(max < oper[i][0]) max = oper[i][0];
            oper[i][1] = (int)max;
        }
        Write.write(max+"");
        Write.flush();
    }
}