package src.Y2022.M11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class main1106 {
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;

    public static void main(String[] args) throws Exception {
//        solution();

        int[] a = {1, 3, 9, 22 , 23};
        int b = -5;
        int[] arr = new int[a.length + 1];
        for(int i=0;i<a.length;i++) {
            arr[i] = a[i];
        }
        arr[arr.length - 1] = b;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void solution() throws Exception {
        // A < B , 양의 정수
        // 집합 S에 속하면 안됨
        // n을 포함하는 좋은 구간의 개수
        int l = Integer.parseInt(rd.readLine());        // 1 <= L <= 50
        tok = new StringTokenizer(rd.readLine());
        int[] arr = new int[l];     // 중복 없음, 1 <= x <= 1000
        for (int i = 0; i < l; i++) {
            arr[i] = Integer.parseInt(tok.nextToken());
        }
        int n = Integer.parseInt(rd.readLine());    // 1 <= n <= 1000

//        System.out.println(l);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(n);

        // n보다 적은 수 + n보다 큰 수
        // 2,3 2,4 2,5 ,2,6
        // 9,10 9,11 9,12 10,11 10,12

        Arrays.sort(arr);
        int sw = Arrays.binarySearch(arr, n);
        // n보다 적은 수의 위치를 찾음. 없으면 1
        // n보다 큰 수의 위치를 찾음 (없을 수 없음)
        // n과 같은 수가 있다면, 0을 출력
        if (sw >= 0) {
            System.out.println(0);
        } else {
            // -1 이면 left = 1, right = arr[0]
            // -2 이면 left = arr[0], right = arr[1]
            // -3 이면 left = arr[1], right = arr[2]
            int left = sw == -1 ? 1 : arr[(sw * -1) - 2] + 1;
            int right = arr[(sw * -1) - 1] - 1;
//            System.out.println(sw);
//            System.out.println("left = " +left);
//            System.out.println("right = " +right);
            int a = right - n + 1;
            int b = n - left;
            int c = right - n;
            int sum = (a * b) + c;
//            System.out.println("a = " + a);
//            System.out.println("b = " + b);
//            System.out.println("c = " + c);
            System.out.println(sum);
        }
    }

}
