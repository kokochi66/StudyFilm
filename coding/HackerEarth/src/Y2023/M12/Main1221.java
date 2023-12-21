package Y2023.M12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main1221 {

    public static void main(String[] args) throws Exception {
        solution();
    }

    // 최대 파워
    // https://www.hackerearth.com/practice/algorithms/sorting/quick-sort/practice-problems/algorithm/chef-and-chefa-a5c8800a/


    /*
    *  N개의 서로 다른 정수가 배열 A에 존재한다.
    * 배열의 파워는 다음과 같다 (max (a[i] - a[j]) 2<= i <= N
    * 반복하면서 i는 j보다 작은 가장 큰 인덱스입니다.
    * 만약 딱 2개만 서로 위치를 바꿀 수 있을 때, 가장 큰 Power를 계산해야한다. (최대 1번이므로, 이미 최대라면 바꾸지 않아도 됨)
    *
    * 배열 내에서 가장 큰 값과 가장 낮은 값이 순서대로 놓여지는 경우의 수를 구하면 될듯.
    * 가장 큰 값과 낮은값이 순서대로 놓여지는 경우가 없는경우 => (4, 3, 2) 와 같이 가장 낮은 값이 가장 마지막 배열에 있다면 서로 위치를 못바꾸니 끝에있는 값은 제외 해야할듯
    * */

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer TT = Integer.parseInt(br.readLine());
//        System.out.println(pp);

        for (int PP=0;PP<TT;PP++) {

            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int maxIdx = -1;
            int minIdx = -1;
            for (int i=0;i < n;i++){
                list.add(Integer.parseInt(st.nextToken()));
                if (list.get(i) > max) {
                    max = list.get(i);
                    maxIdx = i;
                }

                if (list.get(i) < min) {
                    min = list.get(i);
                    minIdx = i;
                }
            }

            if (n == 2 || Math.abs(maxIdx - minIdx) == 1) {
                System.out.println(max - min);
            } else if (maxIdx == 0) {
                if (minIdx == n - 1){
                    list.remove(0);
                    list.remove(list.size() - 1);
                    int sideMax = list.stream().max(Comparator.comparing(a -> a)).get();
                    int sideMin = list.stream().min(Comparator.comparing(a -> a)).get();
                    System.out.println(Math.max(max - sideMin, sideMax - min));
                } else {
                    list.remove(list.size() - 1);
                    System.out.println(max - list.stream().min(Comparator.comparing(a -> a)).get());
                }
            } else if (minIdx == n - 1) {
                list.remove(0);
                System.out.println(list.stream().max(Comparator.comparing(a -> a)).get() - min);
            } else {
                System.out.println(list.stream().max(Comparator.comparing(a -> a)).get() - list.stream().min(Comparator.comparing(a -> a)).get());
            }

        }
    }


}
