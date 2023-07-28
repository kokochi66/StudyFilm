package Y2021.M03.D27;
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
		
		long[] cubes = new long[10000+1];
		for(int i=1;i<=10000;i++) cubes[i] = powthr(i);
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			boolean pass = false;
			long n = Long.parseLong(rd.readLine());
			int index = Arrays.binarySearch(cubes, n);
			if(index < 0) {
				index = -index-2;
				for(int i=index;i>0;i--) {
					int ic = Arrays.binarySearch(cubes, n-cubes[i]);
					if(ic > 0) {
						System.out.println("YES");
						pass = true;
					}
					if(pass) break;
				}
			}
			if(!pass) System.out.println("NO");
		}
	}
	public static long powthr(long n) {
		return n * n * n;
	}
}