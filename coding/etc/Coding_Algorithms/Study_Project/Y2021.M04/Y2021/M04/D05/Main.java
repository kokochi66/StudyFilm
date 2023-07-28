package Y2021.M04.D05;
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
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=(n-i);j++) wr.write(" ");
			for(int j=1;j<=(2*(i-1))+1;j++) {
				if(i>1 && i<n && j>1 && j< (2*(i-1))+1) wr.write(" ");
				else wr.write("*");
			}
			wr.newLine();
		}
		wr.flush();
	}
}