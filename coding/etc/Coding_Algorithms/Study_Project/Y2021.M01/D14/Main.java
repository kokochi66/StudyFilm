package Y2021.M1.D14;
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
			int n = Integer.parseInt(tok.nextToken());
			int m = Integer.parseInt(tok.nextToken());
			tok = new StringTokenizer(rd.readLine());
			int[] fri = new int[n];
			int[] pre = new int[m];
			for(int i=0;i<n;i++) {
				fri[i] = Integer.parseInt(tok.nextToken());
			}
			tok = new StringTokenizer(rd.readLine());
			for(int i=0;i<m;i++) {
				pre[i] = Integer.parseInt(tok.nextToken());
			}
			// insert
			
			for(int i=0;i<n;i++) {
				fri[i] = pre[fri[i]-1];
			}
			Arrays.sort(fri);
			Arrays.sort(pre);
			
			int pIndex = 0, fIndex = n-1;
			while(fIndex >= 0 && pIndex < m && (pre[pIndex] < fri[fIndex]) ) {
				fri[fIndex] = pre[pIndex];
				pIndex++;
				fIndex--;
			}
			
			long sum = 0;
			for(int i=0;i<n;i++) sum += fri[i];
			wr.write(sum+"");
			wr.newLine();
		}
		wr.flush();
	}
}