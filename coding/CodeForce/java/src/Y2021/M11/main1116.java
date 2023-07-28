package src.Y2021.M11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class main1116 {
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
        String[][] data1 = {
                {"ICN", "AOO"},
                {"AOO", "BOO"},
                {"BOO", "COO"},
                {"COO", "DOO"},
                {"DOO", "EOO"},
                {"EOO", "DOO"},
                {"DOO", "COO"},
                {"COO", "BOO"},
                {"BOO", "AOO"},
        };

        String[][] data2 = {
                {"A", "B"},
                {"A", "C"},
                {"A", "D"},
                {"B", "Z"},
                {"H", "G"}
        };
        System.out.println(Arrays.toString(solution(data1)));
    }

    public static String[] solution(String[][] tickets) {
/*        Arrays.sort(tickets, (a, b) -> {
           return a[0].compareTo(b[0]) == 0 ? a[1].compareTo(b[1]) : a[0].compareTo(b[0]);
        });*/
        HashSet<String> set = new HashSet<>();
        ArrayList<String> ticList = new ArrayList<>();
        for (String[] ticket : tickets) {
            for (String s : ticket) {
                if (!set.contains(s)) {
                    ticList.add(s);
                    set.add(s);
                }
            }
        }
        Collections.sort(ticList);

        HashMap<String, Integer> map = new HashMap<>();
        int rootIndex = 0;
        for (int i = 0; i < ticList.size(); i++) {
            map.put(ticList.get(i), i);
            if (ticList.get(i).equals("ICN")) rootIndex = i;
        }
/*        for (String s : ticList) {
            System.out.print(s+" "+map.get(s)+" ");
        }
        System.out.println();*/


        int n = ticList.size();
        int[][] road = new int[n][n];
        for (String[] ticket : tickets) {
            road[map.get(ticket[0])][map.get(ticket[1])]++;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(road[i]));
        }
        int[] res = new int[tickets.length + 1];
        String[] resStr = new String[tickets.length + 1];
        res[0] = rootIndex;
        if (DFS(road, rootIndex, 1, res)) {
//            System.out.println(Arrays.toString(res));
            for (int i = 0; i < res.length; i++) {
                resStr[i] = ticList.get(res[i]);
            }
        }
        return resStr;
    }

    public static boolean DFS(int[][] edge, int ci, int count, int[] res) {
        if (count == res.length) return true;
/*        System.out.println(ci+" "+count);
        for (boolean[] booleans : edge) {
            System.out.println(Arrays.toString(booleans));
        }
        System.out.println("================");*/
        int n = edge.length;
        for (int i = 0; i < n; i++) {
            if (edge[ci][i] > 0) {
                edge[ci][i]--;
                res[count] = i;
                if (DFS(edge, i, count + 1, res)) return true;
                edge[ci][i]++;
            }
        }
        return false;
    }
}
