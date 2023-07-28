package Y2021.M06.D24;
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
		int[] cute = new int[2];
		for(int i=0;i<n;i++) {
			int c = Integer.parseInt(rd.readLine());
			cute[c]++;
		}
		System.out.println(cute[0] > cute[1] ? "Junhee is not cute!" : "Junhee is cute!");
	}
}