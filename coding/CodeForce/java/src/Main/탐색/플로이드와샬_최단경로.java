package src.Main.탐색;

import java.util.Arrays;

public class 플로이드와샬_최단경로 {
    final static int INF = 1000000000;

    public static void main(String[] args) {
        int[][] a = {
                {0, 5, INF, 8},
                {7, 0, 9, INF},
                {2, INF, 0, 4},
                {INF, INF, 3, 0}
        };
        int[][] res = Floyd_Washall(a);
        for (int i = 0; i < res.length; i++) System.out.println(Arrays.toString(res[i]));
    }

    public static int[][] Floyd_Washall(int[][] arr) {
        int n = arr.length;
        int[][] output = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                output[i][j] = arr[i][j];
            }
        }
        // 초반 그래프 초기화 ( n^2 )

        for (int i = 0; i < n; i++) {
            // 거쳐가는 노드 설정
            for (int j = 0; j < n; j++) {
                // 출발노드 설정
                for (int k = 0; k < n; k++) {
                    // 도착노드 설정
                    if (output[i][j] > output[i][k] + output[k][j]) {
                        output[i][j] = output[i][k] + output[k][j];
                    }
                }
            }
        }
        // 플루이드 와샬 반복 ( n^3 )

        //총 시간복잡도 n^2 + n^3
        return output;
    }
}
