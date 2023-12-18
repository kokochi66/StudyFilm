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
    * 10만이면 n^n은 안되고 무조건 n log n으로 풀어야함.
    *
    * 일단 비지 않아야 하고, a,b,c의 개수가 모두 같아야하니 최소 개수를 3개부터 시작함.
    *
    * 처음 3개의 문자열 이었을 때의 아름다운 문자열의 개수 => 4개였을떄의 아름다운 문자열의 개수 이렇게 구하면 될듯.
    * 여기서 n만큼 반복하므로, 아름다운 문자열의 개수를 구하는 방법을 log n으로 해야함.
    *
    * log n => binarySearch
    * abacbcba
    *
    * 일단 3개짜리 문자열들을 찾음
    * 문자열의 끝 인덱스를 저장함.
    * 내가 또 찾았는데 그 앞 인덱스도 아름다운 문자였으면 그 개수만큼 + 1
    * 찾는 과정
    * 일단 1개씩 찾아 queue에 나옴. (각각 a,b,c 중 뭐뭐가 나왔는지만 저장하고 있음)
    * 동일한 문자가 나오면 해당 문자가 나올때까지 queue에서 뱉고, 해당 문자를 다시 넣음.
    * 아름다운 문자가 완성되면 하나를 뱉음
    *
    *
    * abacbc : 6개를 다 봐야만 개수가 같은지 알 수 있음
    * abbbaaaaaaabbbbbaabbaaabbcccccccccccccccccc 일수도 있음
    * 즉, 동일한 문자가 여러개가 나왔다고 해서 절대 끊기지 않음.
    * => 아름다운 문자열이 완성되었을 때 뱉어도 되긴 하는데, 완전히 새로운 문자열인지 늘 확인해줘야함.
    *
    * */
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TT = Integer.parseInt(br.readLine());

        for (int PP = 0; PP < TT; PP++) {
            char[] arr = br.readLine().toCharArray();

            Queue<Character> q = new LinkedList<>();
            boolean[] bArr = new boolean[3];
            // 0이 a, 1이 b, 2가 c
            int[] bsCount = new int[arr.length];

            for (int i=0;i<arr.length;i++) {
                char c = arr[i];

                q.add(c);
                int idx = c == 'a' ? 0 : c == 'b' ? 1 : c == 'c' ? 2 : 3;

                if (idx == 3) {
                    q.clear();
                    continue;
                }

                if (bArr[idx]) {
                    q.poll();
                }
                bArr[idx] = true;

                if (bArr[0] && bArr[1] && bArr[2]) {
                    Character cq = q.poll();
                    int qIdx = cq == 'a' ? 0 : cq == 'b' ? 1 : cq == 'c' ? 2 : 3;
                    bArr[qIdx] = false;
                    bsCount[i]++;
                    if (i > 2 && bsCount[i - 3] > 0) {
                        bsCount[i] += bsCount[i - 3];
                    }
                }
                System.out.println(c +" / " + Arrays.toString(bsCount) + " :: " + Arrays.toString(bArr));
            }

            long sum = 0;
            for (int i =0; i<arr.length;i++) {
                sum += bsCount[i];
            }
            System.out.println(sum);

        }
    }


}
