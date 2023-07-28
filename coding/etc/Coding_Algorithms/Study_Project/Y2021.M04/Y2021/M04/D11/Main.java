package Y2021.M04.D11;
import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		solution2();
	}
	
	static int mods = 1000000007;
	static int[] fact;
	public static void solution2() throws Exception {
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			int n = Integer.parseInt(rd.readLine());
			tok = new StringTokenizer(rd.readLine());
			ArrayList<Integer> list = new ArrayList<Integer>();
			sol2_init(); // 20¸¸
			for(int i=0;i<n;i++) list.add(Integer.parseInt(tok.nextToken())); // n
			Collections.sort(list); // n Log n
			int min = list.get(0), mincount = 1;
			int oper = min & list.get(1);
			boolean pass = true; 
			
			for(int i = 1;i<n;i++) {
				if(oper != (min & list.get(i))) {
					pass=  false;
					break;
				}
				if(min == list.get(i)) mincount++;
			} // n(20¸¸)
			
			if(pass && mincount >= 2) {
				wr.write((sol2_pre(mincount , 2) * fact[n-2])+"");
			} else {
				wr.write("0");
			}
			wr.newLine();
		}
		wr.flush();
	}
	
	public static int sol2_pre(int n, int r) {
		if(r > n) return 1;
		return (fact[n] / fact[n-r]) % mods;
	}
	
	public static void sol2_init() {
		fact = new int[200001];
		fact[0] = 1;
		fact[1] = 1;
		for(int i=2;i<=200000;i++) fact[i] = (i * fact[i-1])%mods;
	}
	
	public static void solution() throws Exception {
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			tok = new StringTokenizer(rd.readLine());
			int n = Integer.parseInt(tok.nextToken());
			int k = Integer.parseInt(tok.nextToken());
			int[] arr = new int[n];
			if( n >= (2 * k) + 1  ) {
				int max = n;
				for(int i=0;i<k;i++) arr[(i*2)+1] = max--;
				for(int i=0;i<n;i++) if(arr[i] == 0) arr[i] = max--;
				for(int i=0;i<n;i++) wr.write(arr[i]+" ");
			} else { 
				wr.write("-1");
			}
			wr.newLine();
		}
		wr.flush();
	}
}