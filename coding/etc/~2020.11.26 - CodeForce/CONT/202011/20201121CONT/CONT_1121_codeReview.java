import java.io.*;
import java.util.*;
public class CONT_1121_codeReview {
    public static void main(String[] args) throws Exception{
        sol1();
    }

    public static void sol1() throws Exception{
        // 1번문제 :: 최소로 나누는 회수 출력하기.
        // 모든 짝수는 2->1 로 이어지기 때문에 2번으로 갈 수 있다.
        // 3을 제외한 모든 홀수는 -1 후, 2->1로 이어지기 때문에 3번으로 갈 수 있다.
        // 즉, 2 = 1, 3 = 2 이기 때문에 이 두 수는 n-1로 1에 도달한다.
        // 나머지 수는 n&1을 한 수, 즉, 홀수면 1, 짝수면 0이 나오는 수에 2를 더하면 위의 값이 된다.
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++)
        {
            int n = sc.nextInt();
            System.out.println(Math.min(2 + (n & 1), n - 1));
        }
    }
    public static void sol2() throws Exception {
        // 2번문제 :: 주어진 문자열에서 원하는 부분 문자열이 연속하지 않게 존재하는지를 확인
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine());
        for(int cases = 0; cases < t; cases++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            String s = br.readLine();
            // 문자열 s에 주어지는 문자열을 저장한다.
            int fi[] = new int[2];
            int la[] = new int[2];
            for(int j = 0; j < 2; j++)
            {
                fi[j] = 2000000000;
                la[j] = -1;
            }
            // 카운팅할 배열 fi와 la를 초기화한다.
            for(int i = 0; i < s.length(); i++)
            {
                int cur = (s.charAt(i) - '0');
                fi[cur] = Math.min(fi[cur], i);
                la[cur] = i;
            }
            // 각 문자열 0과 1을 돌면서, 각 fi와 la를 채워나간다.
            // 여기서 채워나가는 방식은 다음과 같다.
            // fi[cur] (현재 값)은, i와 fi[cur]의 최소값으로 선택한다.
            // 즉, 0이나 1 둘 중 가장 맨 앞에 있는 값의 위치를 파악한다.
            // la는 0과 1의 위치중 가장 뒤의 있는 값으 위치를 파악한다.
            for(int i = 0; i < q; i++)
            {
				st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken()) - 1;
                int r = Integer.parseInt(st.nextToken()) - 1;
                // 각 문자열의 substring의 위치를 입력받는다.
                int curl = (s.charAt(l) - '0');
                int curr = (s.charAt(r) - '0');
                // 맨 처음값과 맨 뒤의 값의 일치여부를 확인한다.
                if(fi[curl] < l || la[curr] > r)
                    System.out.println("YES\n");
                else
                    System.out.println("NO\n");
                // 위와같이 판단할 수 있는 근거는 다음과 같다.
                // curl값, 즉 left값이 0인지 1인지를 확인한 후, 해당 값의 첫번째 위치를 파악한다.
                // 이 첫번째 위치가 입력된 left위치보다 앞에있다면 subsequence는 성립할 수 있다.
                // 왜냐면 첫번째 위치가 하나라도 앞으로 땡겨졌으면, 그건 연속적이지 않은 subsequence가 된다.
                // last값도 마찬가지로 이가 적용된다.
            }
        }
    }
    public static void sol3() throws Exception {
        // 3번문제 :: a 문자열을 스와핑/증가 시켜서 b로 만들 수 있는지를 출력하는 문제.
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int cases = 0; cases < t; cases++)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine();
            String a = sc.nextLine();
            String b = sc.nextLine();
            // a와 b를 입력받는다.
            int have[] = new int[27];
            int need[] = new int[27];
            for(int i = 0; i < n; i++)
            {
                have[a.charAt(i) - 'a']++;
                need[b.charAt(i) - 'a']++;
            }
            // 각 문자열의 알파벳 개수를 센다.
            boolean bad = false;
            for(int j = 25; j >= 0; j--)
            {
                have[j] += have[j + 1];
                need[j] += need[j + 1];
                if(have[j] > need[j] || (need[j] - have[j]) % k != 0)
                    bad = true;
            }
            // 각 문자열의 끝에서부터, 각 끝자리 값을 더해가면서 다음 체크사항을 확인한다.
            // 먼저, 첫번째 문자열이 가진 끝에서부터의 알파벳 개수가, b가 가진 개수보다 많으면 안된다.
            // 만약 a의 z가 b의 z보다 많으면, a는 b로 변환할 수 없다.
            // 또, b의 문자열 개수 - a의 문자열 개수가 k로 나누어떨어져야한다.
            // 만약 a의 z는 2개, b의 z는 3개였을 때, a는 1개의 z를 더 필요로 하는데,
            // k가 1보다 크다면, 이전의 알파벳을 아무리 올려도 z로는 올릴 수 없다.
            if(bad)
                System.out.println("No");
            else
                System.out.println("Yes");
        }
    }

}
