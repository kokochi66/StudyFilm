package Y2023.M12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1222 {

    public static void main(String[] args) throws Exception {
        solution();
    }

    // Mex 찾기
    // https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/find-mex-62916c25/


    /*
     *
     * n 길이의 정수 배열이 주어진다.
     * 1 <= i <= N인 i번째의 MEX를 찾아내야한다.
     * i번째의 MEX는 i번째까지 있던 모든 element를 포함하지 않는, 0보다 크거나 같은 가장 적은 정수이다.
     *
     * N은 최대 200,000 이니까 n^n은 안되고 n log n 이면 된다.
     * Set에다가 나온 수를 넣어두고
     * 현재 최소 정수를 따로 관리하면서 하나씩 증가시키다가
     * 겹치면 다음수, 겹치면 다음수 이렇게 넘어가면 될듯
     *  */

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
//        System.out.println(pp);

        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> set = new HashSet<>();
        List<Integer> ansList = new ArrayList<>();
        int min = 0;
        for (int i = 0; i < n; i++) {
            set.add(list.get(i));
            while (set.contains(min)) {
                min++;
            }
            ansList.add(min);
        }

        for (Integer ans : ansList) {
            System.out.print(ans + " ");
        }

    }


}
