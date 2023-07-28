package Y2021.M10.D19;
import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;
    public static void main(String[] args) throws Exception {
        solution();
    }
    public static void solution() throws Exception {
        /*  https://codeforces.com/contest/1586/problem/A :: Windblumne Ode
        *  나는 Windblume Ode라고 불리는 활을 얻었다. 활에는 n(n>=3) 인 서로 다른 양의 정수 배열이 새겨져있다.
        *  해당 배열의 부분집합 중에서 합이 합성수(소수가 아닌 수)가 되는 배열 중 가장 많은 요소를 갖고있는 부분을 찾아야한다.
        *   양의 합성수는 다음과 같은 경우에 성립한다.
        * 양의 정수 y에서 1 < y < x 이며, y로 나누어떨어지는 x가 존재할 경우 x를 합성수라고 한다.
        * 만약 여러개의 합성수 부분집합이 존재한다면, 그 중 아무 값이나 출력해도 된다. 문제에는 항상 부분집합이 존재함을 보장한다.
        * */
        int TestCase = Integer.parseInt(rd.readLine());
        for(int TT=0;TT<TestCase;TT++) {
            tok = new StringTokenizer(rd.readLine());
            int n = Integer.parseInt(tok.nextToken());
            tok = new StringTokenizer(rd.readLine());
            int[] arr = new int[n];
            for(int i=0;i<n;i++) {
                arr[i] = Integer.parseInt(tok.nextToken());
            }
            // 입력 테스트
            // System.out.println(Arrays.toString(arr));

            // 2를 제외한 모든 짝수가 합성수임.
            // 1. 모든 수를 더한 수가 합성수인지를 확인함, 합성수이면 출력
            // 2. 합성수가 아니라면, (무조건 홀수임) => 홀수가 존재한다면 홀수 한개를 제외하고 출력
            // 3. 모두 짝수일수는 없음 (모두 짝수라면 합도 짝수여야함)

            int sum = 0;
            String res = "";
            for(int temp : arr) sum += temp;
            boolean checkIsCom = false;
            for(int i=2;i<= (int)Math.sqrt(sum);i++)  {
                if(sum % i == 0) {
                    checkIsCom = true;
                    break;
                }
            }
            if(!checkIsCom) {
                // 소수라면 홀수를 찾아서 결과에서 제외함.
                boolean check = false;
                for(int i=0;i<n;i++) {
                    if(arr[i] % 2 != 0 && !check) {
                        check = true;
                    } else res += (i+1)+" ";
                }
                wr.write((n-1)+"");
                wr.newLine();
                wr.write(res);
            } else {
                for(int i=0;i<n;i++) res += (i+1)+" ";
                wr.write(n+"");
                wr.newLine();
                wr.write(res);
            }
            wr.newLine();
        }
        wr.flush();
        wr.close();
    }
}