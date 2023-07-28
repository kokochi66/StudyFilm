package src.Y2021.M11;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main1123 {
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
            long a = Long.parseLong(tok.nextToken());
            long b = Long.parseLong(tok.nextToken());
            long x = Long.parseLong(tok.nextToken());

            Queue<Long[]> q = new LinkedList<>();
            HashSet<String> set = new HashSet<String>();
            q.add(new Long[]{a, b});
            boolean check = false;
            while (!q.isEmpty()) {
                Long[] c = q.poll();
//                System.out.println(c[0]+" "+c[1]);
                if (c[0] < x && c[1] < x) continue;
                if (c[0] == x || c[1] == x) {
                    check = true;
                    break;
                }
                long cc = Math.abs(c[0] - c[1]);
                if (cc == Math.min(c[0], c[1])) continue;
                if (!set.contains(cc + "-" + c[1])) {
                    q.add(new Long[]{cc, c[1]});
                    set.add(cc + "-" + c[1]);
                }
                if (!set.contains(c[0] + "-" + cc)) {
                    q.add(new Long[]{c[0], cc});
                    set.add(c[0] + "-" + cc);
                }
            }
            if (check) wr.write("YES");
            else wr.write("NO");
            wr.newLine();
        }
        wr.flush();
    }

    public static void solution2() throws Exception {
        int TT = Integer.parseInt(rd.readLine());
        for (int TS = 0; TS < TT; TS++) {
            tok = new StringTokenizer(rd.readLine());
            long k = Long.parseLong(tok.nextToken());
            long x = Long.parseLong(tok.nextToken());
            long res = bin(1, k * 2, x, k);
            wr.write(res + "");
            wr.newLine();
        }
        wr.flush();
    }

    public static long bin(long left, long right, long x, long k) {
        long mid = (left + right) / 2;

        long cal = calcul(mid, k);
        if (cal >= x) {
            if (mid - 1 == 0) return mid;
            if (calcul(mid - 1, k) < x) return mid;
            if (cal == x) return mid;
            return bin(left, mid, x, k);
        }
        if (mid >= ((2 * k) - 1)) return mid;
        return bin(mid, right, x, k);
    }

    public static long calcul(long k, long n) {
        if (k > n) {
            long m = (2 * n - 1) - k;
            return ((n * (n + 1)) / 2) + ((n * (n - 1) / 2) - (m * (m + 1) / 2));
        }
        return (k * (k + 1)) / 2;
    }

}
