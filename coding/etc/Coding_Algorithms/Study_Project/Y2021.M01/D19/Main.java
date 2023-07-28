package Y2021.M1.D19;
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
			HashMap<Integer, Integer> hm = new HashMap<>();
			int[] arr = new int[n];
			tok = new StringTokenizer(rd.readLine());
			for(int i=0;i<n;i++) {
				int ai = Integer.parseInt(tok.nextToken());
				for(int j=2;j*j<=ai;j++) {
					while(ai%(j*j)==0) ai/=j*j;
				}
				hm.put(ai, hm.getOrDefault(ai, 0)+1);
			}
			int res1=0, res2=0;
			for(int x:hm.keySet()) {
				res1 = Math.max(res1, hm.get(x));
				if(hm.get(x)%2==0 || x == 1) res2 += hm.get(x);
			}
			res2 = Math.max(res1,res2);
			
			int q = Integer.parseInt(rd.readLine());
			for(int i=0;i<q;i++) {
				long w = Long.parseLong(rd.readLine());
				if(w==0) wr.write(res1+"");
				else wr.write(res2+"");
				wr.newLine();
			}
			wr.flush();
		}
	}
}