package Y2021.M05.D01;
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
		tok = new  StringTokenizer(rd.readLine());  
		int a = Integer.parseInt(tok.nextToken());
		int b = Integer.parseInt(tok.nextToken());
		while(a != 0 && b != 0) {
			
			wr.write((a%b)==0 ? "multiple" : b%a == 0 ? "factor" : "neither");
			wr.newLine();
			tok = new  StringTokenizer(rd.readLine());  
			a = Integer.parseInt(tok.nextToken());
			b = Integer.parseInt(tok.nextToken());
		}
		wr.flush();
	}
}