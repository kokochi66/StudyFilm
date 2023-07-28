import java.util.*;
import java.io.*;

public class BKJ1115 {
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
        // Solution();
    }
    public static void BKJ1115_4() throws Exception {
        n = Integer.parseInt(Read.readLine());
        long[] arr = new long[n+5];
        arr[1] = 1;
        arr[2] = 3;
        for(int i=3;i<=n;i++){
            arr[i] = (arr[i-1] + (arr[i-2]*2))%10007;
        }
        System.out.println(arr[n]);
    }
    public static void BKJ1115_3() throws Exception {
        n = Integer.parseInt(Read.readLine());
        long[][] darr = new long[n+5][10];
        for(int i=0;i<10;i++) darr[1][i] = 1;
        for(int i=2;i<=n;i++){
            darr[i][0] = darr[i-1][1];
            darr[i][9] = darr[i-1][8];
            for(int j=1;j<9;j++){
                darr[i][j] = (darr[i-1][j-1] + darr[i-1][j+1])%1000000000;
            }
        }
        long res = 0;
        for(int i=1;i<10;i++){
            res = (res + darr[n][i])%1000000000;
        }
        System.out.println(res);
    }
    public static void BKJ1115_2() throws Exception {
        n = Integer.parseInt(Read.readLine());
        darr = new int[n][2];
        tok = new StringTokenizer(Read.readLine());
        for(int i=0;i<n;i++){
            darr[i][0] = Integer.parseInt(tok.nextToken());
            darr[i][1] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(darr[i][0] > darr[j][0] && darr[i][1]-1 < darr[j][1]){
                    darr[i][1] = darr[j][1]+1;
                }
            }
        }
        int max = 0;
        // for(int i=0;i<n;i++) System.out.println(Arrays.toString(darr[i]));
        for(int i=0;i<n;i++) if(max<darr[i][1]) max = darr[i][1];
        System.out.println(max);
    }
    public static void BKJ1115_1() throws Exception {
        n = Integer.parseInt(Read.readLine());
        arr = new int[n];
        tok = new StringTokenizer(Read.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(tok.nextToken());
        }
        darr = new int[n][2];
        darr[0][0] = arr[0];
        darr[0][1] = arr[0];
        for(int i=1;i<n;i++){
            darr[i][0] = Math.max(darr[i-1][0] + arr[i], arr[i]);
            darr[i][1] = Math.max(darr[i-1][1] , darr[i][0]);
        }
        System.out.println(darr[n-1][1]);
    }
    
}
