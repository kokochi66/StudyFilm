package Y2021.M03.D21;
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
			int[] arr = new int[n];
			for(int i=0;i<n;i++) arr[i] = Integer.parseInt(tok.nextToken());
			
			int[] c = new int[3];
			for(int i=0;i<n;i++) c[arr[i]%3]++;
			System.out.println(sol_s(c,0,n/3));
			
			
		}
	}
	public static int sol_s(int[] c, int i, int pos) {
		if(c[i] < pos) return sol_s(c,(i+1)<3?(i+1):0,pos);
		else if(c[i] == pos) {
			for(int j=0;j<3;j++) if(c[j] != pos) return sol_s(c,(i+1)<3?(i+1):0,pos);
			return 0;
		}
		int count = c[i] - pos;
		c[(i+1)<3?(i+1):0] += count;
		c[i] = pos;
		return count + sol_s(c,(i+1)<3?(i+1):0,pos);
	}
}