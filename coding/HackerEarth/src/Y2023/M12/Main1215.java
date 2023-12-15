package Y2023.M12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1215 {


    public static void main(String[] args) throws Exception {
        solution();
    }

    // 정렬 알고리즘 학습

    // Quick Sort 문제

    // 1. 사과 먹기
    // https://www.hackerearth.com/practice/algorithms/sorting/quick-sort/practice-problems/algorithm/snake-b0112afa/
    public static void solution() throws IOException {
        // (1,1) 부터 (10^9 , 10^9) 까지 존재하는 행렬에 위치
        // 동일한 줄에 사과가 있다면 어느쪽 한 끝으로 갈 수 있다 (순서를 높은 순으로 할 지 낮은 순으로 할 지를 결정하라는 거인듯?
        // 일단 줄이 하나씩 올라가니까 앞에꺼 우선으로 정렬, 그 다음엔 뒤에꺼 우선으로 정렬하는 식이면 되는듯.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer pp = Integer.parseInt(br.readLine());
//        System.out.println(pp);

        List<Mat> list = new ArrayList<>();
        for (int i=0;i<pp;i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            int x = Integer.parseInt(stringTokenizer.nextToken());
//            System.out.println(x +" " + y);

            list.add(new Mat(x, y, i));
        }
        list.sort(Comparator.comparingInt(a -> a.y));
        // y 기준으로 1차 정렬

        int index = 0;
        int currRow = list.get(index).y;
        boolean leftStart = true;
        List<Mat> resList = new ArrayList<>();
        while (index < list.size()) {
            List<Mat> temp = new ArrayList<>();

            while(index < list.size() && list.get(index).y == currRow) {
                temp.add(list.get(index));
                index++;
            }

            if (temp.size() > 0) {
                final boolean finalLeftStart = leftStart;
                temp.sort((a,b) -> {
                    return finalLeftStart ? a.x - b.x : b.x - a.x;
                });
                resList.addAll(temp);
            }

            if (index < list.size()) {
                currRow = list.get(index).y;
                leftStart = !leftStart;
            }
        }

        // y 우선 정렬, 그 다음 x를 우선으로 정렬한다.
        int[] res = new int[pp];

        // 정렬한 순서를 담는다. (사과를 먹은 순서)
        for (int i=0;i<resList.size();i++) {
            res[resList.get(i).order] = i;
        }

        for (int re : res) {
            System.out.println(re);
        }
    }

    public static class Mat {
        public int x;
        public int y;
        public int order;

        public Mat(int x, int y, int order) {
            this.x = x;
            this.y = y;
            this.order  = order;
        }
    }

}
