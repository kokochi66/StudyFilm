import java.util.*;
import java.io.*;

public class KNUcon_1 {
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
        int[][] a ={
            {1,1},
            {1,1},
            {3,3}
        };
        solution(a);
    }
    public static int solution(int[][] seat) {
        HashSet<String> set = new HashSet<String>();
        int res = 0;
        for(int i=0;i<seat.length;i++){
            if(!set.contains(seat[i][0]+"-"+seat[i][1])) {
                set.add(seat[i][0]+"-"+seat[i][1]);
                res++;
            }
        }
        return res;
    }
}
