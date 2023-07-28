package src.Y2021.M11;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class main1121 {
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    static StringBuilder output = new StringBuilder("");
    static int[][] darr, doper;
    static boolean[][] dused, dcheck;
    static int[] arr, oper;
    static boolean[] used, check;
    static int h, w, n, m;

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        int TT = Integer.parseInt(rd.readLine());
        for (int TS = 0; TS < TT; TS++) {
            tok = new StringTokenizer(rd.readLine());
            int a = Integer.parseInt(tok.nextToken());
            int b = Integer.parseInt(tok.nextToken());

            int x = 0, y = 0;
            if (a % 3 > b % 3) {
                x = a;
                y = b;
            } else if (a % 3 < b % 3) {
                x = b;
                y = a;
            } else {
                x = a > b ? a : b;
                y = a > b ? b : a;
            }
            int dx = x % 3;
            int dy = y % 3;
            int res = (x / 3) * y;
            res += ((y / 3) * dx);
            res += dx == 2 && dy == 2 ? 2 :
                    dx == 0 || dy == 0 ? 0 : 1;
            wr.write(res + "");
            wr.newLine();
        }
        wr.flush();
    }

    public static void solution2() throws Exception {
        int TT = Integer.parseInt(rd.readLine());
        for (int TS = 0; TS < TT; TS++) {
            tok = new StringTokenizer(rd.readLine());
            long x = Integer.parseInt(tok.nextToken());
            long y = Integer.parseInt(tok.nextToken());
            wr.write((-(x * x)) + " " + (y * y));
            wr.newLine();
        }
        wr.flush();
    }
}
