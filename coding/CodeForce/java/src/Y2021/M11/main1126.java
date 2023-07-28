package src.Y2021.M11;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class main1126 {
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
//        System.out.println(Arrays.toString(solution(6,6,new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}})));

    }

    public static String[] solution(String[] orders, int[] course) {
        // 메뉴 리뉴얼 -> 주문시 ㄱ자ㅏㅇ 많이 함께 주문한 단품 메뉴로 코스 메뉴르ㅜㄹ 구성
        // 최소 2가지 이상으 ㅣ단품메뉴, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 후보로
        // 단품메뉴는 A~Z 알파벳 대문자 표기
        // 새로 추가하게 될 코스메뉴 요리의 구성을 문자열 형태로
        HashMap<Character, ArrayList<String>> map = new HashMap<>();
        char c = 'A';
        while(c != 'Z') map.put(c, new ArrayList<>());
        // 맵 초기화

        for(int i=0;i< orders.length;i++) {
            char[] arr = orders[i].toCharArray();
            for(int j=0;j<arr.length;j++) {
                ArrayList<String> list = map.get(arr[j]);
                list.add(orders[i]);
            }
        }

        String[] answer = {};
        return answer;
    }

    public static StringBuilder bfs(char[] arr, int n, boolean[] check, StringBuilder c) {
        if(c.length() >= n) return c;
        for(int i=0;i<arr.length;i++) {
            if(!check[i]) {
                c.append(arr[i]);
                check[i] = true;

            }
        }
        return null;
    }

    public static int[] solution2(int rows, int columns, int[][] queries) {
        int[][] pan = new int[rows][columns];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                pan[i][j] = (i*columns) + (j+1);
            }
        }
//        for(int i=0;i<rows;i++) System.out.println(Arrays.toString(pan[i]));
        // 선언부

        int[] res = new int[queries.length];

        for(int q=0;q<queries.length;q++) {
            int x1 = queries[q][0]-1;
            int y1 = queries[q][1]-1;
            int x2 = queries[q][2]-1;
            int y2 = queries[q][3]-1;

            int fin = pan[x1][y1];
            int min = fin;

            for(int i=x1;i<x2;i++) {
                pan[i][y1] = pan[i+1][y1];
                if(pan[i][y1] < min) min = pan[i][y1];
            }
            for(int i=y1;i<y2;i++) {
                pan[x2][i] = pan[x2][i+1];
                if( pan[x2][i] < min) min = pan[x2][i];
            }
            for(int i=x2;i>x1;i--) {
                pan[i][y2] = pan[i-1][y2];
                if(pan[i][y2] < min) min = pan[i][y2];
            }
            for(int i=y2;i>y1;i--) {
                pan[x1][i] = pan[x1][i-1];
                if( pan[x1][i] < min) min = pan[x1][i];
            }
            pan[x1][y1+1] = fin;

//            for(int i=0;i<rows;i++) System.out.println(Arrays.toString(pan[i]));
            res[q] = min;
        }

        return res;
    }
}
