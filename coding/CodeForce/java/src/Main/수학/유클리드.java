package src.Main.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 유클리드 {
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
        System.out.println(유클리드알고리즘(64, 24));
    }

    public static int 유클리드알고리즘(int a, int b) throws Exception {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int res = 0;
        while (min > 0) {
            int pset = max / min;
            int nset = max % min;
            if (nset == 0) {
                res = min;
                break;
            }
            max = min;
            min = nset;
        }
        // 최소공배수 = (a*b)/res
        // 최대공약수 = res
        return (a * b) / res;
    }
}
