package Y2021.M10.D01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    // 코드포스 https://codeforces.com/contest/1580/problem/A 문제
    // A.Portal
    public static void main(String[] args) throws Exception {
        solutionA();
    }

    public static void solutionA() throws Exception {
        /*
        * CQXYM은 n x m 크기의 직사각형을 찾을 수 있다.
        * 세로 n, 가로 m의블럭이 있다. 각 블럭은 차있거나, 비어있다.
        * CQXYM은 차있는 블럭을 비게 만들거나, 비어있는 블럭을 차게 만들 수 있다. 이에는 한번의 연산이 든다.
        * 다음 조건에 맞는 a x b 크기의 직사각형 M을 portal이라고 부른다.
        * a >= 5, b >= 4
        * 1 < x < a 인 모든 x에 대해 M(x,1), M(x,b)는 차있는 블럭이다.
        * 1 < x < b 인 모든 x에 대해 M(1,x), M(a,x)는 차있는 블럭이다.
        * 1< x < a, 1 < y < b 인 모든 x,y에 대해 M(x,y)는 비어있는 블럭이다.
        * M(1,1), M(1,b) M(a,1), M(a,b)는 어떤 형태여도 된다.
        * CQXYM은 최소연산으로 최소한 한개의 작은 portal을 만들고 싶다. 최소연산 수를 구하라.
        * n <= 400, m <= 400
        * */

        /* 풀이 ::
        * 각 위치를 세제곱으로 탐색, 각 위치를 기점으로 모든 5 * 4 이상의 직사각형에서 portal에 필요한 연산수를 계산하여 출력한다.
        * */
        int TestCase = Integer.parseInt(rd.readLine());
        for(int TT=0;TT<TestCase;TT++) {
            tok = new StringTokenizer(rd.readLine());
            int n = Integer.parseInt(tok.nextToken());
            int m = Integer.parseInt(tok.nextToken());

            char[][] arr = new char[n][m];
            for(int i=0;i<n;i++) {
                arr[i] = rd.readLine().toCharArray();
            }
            // 입력부

            for(int i=0;i<n-5;i++) {
                for(int j=0;j<m-4;j++) {
                    for(int k=5;k<n;k++) {
                        for(int l=4;l<m;l++) {
                            // i=1, j=1 k = a, l = b



                        }
                    }
                }
            }

        }
    }

}
