package Y2021.M1.D26;
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
		long[][] arr = new long[35][35];
		for(int i=1;i<=30;i++) {
			arr[1][i] = i;
			arr[i][i] = 1;
		}
		for(int i=2;i<=30;i++) {
			for(int j=i+1;j<=30;j++) {
				arr[i][j] = arr[i-1][j-1] + arr[i][j-1];
			}
		}
		for(int TT=0;TT<TestCase;TT++) {
			tok = new StringTokenizer(rd.readLine());
			int n = Integer.parseInt(tok.nextToken());
			int m = Integer.parseInt(tok.nextToken());
			wr.write(arr[n][m]+"");
			wr.newLine();
		}
		wr.flush();
	}
}