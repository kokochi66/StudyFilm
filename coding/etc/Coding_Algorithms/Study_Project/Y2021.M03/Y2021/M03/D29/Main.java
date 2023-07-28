package Y2021.M03.D29;
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
			int n = Integer.parseInt(rd.readLine());
			tok = new StringTokenizer(rd.readLine());
			
			boolean pass = true;
			long[] arr = new long[n];
			arr[0] = Long.parseLong(tok.nextToken());
			for(int i=1;i<n;i++) arr[i] = arr[i-1] + Long.parseLong (tok.nextToken());
			for(int i=0;i<n;i++) {
				if(arr[i] < ((i+1)*i)/2)  {
					pass = false;
					break;
				}
			}
			if(pass) wr.write("YES");
			else wr.write("NO");
			wr.newLine();
		}
		wr.flush();
	}
}