package Y2021.M03.D015;
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
		int n = Integer.parseInt(rd.readLine());
		int m = Integer.parseInt(rd.readLine());
		boolean[] broken = new boolean[10];
		if(m>0) {
			tok = new StringTokenizer(rd.readLine());
			for(int i=0;i<m;i++) {
				int c = Integer.parseInt(tok.nextToken());
				broken[c] = true;
			}
		}
		
		
		int min = Math.abs(100-n);
		int number = 100;
		// 초기값 100으로 설정, 초기값에서 해당 번호로 +,-로 이동하는 값을 기초 최소값으로 설정함.
		
		for(int i=0;i<=1000000;i++) {
			if(sol_check(i,broken)) {
				int sub = sol_sub(i,n);
				if(sub < min) {
					min = sub;
					number = i;
				}
			}
		}	// 50만까지 가는 수를 알아야 하기 때문에 2배수인 100만까지 모든 수 중에 가장 짧은값을 찾아냄.
		// 연산은 100만 * 체크(10) * 차이값연산(1) 로 약 1000만연산이됨.
		System.out.println(min);
	}
	public static boolean sol_check(int n, boolean[] brk) {
		if(n == 0) return !brk[0];
		while(n>0) {
			if(brk[n%10]) return false;
			n/=10;
		}
		return true;
	}
	public static int sol_sub(int a, int n) {
		return Math.abs(n-a) + String.valueOf(a).length();			// 입력값에서 목표 번호로 가는 차잇값을 출력함
	}
}