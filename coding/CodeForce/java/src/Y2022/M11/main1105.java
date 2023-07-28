package src.Y2022.M11;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class main1105 {
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;

    public static void main(String[] args) throws Exception {
//        solution();
        int[] a = {1,3,4,5,7,9,10,12,15};
        int i = Arrays.binarySearch(a, 9);
        System.out.println(i);
    }

    public static void solution() throws Exception {
        int n = Integer.parseInt(rd.readLine());
        tok = new StringTokenizer(rd.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            list.add(Integer.parseInt(tok.nextToken()));
        }
        int m = Integer.parseInt(rd.readLine());

//        System.out.println("TEST :: n = " + n);
//        System.out.println("TEST :: arr = " + Arrays.toString(arr));
//        System.out.println("TEST :: m = " + m);

        // 입력받은 부분

        int sum = 0;
        for(int i=0;i<n;i++) {
            sum += list.get(i);
        }
//        System.out.println("TEST :: sum = " + sum);
        if (sum <= m) {
            System.out.println(list.stream().max(Integer::compareTo).get());
            // 예외처리
        } else {
            System.out.println(binarySearch(1, m, list, m));
        }

    }

    public static int binarySearch(int low, int high, List<Integer> list, int budget) {
        int mid = ((low + high) / 2);
        // 대충 아무값이나 적은 상한선
        // 1이랑 예산최대값중에 중간값으로 정해보자

        int sum = 0;
        int overMaxCount = 0;   // 상한선을 초과한 회사 개수
        for (Integer integer : list) {
            if (integer > mid) {
                sum += mid;
                overMaxCount++;
            } else {
                sum += integer;
            }
        }
        System.out.println("TEST :: sum = " + sum);
        System.out.println("TEST :: mid = " + mid);
        System.out.println("TEST :: overMaxCount = " + overMaxCount);
        System.out.println("=====================================================");
        if (sum <= budget && budget - sum < overMaxCount) {
            return mid;
        } else if (sum > budget) {
            return binarySearch(low, mid - 1, list, budget);
        } else {
            return binarySearch(mid + 1, high, list, budget);
        }
    }
    // binary log N = (n 10억 => 30)

}
