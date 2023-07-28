package src.Y2022.M11;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class main1115 {
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        // s(n) 을 문자열 "BAN"을 n번 출력하는 함수로 정의한다.
        // s(n)의 길이는 3n이 된다.

        // s(n)에 다음 연산을 몇번이고 수행할 수 있다.
        // 1. 두개의 인덱스 i,j를 선택한다 (1 <= i, j <= 3n, i!=j)
        // 2. s(n)[i] 와 s(n)[j]를 스왑한다.

        // 너는 문자열에서 BAN이 하위 시퀀스 내에 표시되지 않기를 바란다.
        // 위 연산을 최소 몇번 수행해야 하는지를 구하라.


        // 출력 : 몇번 수행해야 하는 지 구한 뒤, 각 i와 j를 출력한다.
        int TT = Integer.parseInt(rd.readLine());
        for (int TS = 0; TS < TT; TS++) {
            int n = Integer.parseInt(rd.readLine());

            int cnt = 0;
            // 한번의 연산으로 최대 2개까지만 BAN을 망가뜨릴 수 있으며, 모든 BAN은 최소 한번은 망가져야만 한다. (subsequence로 없어야 하기 때문)
            // 여러가지 방법이 있을 수 있으나, 모든 맨 앞의 B를 모든 B보다 뒤에있는 N과 교환하는 형태로 구현한다.

            List<Integer[]> op = new ArrayList<>();
            boolean[] check = new boolean[n * 3]; // 해당 위치가 이미 교환되었는지를 체크, 이미 교환되었으면 모두 옮기기에 완료한 것임.

            int i = 0; // i는 앞에서 부터 들어감.
            int j = (n * 3) - 1; // j는 뒤에서부터 내려옴

            // i % 3 == 0 이면서 !check[i] 이면 i번째는 B가 됨.
            // j $ 3 == 2 이면서 !check[j] 이면 j번째는 N이 됨.
            // 두 값을 서로 교환해줌.
            // 이를 i < j 인 동안 반복함.

            while (i < j) {
//                System.out.println("i, j = " + i +" " + j);
                if (i % 3 != 0 || check[i]) i++;
                else if (j % 3 != 2 || check[j]) j--;
                else {
//                    System.out.println("op " + i +" " + j);
                    op.add(new Integer[]{(i+1), (j+1)});
                    cnt++;
                    check[i] = true;
                    check[j] = true;
                    i++;
                    j--;
                }

            }
            System.out.println(cnt);
            for (Integer[] ops : op) {
                System.out.println((ops[0]) +" " + (ops[1]));
            }
        }
    }


}
