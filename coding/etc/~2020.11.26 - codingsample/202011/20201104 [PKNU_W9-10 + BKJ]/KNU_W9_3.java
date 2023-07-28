import java.io.*;
import java.util.*;

public class KNU_W9_3 {
    public static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tok;
    public static int[] arr;
    public static int[] oper;
    public static boolean[] used;
    public static int n, m, result, min, max;
    public static HashSet<Integer> set;
    public static void main(String[] args) throws Exception {
        set = new HashSet<Integer>();
        n = Integer.parseInt(Read.readLine());
        oper = new int[n];
        arr = new int[n];
        used = new boolean[n];
        tok = new StringTokenizer(Read.readLine());
        for(int i=0;i<n;i++) oper[i] = Integer.parseInt(tok.nextToken());
        result = 0;
        for(int i=1;i<=n;i++){
            Func(0,i);
        }
        if(set.isEmpty()) Write.write("No Prime!");
        result = 0;
        Write.flush();
        Write.close();
        Read.close();
    }

    public static void Func(int k, int ci) throws Exception {
        if(k==ci){
            result = 0;
            for(int i=0;i<ci;i++){
                result *= 10;
                result += arr[i];
            }
            if(result<=1 || set.contains(result)) return;
            for(int i=2;i<=Math.sqrt(result);i++){
                if(result%i==0) return;
            }
            Write.write(result+" ");
            set.add(result);
        } else if(k<ci) {
            for(int i=0;i<n;i++){
                if(!used[i]) {
                    used[i] = true;
                    arr[k] = oper[i];
                    Func(k+1,ci);
                    used[i] = false;
                }
            }
        }
    }
}
