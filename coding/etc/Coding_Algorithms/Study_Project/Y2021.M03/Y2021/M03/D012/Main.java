package Y2021.M03.D012;
import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		solution2();
	}
	public static void solution2() throws Exception {
		tok = new StringTokenizer(rd.readLine());
		int n = Integer.parseInt(tok.nextToken());
		int k = Integer.parseInt(tok.nextToken());
		long[][] dp = new long[n+1][k+1];
		// n수를 k개로 만드는 경우의 수는
		// n-1을 k개로 만드는 수 + n을 k-1개로 만드는 수 와 동일하게 되므로 동적 프로그래밍을 이용할 수 있다.
		for(int i=0;i<=n;i++) {
			for(int j=1;j<=k;j++) {
				if(i==0 || j == 1) dp[i][j] = 1;
				else {
					dp[i][j] = (dp[i-1][j] + dp[i][j-1])%1000000000;
				}
			}
		}
//		for(int i=0;i<=n;i++) System.out.println(Arrays.toString(dp[i]));
		System.out.println(dp[n][k]);
		
	}
	public static void solution() throws Exception {
		tok = new StringTokenizer(rd.readLine());
		int a = Integer.parseInt(tok.nextToken());
		int b = Integer.parseInt(tok.nextToken());
		int c = Integer.parseInt(tok.nextToken());
		int res = a;
		System.out.println(sol_pow(a,b,c)%c);
	}
	public static long sol_pow(long a, long b, long c) {
		if(b == 0) return 1;		// 제곱수가 0이라면 1을 반환
		else if(b == 1) return a;		// 제곱수가 1이라면 a를 그대로 반환
		else if(b%2 != 0) return (sol_pow(a,b-1,c)*a)%c;
		// 제곱수가 홀수라면 반으로 나눌 수 없으므로 -1 후, a를 별도로 곱해줌.
		long half = sol_pow(a,b/2,c)%c;
		// 분할정복 풀이, 제곱을 양쪽으로 나누어 곱한 뒤, 해당 값들을 따로 곱해주는 과정을 거침.
		// O(n Log n)으로 풀이 가능하며, 해당 값들을 각각 c로 나머지연산 해줌 
		return (half * half) % c;
		// 최종 분할된 값들을 합쳐서 출력함.
	}
}