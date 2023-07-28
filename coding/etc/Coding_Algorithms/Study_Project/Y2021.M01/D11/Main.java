package Y2021.M1.D11;
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
			tok = new StringTokenizer(rd.readLine());
			long n = Long.parseLong(tok.nextToken());
			long x = Long.parseLong(tok.nextToken());
			long[] arr = new long[(int)n];
			long[] temp = new long[(int)n];
			long sum = 0;
			tok = new StringTokenizer(rd.readLine());
			for(int i=0;i<n;i++) {
				arr[i] = Long.parseLong(tok.nextToken());
				sum += arr[i];
				temp[i] = arr[i];
			}
			boolean pass = false;
			int index = 0;
			while(!pass) {
				if(temp[index] % x == 0) {
					sum += arr[index];
					temp[index] = temp[index]/x;
				}
				else pass = true;
				index = index+1 < n ? index+1 : 0;
			}
			wr.write(sum+"");
			wr.newLine();
		}
		wr.flush();
	}
	public static void solution() throws Exception {
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			tok = new StringTokenizer(rd.readLine());
			int n = Integer.parseInt(tok.nextToken());
			int x = Integer.parseInt(tok.nextToken());
			tok = new StringTokenizer(rd.readLine());
			long sum = 0;
			long sum2 = 0;
			for(int i=0;i<n;i++) {
				int c = Integer.parseInt(tok.nextToken());
				sum += (long)Math.ceil(c/(double)x);
				sum2 += c;
			}
			wr.write((long)Math.ceil(sum2 / (double)x)+" "+sum);
			wr.newLine();
		}
		wr.flush();
		
	}
}