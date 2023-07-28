package Y2021.M1.D1;
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
		tok = new StringTokenizer(rd.readLine());
		int n = Integer.parseInt(tok.nextToken());
		int m = Integer.parseInt(tok.nextToken());
		int k = Integer.parseInt(tok.nextToken());
		long[] arr = new long[n+1];
		long[] dp = new long[n+1];
		for(int i=1;i<=n;i++) {
			arr[i] = Long.parseLong(rd.readLine());
		}
		boolean swap = false;
		long swLong = 0;
		int sw = 0;
		for(int i=0;i<m+k;i++) {
			tok = new StringTokenizer(rd.readLine());
			int a = Integer.parseInt(tok.nextToken());
			int b = Integer.parseInt(tok.nextToken());
			long c = Integer.parseInt(tok.nextToken());
			if(a==1) {
				sw = b;
				swLong = c;
				swap = true;
			} else {
				if(swap = true) {
					
				}
			}
		}

	}
//	public static void solution() throws Exception {
//		System.out.println("       _.-;;-._\n"
//				+ "'-..-'|   ||   |\n"
//				+ "'-..-'|_.-;;-._|\n"
//				+ "'-..-'|   ||   |\n"
//				+ "'-..-'|_.-''-._|");
//	}
//	public static void solution() throws Exception {
//		int TestCase = Integer.parseInt(rd.readLine());
//		PriorityQueue<Integer> pq = new PriorityQueue<>();
//		for(int TT=0;TT<TestCase;TT++) {
//			int n = Integer.parseInt(rd.readLine());
//			if(n == 0) {
//				if(pq.size() == 0) wr.write("0");
//				else wr.write(pq.poll()+"");
//				wr.newLine();
//			}
//			else pq.offer(n);
//		}
//		wr.flush();
//	}
//	public static void solution() throws Exception {
//		tok = new StringTokenizer(rd.readLine());
//		int n = Integer.parseInt(tok.nextToken());
//		int m = Integer.parseInt(tok.nextToken());
//		HashSet<Integer> set = new HashSet<>();
//		ArrayList<Integer> li = new ArrayList<>();
//		for(int i=0;i<n;i++) {
//			set.add(Integer.parseInt(rd.readLine()));
//		}
//		Iterator<Integer> it = set.iterator();
//		while(it.hasNext()) {
//			int c = it.next();
//			li.add(c);
//		}
//		Collections.sort(li);
//		
//		int[] dp = new int[m+10];
//		dp[0] = 0;
//		int lNext = 0;
//		for(int i=1;i<=m;i++) {
//			dp[i] = -1;
//			if(lNext < li.size() && i == li.get(lNext)) {
//				dp[i] = 1;
//				lNext++;
//			}
//			else {
//				for(int j=1;j<=i/2;j++) {
//					if(dp[i-j] != -1 && dp[j] != -1) {
//						dp[i] = dp[i] == -1 ? dp[i-j]+dp[j] : Math.min(dp[i], dp[i-j]+dp[j]);
//					}
//				}
//			}
//		}
////		System.out.println(Arrays.toString(dp) +" "+li.get(0));
//		System.out.println(dp[m]);
//		
//	}
}