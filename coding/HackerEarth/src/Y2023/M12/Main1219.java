package Y2023.M12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1219 {

    public static void main(String[] args) throws Exception {
        solution();
    }

    // 크리켓 토너먼트
    // https://www.hackerearth.com/practice/algorithms/sorting/quick-sort/practice-problems/algorithm/chef-and-chefa-a5c8800a/


    /*
    *   Bob과 Jame와 n번의 매치가 이루어진다.
    *   A,B 배열이 주어진다. A배열은 밥의 에너지레벨, B배열은 제임스의 에너지 레벨이다.
    *   두 배열의 크기는 n으로 같다.
    *
    *   n번의 매치가 밥과 제임스 사이에 플레이되고, i번째 에너지 레벨을 서로 비교한다.
    * i번째 매치에서는 에너지가 더 큰사람이 해당 매치의 승리자가 된다.
    * 밥이 i번쨰 매치를 이기면 에너지 레벨의 차이만큼 점수에 더해진다. 패배한다고 해서 점수가 감소되지는 않는다.
    * 밥은 그의 점수가 최대가 되도록 그의 에너지 레벨을 변경하고 싶다. 밥은 그의 배열을 재배치할 수 있다.
    * 할수 있는 최대의 점수를 출력하라.
    * */

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
//        System.out.println(pp);

        List<En> aList = new ArrayList<>();
        List<En> bList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            aList.add(new En(Integer.parseInt(st.nextToken()), i));
            bList.add(new En(Integer.parseInt(st2.nextToken()), i));
        }

        aList.sort((a,b) -> b.val - a.val);
        bList.sort((a,b) -> a.val - b.val);
        long pointSum = 0;
        for (int i=0;i<n;i++) {
            pointSum += Math.max(aList.get(i).val - bList.get(i).val, 0);
        }
        System.out.println(pointSum);

//        System.out.println(Arrays.toString(aList.toArray()));
//        System.out.println(Arrays.toString(bList.toArray()));
    }

    public static class En {
        public int val;
        public int idx;

        public En(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }


}
