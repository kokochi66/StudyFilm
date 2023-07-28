package Y2021.M03.D30;
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
			long[] arrx = new long[n];
			long[] arry = new long[n];
			for(int i=0;i<n;i++) {
				tok = new StringTokenizer(rd.readLine());
				arrx[i] = Long.parseLong(tok.nextToken());
				arry[i] = Long.parseLong(tok.nextToken());
			}
//			System.out.println(Arrays.toString(arrx));
//			System.out.println(Arrays.toString(arry));
			Arrays.sort(arrx);
			Arrays.sort(arry);
			if(n%2==0) {
				long sizex = Math.abs((arrx[(n/2)-1]) - (arrx[n/2])) + 1;
				long sizey = Math.abs((arry[(n/2)-1]) - (arry[n/2])) + 1;
				System.out.println(sizex * sizey);
			} else {
				System.out.println(1);
			}
		}
	}
}