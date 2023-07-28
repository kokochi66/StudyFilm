import java.util.*;
import java.io.*;

public class KNU_week10_2 {
    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    static StringBuilder output = new StringBuilder("");
    static int[][] darr, doper;
    static boolean[][] dused, dcheck;
    static char[] arr, oper;
    static boolean[] used, check;
    static int h, w, n, m;
    public static void main(String[] args) throws Exception {
        Solution();
    }
    public static void Solution() throws Exception {
        n = Integer.parseInt(Read.readLine());
        arr = new char[n*2];
        for(int i=0;i<n*2;i++) {
            if(i<n) arr[i] = 'b';
            else arr[i] = 'c';
        }
        oper = new char[n*2];
        oper[0] = 'b';
        oper[(n*2)-1] = 'c';
        m = (n*2)-1;
        btk(1,1,1); 
        Write.flush();

    }
    public static void btk(int k, int bc, int cc) throws Exception {
        if(k==m)  {
            Write.write(new String(oper));
            Write.newLine();
        } else {
            if(bc<n){
                oper[k] = 'b';
                btk(k+1,bc+1,cc);
            }
            if(cc<n && cc<=bc){
                oper[k] = 'c';
                btk(k+1,bc,cc+1);
            }
        }
    }
    
}
