import java.util.*;
import java.io.*;

public class KNU_week10_1 {
    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    static StringBuilder output = new StringBuilder("");
    static int[][] darr, doper;
    static boolean[][] dused, dcheck;
    static int[] arr, oper;
    static boolean[] used, check;
    static int h, w, n, m, max, min,sub;
    public static void main(String[] args) throws Exception {
        Solution();
    }
    public static void Solution() throws Exception {
        int TestCase = Integer.parseInt(Read.readLine());
        for(int TT=0;TT<TestCase;TT++){
            Read.readLine();
            n = Integer.parseInt(Read.readLine());
            arr = new int[n];
            used = new boolean[n];
            int half = 0;
            for(int i=0;i<n;i++) {
                arr[i] = Integer.parseInt(Read.readLine());
                half += arr[i];
            }
            half /= 2;
            //0 0 0 = 
        }
        Write.flush();
    }
    public static void btk_fun(int k, int ci, int res) throws Exception {
        if(k == n/2){
            int mam = 0;
            for(int i=0;i<n;i++) if(!used[i]) mam+=arr[i];
            if(Math.abs(mam-res) < sub) {
                max = Math.max(res, mam);
                min = Math.min(res, mam);
                sub = Math.abs(mam-res);
            }
        } else {
            for(int i=ci;i<n;i++){
                if(!used[i]){
                    res += arr[i];
                    used[i] = true;
                    btk_fun(k+1, i, res);
                    used[i] = false;
                    res -= arr[i];
                }
            }
        }
    }
    
}
