package src.Y2021.M11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class main1113 {
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
        solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
    }

    public static int solution(int[] money) {
        int[] res1 = new int[money.length - 1];
        int[] res2 = new int[money.length - 1];
        int n = money.length;
        for (int i = 0; i < res1.length; i++) {
            if (i == 0) res1[0] = money[0];
            else if (i == 1) res1[1] = Math.max(money[0], money[1]);
            else if (i == 2) res1[2] = Math.max(money[0] + money[2], money[1]);
            else {
                res1[i] = Math.max(res1[i - 2], res1[i - 3]) + money[i];
            }
        }
        for (int i = 0; i < res2.length; i++) {
            if (i == 0) res2[0] = money[1];
            else if (i == 1) res2[1] = Math.max(money[1], money[2]);
            else if (i == 2) res2[2] = Math.max(money[1] + money[3], money[2]);
            else {
                res2[i] = Math.max(res2[i - 2], res2[i - 3]) + money[i + 1];
            }
        }

        int answer = 0;
//        System.out.println(Math.max(Arrays.stream(res1).max().getAsInt(), Arrays.stream(res2).max().getAsInt()));

        return Math.max(Arrays.stream(res1).max().getAsInt(), Arrays.stream(res2).max().getAsInt());
    }
}
