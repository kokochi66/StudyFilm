package Y2021.M1.D9;
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
			int[] arr = new int[3];
			for(int i=0;i<n;i++) {
				int c = Integer.parseInt(tok.nextToken());
				if(c == 1) arr[1]++;
				else arr[2]++;
			}
			boolean pass = false;
			int one = arr[1];
			int two = (arr[2]*2);
			if((one + two)%2==0) {
				int half = (one + two)/2;
				if(two > half && one >0) pass = true;
				else if(two > half && half%2==0) pass = true;
				else if(two <= half) pass = true;
				else if(one >= half) pass = true;
			}
			if(pass) wr.write("YES");
			else wr.write("NO");
			wr.newLine();
		}
		wr.flush();
	}
	public static void solution() throws Exception {
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			tok = new StringTokenizer(rd.readLine());
			int w = Integer.parseInt(tok.nextToken());
			int h = Integer.parseInt(tok.nextToken());
			int n = Integer.parseInt(tok.nextToken());
			int wc = 1, hc = 1;
			while(w%2==0 && w>0) {
				wc*=2;
				w/=2;
			}
			while(h%2==0 && h>0) {
				hc*=2;
				h/=2;
			}
			if(wc*hc >= n) wr.write("YES");
			else wr.write("NO");
			wr.newLine();
		}
		wr.flush();
	}
}