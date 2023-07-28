package src.Y2021.M11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class main1112 {
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
        int[][] data1 = {
                {-20, -15},
                {-14, -5},
                {-18, -13},
                {-5, -3}
        };

        int[][] data2 = {
                {0, 2},
                {2, 3},
                {3, 4},
                {4, 6}
        };
        System.out.println(solution(data1));
    }

    public static int solution(int[][] routes) {
        int answer = 0;
//        List<Car> carsLeft = new ArrayList<>();
        Car[] carsArr = new Car[routes.length];
        for (int i = 0; i < routes.length; i++) {
//            carsLeft.add(new Car(routes[i][0], routes[i][1]));
            carsArr[i] = new Car(routes[i][0], routes[i][1]);
        }
        Arrays.sort(carsArr, (a, b) -> {
            return a.left - b.left;
        });
//        Collections.sort(carsLeft, (a,b) -> {
//            return a.left - b.left;
//        });

        int[] arr = new int[100];
        int iz = arr.length / 2;
        int leftListIndex = -1;
        int leftListMin = 1000000;
        for (int i = 0; i < arr.length; i++) {
//            System.out.println("TEST :: " + i+" "+map.containsKey(i));

            for (int j = leftListIndex + 1; j < carsArr.length; j++) {
                Car car = carsArr[j];
                if (car.left + iz <= i) {
//                    System.out.println("left :: " + (car.left+iz)+" "+(car.right+iz) +" "+i);
                    if (leftListMin > (car.right + iz)) leftListMin = car.right + iz;
                    leftListIndex = j;
                } else break;
            }
            if (leftListMin == i) {
//                System.out.println(i+" "+leftListIndex);
                answer++;
                leftListMin = 1000000;
            }
        }

        return answer;
    }

    static class Car {
        int left;
        int right;

        public Car(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }


    public static int solution2(int n, int[][] costs) throws Exception {
        int answer = 0;
        int INF = 1000000000;

        int[][] grp = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(grp[i], INF);
        for (int i = 0; i < costs.length; i++) {
            grp[costs[i][0]][costs[i][1]] = costs[i][2];
            grp[costs[i][1]][costs[i][0]] = costs[i][2];
        }
//        for (int[] grps : grp) {
//            System.out.println(Arrays.toString(grps));
//        }

        return Prim(grp, 0);
    }

    static int INF = 1000000000;

    public static int Prim(int[][] arr, int root) throws Exception {
        PriorityQueue<TreeNode> pq = new PriorityQueue<TreeNode>();
        int n = arr.length;
        int sum = 0;
        boolean[] chk = new boolean[n];
        chk[root] = true;
        for (int i = 0; i < n; i++) {
            if (arr[root][i] < INF) pq.add(new TreeNode(root, i, arr[root][i]));
        }
        while (!pq.isEmpty()) {
            TreeNode tc = pq.poll();
            if (chk[tc.end]) continue;
            sum += tc.weight;
            chk[tc.end] = true;
            for (int i = 0; i < n; i++) {
                if (arr[tc.end][i] < INF && !chk[i]) pq.add(new TreeNode(tc.end, i, arr[tc.end][i]));
            }
        }
        return sum;
    }

    static class TreeNode implements Comparable<TreeNode> {
        int start, end, weight;

        public TreeNode(int s, int e, int w) {
            this.start = s;
            this.end = e;
            this.weight = w;
        }

        @Override
        public int compareTo(TreeNode o) {
            // TODO Auto-generated method stub
            return Integer.compare(this.weight, o.weight);
        }

    }

    public static int[] solution1(String[] operations) throws Exception {
        // 프로그래머스 https://programmers.co.kr/learn/courses/30/lessons/42628 이중우선순위 큐
        // I (숫자) :: 큐에 주어진 숫자를 삽입
        // D 1 :: 최댓값 삭제
        // D -1 :: 최솟값 삭제
        // 계속 정렬해주는 리스트로 구현

        ArrayList<Integer> list = new ArrayList<>();
        for (String operation : operations) {
            tok = new StringTokenizer(operation);
            String oper = tok.nextToken();
            int number = Integer.parseInt(tok.nextToken());
            if (oper.equals("I")) {
                list.add(number);
                Collections.sort(list);
            } else if (number == 1 && list.size() > 0) {
                list.remove(list.size() - 1);
            } else if (number == -1 && list.size() > 0) {
                list.remove(0);
            }
        }
        int[] res = new int[2];
        res[0] = list.size() > 0 ? list.get(list.size() - 1) : 0;
        res[1] = list.size() > 0 ? list.get(0) : 0;

        return res;
    }
}
