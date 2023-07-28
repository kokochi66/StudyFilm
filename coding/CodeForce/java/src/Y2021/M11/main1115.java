package src.Y2021.M11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main1115 {
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
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
//        System.out.println(solution("hit","cog", new String[]{"hot","dot","dog","lot","log"}));
    }


    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        int n = words.length;
//        System.out.println("TEST :: " + n);
        int[] beginComp = new int[n];
        for (int i = 0; i < n; i++) beginComp[i] = compChar(begin, words[i]);

        int[][] compArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                compArr[i][j] = compChar(words[i], words[j]);
            }
        }
//        for(int i=0;i<n;i++) System.out.println(Arrays.toString(compArr[i]));

        Queue<Integer[]> q = new LinkedList<>();
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (beginComp[i] == 1) q.add(new Integer[]{i, 1});
        }
        while (!q.isEmpty() && !words[q.peek()[0]].equals(target)) {
            Integer[] c = q.poll();
//            System.out.println("C :: " + Arrays.toString(c)+" "+Arrays.toString(check));
            for (int i = 0; i < n; i++) {
                if (compArr[c[0]][i] == 1 && !check[i]) {
                    check[i] = true;
                    q.add(new Integer[]{i, c[1] + 1});
                }
            }
        }
        if (q.isEmpty()) return 0;

        return q.peek()[1];
    }

    public static int compChar(String a, String b) {
        int ans = 0;
        int i = 0;
        while (i < a.length()) {
            if (a.charAt(i) != b.charAt(i)) ans++;
            i++;
        }
        return ans;
    }
}
