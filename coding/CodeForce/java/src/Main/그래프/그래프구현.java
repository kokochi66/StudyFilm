package src.Main.그래프;

import java.util.ArrayList;

public class 그래프구현 {

    public static int 부모가져오기(int[] p, int x) {
        if (p[x] == x) return x;
        return p[x] = 부모가져오기(p, p[x]);
    }

    public static void 부모합치기(int[] p, int a, int b) {
        a = 부모가져오기(p, a);
        b = 부모가져오기(p, b);
        if (a < b) p[b] = a;
        else p[a] = b;
    }

    public static boolean 부모찾기(int[] p, int a, int b) {
        a = 부모가져오기(p, a);
        b = 부모가져오기(p, b);
        return a == b;
    }

    static class 에지 implements Comparable<에지> {
        int next;
        int weight;

        public 에지(int n, int w) {
            this.next = n;
            this.weight = w;
        }

        @Override
        public int compareTo(에지 ed) {
            return this.weight - ed.weight;
        }
    }

    static class 그래프 {
        public ArrayList<ArrayList<Integer[]>> gr;

        public 그래프(int size) {
            gr = new ArrayList<ArrayList<Integer[]>>();
            for (int i = 0; i < size; i++) {
                gr.add(new ArrayList<Integer[]>());
            }
        }

        public void 단방향에지추가(int a, int b, int weight) {
            gr.get(a - 1).add(new Integer[]{b - 1, weight});
        }

        public void 양방향에지추가(int a, int b, int weight) {
            gr.get(a - 1).add(new Integer[]{b - 1, weight});
            gr.get(b - 1).add(new Integer[]{a - 1, weight});
        }

        public void 노드출력() {
            for (int i = 0; i < gr.size(); i++) {
                System.out.print((i + 1) + "번째노드 :: ");
                System.out.print("[ ");
                for (int j = 0; j < gr.get(i).size(); j++) {
                    System.out.print("(" + (gr.get(i).get(j)[0] + 1) + "," + gr.get(i).get(j)[1] + ") ");
                }
                System.out.println("]");
            }
        }

        public ArrayList<ArrayList<Integer[]>> getGraph() {
            return gr;
        }

        public ArrayList<Integer[]> getNode(int a) {
            return gr.get(a - 1);
        }
    }


    static class NW그래프 {
        public ArrayList<ArrayList<Integer>> gr;

        public NW그래프(int size) {
            gr = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < size; i++) {
                gr.add(new ArrayList<Integer>());
            }
        }

        public void 단방향에지추가(int a, int b) {
            gr.get(a).add(b);
        }

        public void 양방향에지추가(int a, int b) {
            gr.get(a).add(b);
            gr.get(b).add(a);
        }

        public void 노드출력() {
            for (int i = 0; i < gr.size(); i++) {
                System.out.print((i) + "번째노드 :: ");
                System.out.print("[ ");
                for (int j = 0; j < gr.get(i).size(); j++) {
                    System.out.print("(" + (gr.get(i).get(j)) + ") ");
                }
                System.out.println("]");
            }
        }

        public ArrayList<ArrayList<Integer>> getGraph() {
            return gr;
        }

        public ArrayList<Integer> getNode(int a) {
            return gr.get(a);
        }

        public int size() {
            return gr.size();
        }
    }
}
