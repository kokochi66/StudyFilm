package Y2021.M04.D16;
import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		solution3();
	}
	
	public static void solution3() throws Exception {
		int n = Integer.parseInt(rd.readLine());
		tok = new StringTokenizer(rd.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) arr[i] = Integer.parseInt(tok.nextToken());
		Arrays.sort(arr);
		int[][] diff = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				diff[i][j] = Math.abs(arr[i] - arr[j]);
			}
		}
		
		int INF = 1500000000;
		long sum = 0, min = 0;
		for(int i=0;i<n-1;i++) {
			int ch = i, cw = i+1;
			sum = diff[ch][cw];
			while(ch > 0 && cw < n) {
				int top = ch-1 >= 0 ? diff[ch-1][cw] : INF;
				int right = cw+1 < n ? diff[ch][cw+1] : INF;
				boolean next = top < right ? true : false; 	// 0Àº top, 1Àº right
				if(next) {
					ch--;
					sum += top;
				} else {
					cw++;
					sum += right;
				}
			}
			if(i == 0) min = sum;
			else min = Math.min(sum, min);
		}
		System.out.println(sum);
		
	}
	
	public static void solution2() throws Exception {
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			int n = Integer.parseInt(rd.readLine()); 
			char[] arr = new char[n];
			String s = rd.readLine();
			for(int i=0;i<n;i++) arr[i] = s.charAt(i);
			
			Queue<Integer> tStack = new LinkedList<>();
			Stack<Integer> mStack = new Stack<>();
			boolean pass = true;
			for(int i=0;i<n;i++) {
				if(arr[i] == 'T') tStack.offer(i);
				else {
					if(tStack.isEmpty()) {
						pass = false;
						break;
					} else {
						int c = tStack.poll();
						arr[i] = 'H';
						arr[c] = 'H';
						mStack.push(i);
					}
				}
			}
			
			if(pass) {
				for(int i=n-1;i>=0;i--) {
					if(arr[i] == 'T' && !mStack.isEmpty() && mStack.peek() < i ) {
						arr[i] = 'H';
						mStack.pop();
					} else if(arr[i] == 'T' || arr[i] == 'M') {
						pass = false;
						break;
					}
				}
			}
			
			if(pass && mStack.isEmpty()) wr.write("YES");
			else wr.write("NO");
			wr.newLine();
		}
		wr.flush();
	}
	
	public static void solution() throws Exception {
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			int n = Integer.parseInt(rd.readLine());
			tok = new StringTokenizer(rd.readLine());
			
			Queue<Integer> odd = new LinkedList<Integer>();
			Queue<Integer> even = new LinkedList<Integer>();
			for(int i=0;i<n;i++) {
				int c = Integer.parseInt(tok.nextToken());
				if(c%2 == 0) even.add(c);
				else odd.add(c);
			}
			while(!odd.isEmpty()) wr.write(odd.poll()+" ");
			while(!even.isEmpty()) wr.write(even.poll()+" ");
			wr.newLine();
		}
		wr.flush();
	}
}