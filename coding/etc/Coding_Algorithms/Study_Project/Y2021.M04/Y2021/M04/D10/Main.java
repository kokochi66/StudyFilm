package Y2021.M04.D10;
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
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			tok = new StringTokenizer(rd.readLine());
			long n = Long.parseLong(tok.nextToken());
			long a = Long.parseLong(tok.nextToken());
			long b = Long.parseLong(tok.nextToken());
			long c = Long.parseLong(tok.nextToken());
			if(a < n) {
				long cs = n / a;
				if(n % a !=0 ) cs++;
				a = cs*a;
			}
			if(b < n) {
				long cs = n / b;
				if(n % b !=0 ) cs++;
				b = cs*b;
			}
			if(c < n) {
				long cs = n / c;
				if(n % c !=0 ) cs++;
				c = cs*c;
			}
			System.out.println(Math.min(a-n, Math.min(b-n, c-n)));
		}
	}
}