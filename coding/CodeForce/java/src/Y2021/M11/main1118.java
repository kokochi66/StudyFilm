package src.Y2021.M11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class main1118 {
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
//        solution(25, new int[]{2,14,11,21,17}, 2); // 4
//        solution(25, new int[]{6, 11, 14, 17, 21}, 2); // 5
//        solution(25, new int[]{10}, 1); // 25
//        solution(25, new int[]{10,10}, 2); // 25
//        solution(16, new int[]{4,8,11}, 2); // 8
//        solution(25, new int[]{2, 6, 10, 14, 17, 22, 24}, 4); // 4
//        solution(28, new int[]{2,6,10,14,17,22,27}, 4); // 6
//        solution(32, new int[]{4, 8, 11, 16, 23, 29}, 3); // 7
    }

    public static int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int[] rockArr = new int[rocks.length + 1];
        for (int i = 0; i < rocks.length; i++) rockArr[i] = rocks[i];
        rockArr[rockArr.length - 1] = distance;
        int res = binarySearch(0, distance * 2, rockArr, n);
        System.out.println(res);
        return 0;
    }

    public static int binarySearch(int left, int right, int[] rocks, int n) {
        int mid = (left + right) / 2;

        int res = checkRock(mid, rocks, n);
//        System.out.println("MID :: " + mid+" "+left+" "+right+" "+res);
        if (res == 1 && right - left <= 1) return mid;
        return res == 1 ? binarySearch(mid, right, rocks, n) : binarySearch(left, mid, rocks, n);
    }

    public static int checkRock(int target, int[] rocks, int n) {
        int curr = 0;
        for (int i = 0; i < rocks.length; i++) {
            if (rocks[i] - curr < target) {
//                System.out.println("count :: " + curr +" "+rocks[i]+" "+n+" "+target);
                n--;
            } else {
                curr = rocks[i];
            }
            if (n < 0) return -1;
        }
        return 1;
    }

}
