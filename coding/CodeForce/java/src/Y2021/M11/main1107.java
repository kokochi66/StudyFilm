package Y2021.M11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class main1107 {
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;

    public static void main(String[] args) throws Exception {
        solution();
    }

    static Double min;

    public static void solution() throws Exception {
        // https://www.acmicpc.net/problem/1007 벡터매칭
        int tt = Integer.parseInt(rd.readLine());
        for (int TestCase = 0; TestCase < tt; TestCase++) {
            int n = Integer.parseInt(rd.readLine());
            int[][] input = new int[n][2];
            for (int i = 0; i < n; i++) {
                tok = new StringTokenizer(rd.readLine());
                input[i][0] = Integer.parseInt(tok.nextToken());
                input[i][1] = Integer.parseInt(tok.nextToken());
            }
            int[] arrN = new int[n / 2];
            boolean[] checkN = new boolean[n];
            long[] sum = new long[2];
            min = null;
            btk(0, 0, checkN, sum, input, arrN);
            wr.write(min + "");
            wr.newLine();
        }
        wr.flush();
        wr.close();
    }

    static HashSet<String> set = new HashSet<>();

    public static void btk(int k, int c, boolean[] checkN, long[] sum, int[][] input, int[] arrN) {
//        System.out.println("TEST :: k = " + k +" "+ Arrays.toString(sum) +" "+ arrN.length+" "+min);
        if (k >= checkN.length / 2) {
//            System.out.println("TEST :: " + Arrays.toString(arrN) );
            long sumx = sum[0];
            long sumy = sum[1];
            for (int i = 0; i < checkN.length; i++) {
                if (!checkN[i]) {
                    sumx -= input[i][0];
                    sumy -= input[i][1];
                }
            }
            if (min == null) min = Math.sqrt((sumx * sumx) + (sumy * sumy));
            else if (min > Math.sqrt((sumx * sumx) + (sumy * sumy))) min = Math.sqrt((sumx * sumx) + (sumy * sumy));
        } else {
            for (int i = c; i < checkN.length; i++) {
                if (!checkN[i]) {
                    checkN[i] = true;
                    sum[0] += input[i][0];
                    sum[1] += input[i][1];
                    arrN[k] = i;
                    btk(k + 1, i + 1, checkN, sum, input, arrN);
                    sum[0] -= input[i][0];
                    sum[1] -= input[i][1];
                    checkN[i] = false;
                }
            }

        }
    }

}
