import java.util.*;
import java.io.*;

public class KNU_week11_0 {
    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    static StringBuilder output = new StringBuilder("");
    static int[][] darr, doper;
    static boolean[][] dused, dcheck;
    static int[] arr, used;
    static boolean[] check;
    static int h, w, n, m;
    static boolean pass;
    public static void main(String[] args) throws Exception {
        Solution();
    }
    public static void Solution() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        n = Integer.parseInt(tok.nextToken());
        m = Integer.parseInt(tok.nextToken());
        darr = new int[n][n];
        for(int i=0;i<n;i++){
            tok = new StringTokenizer(Read.readLine());
            for(int j=0;j<n;j++){
                darr[i][j] = Integer.parseInt(tok.nextToken());
            }
        }
        // 입력부 O
        pass = false;
        for(int TT=1;TT<=m;TT++){
            used = new int[n];
            used[0] = TT;
            btk(1,0);
        }

        if(!pass) Write.write("NONE");
        Write.flush();
    }
    public static void btk(int k, int cn) throws Exception{
        for(int i=0;i<n;i++){
            if(darr[cn][i]==1 && used[cn] == used[i]){
                return;
            }
        }
        // 같은색인지 주변값을 확인
        if(cn==(n-1)) {
            pass = true;
            for(int i=0;i<n;i++) Write.write(used[i]+" ");
            Write.newLine();
        } else {
            // 아직 완전히 연결되지 않았다면
            for(int j=1;j<=m;j++){
                used[cn+1]=j;
                btk(k+1,cn+1);
                used[cn+1]=0;
            }

        }
    }
}