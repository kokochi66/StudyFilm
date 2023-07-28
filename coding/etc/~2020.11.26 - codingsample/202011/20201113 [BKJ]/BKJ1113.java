import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class BKJ1113 {
    // 1. 정렬 https://www.acmicpc.net/problem/11652 카드
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

        // n = 2;
        // long[][] a = {
        //     {1,2},
        //     {3,4}
        // };
        // long[][] b = matrixProduct(a,a);
        // for(int i=0;i<n;i++) System.out.println(Arrays.toString(b[i]));
    }
    public static void Solution() throws Exception {
        tok = new StringTokenizer(Read.readLine());
        n = Integer.parseInt(tok.nextToken());
        BigInteger pw = new BigInteger(tok.nextToken());
        long[][] bg = new long[n][n];
        for(int i=0;i<n;i++){
            tok = new StringTokenizer(Read.readLine());
            for(int j=0;j<n;j++) bg[i][j] = Long.parseLong(tok.nextToken());
        }
        long[][] res = Fast_matP(bg,pw);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Write.write(res[i][j]+" ");
            }
            Write.newLine();
        }
        Write.flush();
    }
    public static long[][] Fast_matP(long[][] a, BigInteger pw){
        long[][] out = new long[n][n];
        for(int i=0;i<n;i++) out[i][i] = 1;
        final BigInteger zero = new BigInteger("0");
        final BigInteger two = new BigInteger("2");
        while(pw.compareTo(zero) != 0) {
            if(pw.mod(two).compareTo(zero) != 0) {
                out = matrixProduct(a, out);
            }
            a = matrixProduct(a,a);
            pw = pw.divide(two);
        }
        return out;
    }
    public static long[][] matrixProduct(long[][] a, long[][] b){
        long[][] outp = new long[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    outp[i][j] += a[i][k] * b[k][j];
                }
                outp[i][j] %= 1000;
                // System.out.println(i+" "+j+"   "+out[i][j]);
            }
        }
        return outp;
    }
    public static BKJ1113_1() throws Exception {
        n = Integer.parseInt(Read.readLine());
        String[] arr = new String[n];
        for(int i=0;i<n;i++){
            arr[i] = Read.readLine();
        }
        int max = 0;
        String temp;
        for(int i=1;i<n;i++){
            int c=i,root;
            do {
                root = (c-1)/2;
                if(new BigInteger(arr[root]).compareTo(new BigInteger(arr[c])) == 1 ){
                    temp =arr[root];
                    arr[root]=arr[c];
                    arr[c]=temp;
                }
                c=root;
            } while(c!=0);
        }

        String curr = arr[0];
        String maxT = arr[0];
        int count = 0;
        for(int i=n-1;i>=0;i--){
            if(curr.equals(arr[0])) count++;
            else {
                if(max < count) {
                    max = count;
                    maxT = curr;
                }
                curr = arr[0];
                count = 1;
            }
            arr[0] = arr[i];
            int c=0,next;
            do{
                next = (c*2)+1;
                if(next+1<i && new BigInteger(arr[next]).compareTo(new BigInteger(arr[next+1])) == 1 ) next++;
                if(next<i && new BigInteger(arr[c]).compareTo(new BigInteger(arr[next])) == 1 ){
                    temp = arr[next];
                    arr[next]=arr[c];
                    arr[c]=temp;
                }
                c=next;
            }while(c<i);
        }
        if(max < count) {
            max = count;
            maxT = curr;
        }
        System.out.println(maxT);
    }
    
}
