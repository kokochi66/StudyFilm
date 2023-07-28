import java.util.*;
import java.io.*;

public class CONT_1113 {
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
        arr = new int[n];
        tok = new StringTokenizer(Read.readLine());
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(tok.nextToken());
        
    }
    public static void btk(int k) {
        
    }
    public static void Solution2() throws Exception {
        int Test = Integer.parseInt(Read.readLine());
        for(int TT=0;TT<Test;TT++){
            tok = new StringTokenizer(Read.readLine());
            n = Integer.parseInt(tok.nextToken());
            m = Integer.parseInt(tok.nextToken());
            darr = new int[n][m];
            dused = new boolean[n][m];
            for(int i=0;i<n;i++){
                tok = new StringTokenizer(Read.readLine());
                for(int j=0;j<m;j++) {
                    darr[i][j] = Integer.parseInt(tok.nextToken());
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    int prev = j-1, curr = j;
                    while(prev>=0 && darr[i][prev] == darr[i][curr]){
                        if(!dused[i][prev]){
                            darr[i][prev]++;
                            dused[i][prev] = true;
                        } else darr[i][curr]++;
                        curr--;
                        prev = curr-1; 
                    }
                    prev = i-1;
                    curr = i;
                    while(prev>=0 && darr[prev][j] == darr[curr][j]){
                        if(!dused[prev][j]){
                            darr[prev][j]++;
                            dused[prev][j] = true;
                        } else darr[curr][j]++;
                        curr--;
                        prev = curr-1; 
                    }

                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    Write.write(darr[i][j]+" ");
                }
                Write.newLine();
            }
        }
        Write.flush();
    }
    public static void CONT_1113_B() throws Exception {
        int Test = Integer.parseInt(Read.readLine());
        for(int TT=0;TT<Test;TT++){
            HashSet<Integer> set = new HashSet<>();
            boolean pass = false;
            n = Integer.parseInt(Read.readLine());
            tok = new StringTokenizer(Read.readLine());
            darr = new int[n][n];
            for(int i=0;i<n;i++) {
                darr[i][i] = Integer.parseInt(tok.nextToken());
                if(!set.contains(darr[i][i]))set.add(darr[i][i]);
                else pass =true;
            }


            if(pass) Write.write("YES");
            else Write.write("NO");
            Write.newLine();
        }
        Write.flush();
    }
    public static void CONT_1113_A() throws Exception {
        int Test = Integer.parseInt(Read.readLine());
        for(int TestC=0;TestC<Test;TestC++){
            n = Integer.parseInt(Read.readLine());
            arr = new int[n];
            arr[0] = n;
            for(int i=0;i<n;i++) Write.write(1+" ");
            Write.newLine();
        }
        Write.flush();

    }
    
}
