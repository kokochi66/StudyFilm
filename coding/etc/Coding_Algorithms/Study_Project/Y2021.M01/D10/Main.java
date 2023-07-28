package Y2021.M1.D10;
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
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			int n = Integer.parseInt(rd.readLine());
			tok = new StringTokenizer(rd.readLine());
			ArrayList<Integer> even = new ArrayList<Integer>();
			ArrayList<Integer> odd = new ArrayList<Integer>();
			for(int i=0;i<n;i++) {
				int c = Integer.parseInt(tok.nextToken());
				if(c%2==0) even.add(c);
				else odd.add(c);
			}
			Collections.sort(even);
			Collections.sort(odd);
			long alice = 0, bob = 0;
			int size = n;
			while(!even.isEmpty() || !odd.isEmpty()) {
				if(size > 0) {
					int eMax = even.size() > 0 ? even.get(even.size()-1) : 0;
					int oMax = odd.size() > 0 ? odd.get(odd.size()-1) : 0;
					if(eMax > oMax) { 
						alice += eMax;
						even.remove(even.size()-1);
					}
					else  odd.remove(odd.size()-1);
					size--;
				}
				if(size > 0) {
					int eMax = even.size() > 0 ? even.get(even.size()-1) : 0;
					int oMax = odd.size() > 0 ? odd.get(odd.size()-1) : 0;
					if(eMax > oMax) even.remove(even.size()-1);
					else  {
						bob += oMax;
						odd.remove(odd.size()-1);
					}
					size--;
				}
			}
			if(alice > bob) wr.write("Alice");
			else if(alice == bob) wr.write("Tie");
			else if(alice < bob) wr.write("Bob");
			wr.newLine();
			wr.write(alice +" " + bob);
			wr.newLine();
		}
		wr.flush();
	}
	public static void solution() throws Exception {
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			int n = Integer.parseInt(rd.readLine());
			int[] arr = new int[n+1];
			long[] dp = new long[n+1];
			tok = new StringTokenizer(rd.readLine());
			for(int i=1;i<=n;i++) {
				arr[i] = Integer.parseInt(tok.nextToken());
				dp[i] = arr[i];
			}
			for(int i=n;i>=1;i--) {
				long offset = i + dp[i];
				if(offset <= n) dp[i] += dp[(int)offset];
			}
//			System.out.println(Arrays.toString(dp));
			System.out.println(Arrays.stream(dp).max().getAsLong());
		}
	}
}