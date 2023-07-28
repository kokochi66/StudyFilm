package src.Main.트리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 크루스칼_최소신장트리 {
    static BufferedReader Read = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter Write = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;

    public static void main(String[] args) throws Exception {
        int[][] a = {
                {-1, 67, -1, 28, 17, -1, 12},
                {67, -1, -1, 24, 62, -1, -1},
                {-1, -1, -1, -1, 20, 37, -1},
                {28, 24, -1, -1, -1, -1, 13},
                {17, 62, 20, -1, -1, 45, 73},
                {-1, -1, 37, -1, 45, -1, -1},
                {12, -1, -1, 13, 73, -1, -1}
        };
        Kruskal2(a);
    }

    public static int getp(int[] p, int x) {
        if (p[x] == x) return x;
        return p[x] = getp(p, p[x]);
    }

    public static void unip(int[] p, int a, int b) {
        a = getp(p, a);

        b = getp(p, b);
        if (a < b) p[b] = a;
        else p[a] = b;
    }

    public static boolean finp(int[] p, int a, int b) {
        a = getp(p, a);
        b = getp(p, b);
        return a == b;
    }

    public static int[][] Kruskal2(int[][] w) throws Exception {
        //클래스를 이용한 구현
        int n = w.length;
        int[][] output = new int[n][n];
        ArrayList<Edge> edgs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (w[i][j] != -1) {
                    edgs.add(new Edge(i, j, w[i][j]));
                }
            }
        }
        Collections.sort(edgs);

        int len = 0, max = 0;
        // 총 길이를 저장하는 len
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int i = 0; i < edgs.size(); i++) {
            if (!finp(parent, edgs.get(i).Node[0], edgs.get(i).Node[1])) {
                unip(parent, edgs.get(i).Node[0], edgs.get(i).Node[1]);
                len += edgs.get(i).distance;
                output[edgs.get(i).Node[0]][edgs.get(i).Node[1]] = edgs.get(i).distance;
                // output[edgs.get(i).Node[1]][edgs.get(i).Node[0]] = edgs.get(i).distance; 양방향 정보가 필요한 경우
                max++;
            }
            if (max == n - 1) break;
            else if (i == edgs.size() - 1 && max < n - 1) {
                System.out.println("Error :: The Graph is can't connect");
                return output;
            }
        }
        // for(int i=0;i<n;i++) System.out.println(Arrays.toString(output[i]));         테스트 출력
        return output;
    }

    public static class Edge implements Comparable<Edge> {
        int[] Node = new int[2];
        int distance;

        public Edge(int n1, int n2, int dis) {
            this.Node[0] = n1;
            this.Node[1] = n2;
            this.distance = dis;
        }

        @Override
        public int compareTo(Edge e) {
            return this.distance < e.distance ? -1 : 1;
        }

    }


    public static int[][] Kruskal(int[][] w) throws Exception {
        // 배열을 이용한 구현
        int n = w.length;
        int[][] output = new int[n][n];
        int[][] sorted = new int[(n * (n - 1)) / 2][3];
        int[] p = new int[n];
        int k = 0;
        for (int i = 0; i < n; i++) p[i] = i;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (w[i][j] != -1) {
                    sorted[k][0] = i;
                    sorted[k][1] = j;
                    sorted[k++][2] = w[i][j];
                }
            }
        }
        int[] temp = new int[3];
        for (int i = 1; i < k; i++) {
            int c = i, root;
            do {
                root = (c - 1) / 2;
                if (sorted[root][2] < sorted[c][2]) {
                    temp = sorted[root];
                    sorted[root] = sorted[c];
                    sorted[c] = temp;
                }
                c = root;
            } while (c != 0);
        }

        for (int i = k - 1; i >= 0; i--) {
            temp = sorted[0];
            sorted[0] = sorted[i];
            sorted[i] = temp;
            int c = 0, next;
            do {
                next = (c * 2) + 1;
                if (next + 1 < i && sorted[next + 1][2] > sorted[next][2]) next++;
                if (next < i && sorted[next][2] > sorted[c][2]) {
                    temp = sorted[next];
                    sorted[next] = sorted[c];
                    sorted[c] = temp;
                }
                c = next;
            } while (c < i);
        }
        int max = 0, len = 0;
        for (int i = 0; i < k; i++) {
            if (!finp(p, sorted[i][0], sorted[i][1])) {
                max++;
                unip(p, sorted[i][0], sorted[i][1]);
                output[sorted[i][0]][sorted[i][1]] = sorted[i][2];
                // output[sorted[i][1]][sorted[i][0]] = sorted[i][2];
                len += sorted[i][2];
            }
            if (max == k - 1) break;
        }
        for (int i = 0; i < n; i++) System.out.println(Arrays.toString(output[i]));
        // System.out.println(k);
        return output;
    }
}
