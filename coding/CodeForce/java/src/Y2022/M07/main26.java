package src.Y2022.M07;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class main26 {
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;

    public static void main(String[] args) throws Exception {
        solution();
        // a b c d e f g h j
    }

    public static void solution() throws Exception {
        int n = Integer.parseInt(rd.readLine());

        int[] parent = new int[n];
        int root = -2;
        tok = new StringTokenizer(rd.readLine());
        for (int TS = 0; TS < n; TS++) {
            parent[TS] = Integer.parseInt(tok.nextToken());
            if (parent[TS] == -1) root = TS;
        }

        int m = Integer.parseInt(rd.readLine());

//        System.out.println("N = " + n);
//        System.out.println("M = " + M);

        // 1번 내가 자식이 있는지 없는지를 계산하는 배열 필요
        // 2번 삭제했을때, 해당 노드의 자식을 전부 무효화하도록 체크

        deleteNodeStack(m, parent, n);

        int[] childCountArr = new int[n];
        for (int i = 0; i < n; i++) {
            if (parent[i] >= 0) {
                childCountArr[parent[i]]++;
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (childCountArr[i] == 0 && parent[i] != -2) {
                res++;
            }
        }

//        System.out.println("treeArr = " + Arrays.toString(treeArr));
//        System.out.println("childCountArr = " + Arrays.toString(childCountArr));
        System.out.println(res);
    }

    public static void deleteNode(int d, int[] treeArr, int n) {
        treeArr[d] = -2; //삭제된 노드 -2로 표시
        for (int i = 0; i < n; i++) {
            if (treeArr[i] == d) {
                deleteNode(i, treeArr, n);
            }
        }
    }

    public static void deleteNodeStack(int d, int[] parent, int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(d);
        // d라는 애를 지울거에요
        while (!stack.isEmpty()) {
            // 스택이 더이상 없을때까지
            Integer curr = stack.pop();
            // 지울 노드

            parent[curr] = -2;
            // 지워줍니다.

            for (int i = 0; i < n; i++) {
                // 모든 노드들을 탐색합니다.
                if (parent[i] == curr) {
                    // 그 노드의 부모가 curr이었으면
                    stack.push(i);
                    // 스택에 넣어줍니다.
                }
            }
        }
    }


}
