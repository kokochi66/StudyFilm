package src.Main.탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 벨만포드_최단경로 {

    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;

    public static void main(String[] args) throws Exception {
        int v = Integer.parseInt(rd.readLine());
        int e = Integer.parseInt(rd.readLine());
        Bellman bel = new Bellman(v);
        for (int i = 0; i < e; i++) {
            tok = new StringTokenizer(rd.readLine());
            int a = Integer.parseInt(tok.nextToken()) - 1;
            int b = Integer.parseInt(tok.nextToken()) - 1;
            int w = Integer.parseInt(tok.nextToken());
            bel.putSingleEdge(a, b, w);
        }
        bel.rot(1);
        System.out.println(Arrays.toString(bel.res));
    }

    static class Bellman {
        int[] res;
        List<Edge>[] grp;
        final int INF = 1000000000;

        static class Edge {
            int v, w;

            public Edge(int v, int w) {
                this.v = v;
                this.w = w;
            }
        }

        public Bellman(int n) {
            res = new int[n];
            grp = new ArrayList[n];
            for (int i = 0; i < n; i++) grp[i] = new ArrayList<>();
        }

        public void putEdge(int a, int b, int w) {
            grp[a].add(new Edge(b, w));
            grp[b].add(new Edge(a, w));
        }

        public void putSingleEdge(int a, int b, int w) {
            grp[a].add(new Edge(b, w));
        }

        public boolean rot(int start) {
            boolean up = false;
            for (int i = 0; i < res.length; i++) {
                res[i] = INF;
            }
            res[start] = 0;
            for (int cnt = 1; cnt < res.length; cnt++) {
                up = false;
                for (int i = 0; i < res.length; i++) {
                    for (Edge adj : grp[i]) {
                        if (res[i] != INF && res[i] + adj.w < res[adj.v]) {
                            res[adj.v] = res[i] + adj.w;
                            up = true;
                        }
                    }
                }
                if (!up) break;
            }
            if (up) return false;
            return true;
        }


    }
}
