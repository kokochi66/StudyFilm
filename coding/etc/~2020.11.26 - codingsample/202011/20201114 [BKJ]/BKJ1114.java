import java.util.*;
import java.io.*;

public class BKJ1114 {
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
        long[] arr = new long[n+5];
        for(int i=0;i<n;i++){
            arr[i] =Long.parseLong(Read.readLine());
        }
        long[][] doper = new long[n+5][3];
        doper[0][0] = arr[0];
        doper[0][1] = arr[0];
        doper[0][2] = arr[0];
        doper[1][0] = arr[1];
        doper[1][1] = Math.max(doper[0][0],doper[0][2]) + arr[1];
        doper[1][2] = arr[1];
        doper[2][0] = Math.max(Math.max(doper[0][0], doper[0][1]), doper[0][2]) + arr[2];
        doper[2][1] = Math.max(doper[1][0],doper[1][2]) + arr[2];
        doper[2][2] = arr[2];
        long max = doper[0][0] + arr[1];
        for(int i=3;i<n;i++){
            doper[i][0] = Math.max(Math.max(doper[i-2][0], doper[i-2][1]), doper[i-2][2]) + arr[i];
            doper[i][1] =  Math.max(doper[i-1][0],doper[i-1][2]) + arr[i];
            doper[i][2] = Math.max(doper[i-3][1],Math.max(doper[i-3][0],doper[i-3][2])) + arr[i];
            long curr = Math.max(Math.max(doper[i][0],doper[i][1]),doper[i][2]);
            if(curr > max) max = curr;
        }
        for(int i=0;i<n;i++) System.out.println(Arrays.toString(doper[i]));
        System.out.println(max);
    }
    public static void BKJ1114_5() throws Exception {
        n = Integer.parseInt(Read.readLine());
        long[] arr = new long[n+5];
        arr[0] = 1;
        arr[1] = 1;
        for(int i=2;i<n;i++) {
            arr[i] = arr[i-2]+arr[i-1];
        }
        System.out.println(arr[n-1]);
    }
    public static void BKJ1114_4() throws Exception {
        int n = Integer.parseInt(Read.readLine());
        darr = new int[n+5][n+5];
        for(int i=0;i<n;i++){
            tok = new StringTokenizer(Read.readLine());
            int j =0;
            while(tok.hasMoreTokens()) darr[i][j++] = Integer.parseInt(tok.nextToken());
        }
        int max = 0;
        doper = new int[n][n];
        for(int i=0;i<n;i++) doper[n-1][i] = darr[n-1][i];
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<i+1;j++){
                doper[i][j] = Math.max(doper[i+1][j], doper[i+1][j+1]) + darr[i][j];
            }
        }
        System.out.println(doper[0][0]);
    }
    public static void BKJ1114_3() throws Exception {
        int n = Integer.parseInt(Read.readLine());
        arr = new int[n+5];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(Read.readLine());
        }
        darr = new int[n+5][2];
        darr[0][0] = arr[0];
        darr[0][1] = arr[0];
        darr[1][0] = arr[1];
        darr[1][1] = arr[1] + darr[0][0];
        for(int i=2;i<n;i++){
            darr[i][0] = Math.max(darr[i-2][0],darr[i-2][1]) + arr[i];
            darr[i][1] = darr[i-1][0] + arr[i];
        }
        // for(int i=0;i<n;i++) System.out.println(Arrays.toString(darr[i]));
        System.out.println(Math.max(darr[n-1][0],darr[n-1][1]));

    }
    public static void BKJ1114_2() throws Exception {
        n = Integer.parseInt(Read.readLine());
        darr = new int[n][3];
        for(int i=0;i<n;i++){
            tok = new StringTokenizer(Read.readLine());
            darr[i][0] = Integer.parseInt(tok.nextToken());
            darr[i][1] = Integer.parseInt(tok.nextToken());
            darr[i][2] = Integer.parseInt(tok.nextToken());
        }
        doper = new int[n+5][3];
        doper[0][0] = darr[0][0];
        doper[0][1] = darr[0][1];
        doper[0][2] = darr[0][2];
        for(int i=1;i<n;i++){
            doper[i][0] = Math.min(doper[i-1][1], doper[i-1][2]) + darr[i][0];
            doper[i][1] = Math.min(doper[i-1][0], doper[i-1][2]) + darr[i][1];
            doper[i][2] = Math.min(doper[i-1][1], doper[i-1][0]) + darr[i][2];
        }
        System.out.println(Math.min(doper[n-1][0],Math.min(doper[n-1][1],doper[n-1][2])));
        
    }
    public static void BKJ1114_1() throws Exception {
        n = Integer.parseInt(Read.readLine());
        long[] arr = new long[n+5];
        arr[1] = (long)1;
        arr[2] = (long)2;
        for(int i=3;i<=n;i++){
            arr[i] = (arr[i-2] + arr[i-1])%10007;
        }
        System.out.println(arr[n]);
    }
}