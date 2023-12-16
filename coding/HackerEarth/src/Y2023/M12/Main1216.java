package Y2023.M12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1216 {

    public static void main(String[] args) throws Exception {
        solution();
    }

    // 시퀀스의 특수성
    // https://www.hackerearth.com/practice/algorithms/sorting/quick-sort/practice-problems/algorithm/lex-finds-beauty-0d0bc1b6/

    /*
    * 시퀀스 A가 주어진다. (길이는 n) 그리고 숫자 k가 주엊니다.
    * A[l] 에서 연속된 부분 배열에서 A[l]보다 큰 숫자가 k개 이상 있을 때 이 A[l]은 특별하다고 한다.
    * 배열의 특별함의 수치는 이 특별한 수의 합이다. 이 특별한 수를 구해야 한다.
    *
    * 그냥 정렬해서 k번째부터 합을 구하면 될듯?
    * */
    public static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
//        System.out.println(n +" " + k);

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
//        System.out.println(Arrays.toString(list.toArray()));

        long sum = 0L;
        list.sort((a,b) -> b - a);
        for (int i=k;i<list.size();i++) {
            sum += list.get(i);
        }
        System.out.println(sum);
    }

    // 누르와 그의 연못
    // https://www.hackerearth.com/practice/algorithms/sorting/quick-sort/practice-problems/algorithm/noor-and-his-pond-760eabe0/

    /*
    * 누르는 어부이다.
    * N 타입의 물고기들이 있다.
    * 각각의 타입은 size(S)와 eating factor(E)를 갖고있다.
    * eating factor E의 물고기는 size가 E보다 작은 모든 종류의 물고기를 먹는다.
    * 누르를 도와서 물고기들이 서로 먹지 않는 최대 Set을 만들자.
    *
    * 입력
    * T : 테스트 케이스
    * N : 물고기 타입의 수
    * S, E : size와 eating factor (S > E)
    * E를 기준으로 정렬 했을 때, E가 더 작은 물고기는 E가 더 큰 물고기를 절대로 먹을수가 없음 (S > E 이기 때문에)
    * 즉, E가 1인 물고기가 먹을 수 있는 물고기의 개수보다 무조건 E가 2인 물고기가 먹을 수 있는 물고기 개수가 더 같거나 많음을 보장함
    * 각 E 별로 먹을 수 있는 물고기 개수를 계산함 (e binarySearch로 계산가능)
    * E가 큰 순번부터 내려가면서 다음을 계산함.
    * 1. 해당 물고기가 포함되었을 때의 물고기 개수를 계산한다. (전체 물고기 - 먹는 물고기)
    * 2. 해당 물고기보다 E가 큰 물고기를 전부 제외하고, 해당 물고기가 먹는 물고기 개수를 구한다
    * 3. 계산한 물고기 개수 중 가장 큰 것을 출력한다.
     */
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCase = Integer.parseInt(br.readLine());
//        System.out.println(pp);

        for (int i=0;i<testCase;i++) {
            int n = Integer.parseInt(br.readLine());

            List<Fish> fishList = new ArrayList<>();
            for (int j=0;j<n;j++) {
                StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(stringTokenizer.nextToken());
                int e = Integer.parseInt(stringTokenizer.nextToken());
                fishList.add(new Fish(s, e));
            }

            List<Integer> sList = new ArrayList<>();
            for (Fish fish : fishList) {
                sList.add(fish.s);
            }

            sList.sort(Comparator.comparingInt(a -> a));
            for (Fish fish : fishList) {
                int sIndex = Collections.binarySearch(sList, fish.e);
                while (sIndex > 0 && sList.get(sIndex + 1) == fish.e) {
                    sIndex++;
                }

                fish.wc =
                        sIndex >= 0 ? sIndex + 1
                        : (sIndex * (-1)) - 1;
            }

            fishList.sort((a,b) -> b.e - a.e);
            long maxFishCount = 0;
            for (int j=0;j<fishList.size();j++) {
                Fish fish = fishList.get(j);
                int fishCount = n - j - fish.wc;
//                System.out.println("j = " + j + " / fish = " + fish.s + " " + fish.e + " / wc = " + fish.wc +" / fc = " + fishCount);
                if (maxFishCount < fishCount) {
                    maxFishCount = fishCount;
                }
            }
            System.out.println(maxFishCount);
        }
    }
    public static class Fish {
        public int s;
        public int e;
        public int wc;

        public Fish(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    // (4,1) , (5,4) ,(7,3)
    // S : 4 5 7
    //
    // E : 1 3 4
}
