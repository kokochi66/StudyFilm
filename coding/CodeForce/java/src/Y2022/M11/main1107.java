package src.Y2022.M11;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class main1107 {
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        int n = Integer.parseInt(rd.readLine());
        int[] arr = new int[n];

        for (int TS = 0; TS < n; TS++) {
            arr[TS] = Integer.parseInt(rd.readLine());
        }
        Arrays.sort(arr);

//         1. 음수는 음수끼리 작은 값부터 곱한다.
//         2. 음수끼리 더이상 곱할 게없다면 0과 곱한다.
//         3. 0도 없다면 음수는 곱하지 않는다.
//         4. 양수는 양수끼리 큰 값부터 곱한다.
//         5. 1은 곱하지 않는다.

        // 0 2 2 3 4 5

        int sum = 0;
        for(int i=0;i<n;i++) {
            if(i+1 < n) {
                if (arr[i] < 0 && arr[i+1] < 0) {   // 음수 - 다음 음수
                    sum += arr[i] * arr[i+1];
                    i++;
                } else if (arr[i] < 0 && arr[i+1] == 0) {       // 음수 - 다음 0
                    i++;
                } else if (arr[i] < 0 && arr[i+1] > 0) {        // 음수 - 다음 양수
                    sum += arr[i];
                } else if (arr[i] > 0) {        // 양수 - 양수
                    if (arr[i] == 1) {
                        sum += arr[i];
                    } else if ((n - i - 1) % 2 == 0) {
                        sum += arr[i];
                    } else {
                        sum += arr[i] * arr[i+1];
                        i++;
                    }
                }
            } else {
                sum += arr[i];
            }
        }
        System.out.println(sum);



    }

}
