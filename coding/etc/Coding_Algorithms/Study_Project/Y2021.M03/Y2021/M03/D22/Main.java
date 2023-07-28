package Y2021.M03.D22;
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
			int n = Integer.parseInt(tok.nextToken());
			int k = Integer.parseInt(tok.nextToken());
			int a  = n;
			int b = 1;
			
			if(n%2 == 0) {
				b = ((k-1)%n)+1;
			} else {
				if(k != 1) {
					b = ((k-1) + ((k-1)/((n-1)/2)))%n + 1;
				}
			}
			wr.write(b+"");
			wr.newLine();
		}
		wr.flush();
	}
	
	public static void solution() throws Exception {
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			int n = Integer.parseInt(rd.readLine());
			tok = new StringTokenizer(rd.readLine());
			int[] arr = new int[n];
			for(int i=0;i<n;i++) arr[i] = Integer.parseInt(tok.nextToken());
			
			int min = 500;
			int minNum = 0;
			for(int i=0;i<n;i++) {
				if(arr[i] < min) {
					min = arr[i];
					minNum = 1;
				} else if(arr[i] == min) minNum++;
			}
			System.out.println(n-minNum);
 		}
	}
}