package Y2023.M12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main1217 {

    public static void main(String[] args) throws Exception {
        solution();
    }

    // One-sized 게임
    // https://www.hackerearth.com/practice/algorithms/sorting/quick-sort/practice-problems/algorithm/one-sized-game/

    /*
     * n개의 정수가 주어진다.
     * 가장 낮은 수를 찾는다. (여러개라면 index가 가장 낮은것을 선택한다.)
     * 해당 index 만큼 전체 배열에서 빼준다.
     * 음수가 되는 값이 있으면 배열에서 제거한다. (실제 배열에서 제거가 된 것이기 때문에 이 뒤의 index는 하나씩 땡겨진다.)
     * 반복하면서 배열에 1개의 값만 남았으면 Ladia의 승리, 아니면 Kushagra의 승리다.
     *
     * 풀이 :
     * index랑 값을 넣고 값을 우선, 그 다음은 index가 낮은 순으로 정렬한다.
     * minus 되는 값을 관리하고, 해당 값이 음수가 되면 다음 index로 넘어간다.
     * 이를 반복하면서 정확하게 하나의 값만 남았으면 Ladia, 배열의 모든 값이 음수가 되었으면 Kushagra를 출력한다.
     *
     * 인덱스가 줄어드는것을 실시간으로 어떻게 반영할 것인가?
     * 삭제된 인덱스들을 넣어주고 정렬하기? => 값이 다 다르면 만번 반복해야되어서 안됨
     *
     * */

    static int[] bit;
    static final int MAX = 200005;

    static void upd(int x, int val) {
        // 펜윅 트리를 이용한 값 계산
        // 1번째 인덱스인경우, 1 2 4 8 16 32 64 128 256 ...
        // 2번째 인덱스인경우, 2 4 8 16 32 64 128 256...
        // 3번째 => 3 4 8 16 32 64 128 256 ...
        // 4 => 4 8 16 32 64 128 256 ...
        // 5 => 5 8 16 32 64 128 256 ...
        while (x < MAX){
            bit[x] += val;
            x += x & (-x);
        }
    }

    static int query(int x) {
        // 펜윅트리를 이용해서 겹치는 모든 데이터의 합을 구한다.
        // 모든 값을 더하는게 아니라, 2의 제곱수에 있는 겹치는 값만을 모두 더하는 형태이기 때문에 log n 만큼의 연산만을 사용한다.
        int sum = 0;
        while (x > 0) {
            sum += bit[x];
            x -= x & (-x);
        }
        return sum;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TT = Integer.parseInt(br.readLine());

        for (int PP = 0; PP < TT; PP++) {
            int n = Integer.parseInt(br.readLine());
            boolean ladiaWin = false;

            List<Ob> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                Ob ob = new Ob(Integer.parseInt(st.nextToken()), i + 1);
                list.add(ob);
            }

            bit = new int[MAX];

            list.sort((a,b) -> a.val - b.val);

            long minusAmount = 0;
            for (int i = 0; i < n; i++) {
                Ob ob = list.get(i);

                if (ob.val - minusAmount < 0) {
                    upd(ob.idx, 1);
                    continue;
                } else {
                    if (i == n -1) {
                        ladiaWin = true;
                        break;
                    }

                    long rem = ob.val - minusAmount;
                    int idx = ob.idx - query(ob.idx);
                    long mul = rem / idx;
                    mul ++;
                    minusAmount += mul * idx;
                    upd(ob.idx, 1);
                }
            }
            if (ladiaWin) {
                System.out.println("Ladia");
            } else {
                System.out.println("Kushagra");
            }
        }
    }


    /*
     * 작은 값 순으로 정렬을 해
     *
     *
     * */
    public static class Ob {
        public int val;
        public int idx;

        public Ob(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}
