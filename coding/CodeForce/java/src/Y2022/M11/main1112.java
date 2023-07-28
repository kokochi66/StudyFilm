package src.Y2022.M11;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class main1112 {
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        int n = Integer.parseInt(rd.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            tok = new StringTokenizer(rd.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(tok.nextToken());
            }
        }

        int res = dc(arr);
        System.out.println(res);

    }

    public static int dc(int[][] arr) {
        if (arr.length == 1) return arr[0][0];
        int n = arr.length / 2;
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j ++) {
                int[] temp = new int[4];
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        temp[(k * 2) + l] = arr[(i * 2) + k][(j * 2) + l];
                    }
                }
                Arrays.sort(temp);
                copy[i][j] = temp[2];
            }
        }
        return dc(copy);
    }

}
