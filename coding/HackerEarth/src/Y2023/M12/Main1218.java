package Y2023.M12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1218 {

    public static void main(String[] args) throws Exception {
        solution();
    }

    // 아름다운 문자열
    // https://www.hackerearth.com/practice/algorithms/sorting/quick-sort/practice-problems/algorithm/beautiful-strings-10/


    /*
    * 문자열 안에서 a, b, c의 개수가 모두 같다면 이 문자열은 아름답다고 한다.
    * (문자열이 모두 없을수도, 다른 문자열이 들어있을수도 있다.)
    *
    * 문자열엔 오직 소문자 문자열만 포함된다.
    * 주어진 문자열에서 비지 않은 아름다운 문자열의 substring 개수를 출력해야한다.
    * 문자열 길이 < 100000
    *
    * */
    static class Pair implements Comparable<Pair> {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.first != o.first) {
                return this.first - o.first;
            } else {
                return this.second - o.second;
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair pair = (Pair) obj;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();  // Consume the newline character
        while (t-- > 0) {
            String s = sc.nextLine();
            int n = s.length();
            Pair[] a = new Pair[n + 1];
            a[0] = new Pair(0, 0);
            for (int i = 0; i < n; i++) {
                int first = a[i].first;
                int second = a[i].second;
                if (s.charAt(i) == 'a') {
                    first--;
                    second--;
                } else if (s.charAt(i) == 'b') {
                    first++;
                } else if (s.charAt(i) == 'c') {
                    second++;
                }
                a[i + 1] = new Pair(first, second);
            }

            Arrays.sort(a);
            long ans = 0;
            long c = 1;
            for (int i = 1; i <= n; i++) {
                if (a[i].equals(a[i - 1])) {
                    c++;
                } else {
                    ans += (c * (c - 1)) / 2;
                    c = 1;
                }
            }
            ans += (c * (c - 1)) / 2;
            System.out.println(ans);
        }
    }


}
