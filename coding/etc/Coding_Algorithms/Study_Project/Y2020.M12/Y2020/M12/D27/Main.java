package Y2020.M12.D27;
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
		int[] max = new int[n];
		int[] min = new int[n];
		for(int i=0;i<n;i++) {
			tok = new StringTokenizer(rd.readLine());
			int a1 = Integer.parseInt(tok.nextToken());
			int a2 = Integer.parseInt(tok.nextToken());
			min[i] = a1-a2;
			max[i] = a1+a2;
		}
		
		int[][] res = new int[n][2];
		boolean[] used = new boolean[n];
		for(int i=0;i<n;i++) {
			res[i][0] = i;
			res[i][1] = i;
		}
		PriorityQueue<sd> pq = new PriorityQueue<sd>();
		for(int i=0;i<n;i++) {
			pq.add(new sd(min[i], i));
			pq.add(new sd(max[i], i));
		}
		int minC = 0, maxC =0;
		while(!pq.isEmpty()) {
			sd c = pq.poll();
			if(!used[c.sw]) {
				used[c.sw] = true;
				res[c.sw][0] = minC;
				maxC = maxC < c.sw ? c.sw : maxC;
			}
			else {
				res[c.sw][1] = maxC;
				minC++;
			}
		}
		for(int i=0;i<n;i++) {
			wr.write((res[i][0]+1)+" "+(res[i][1]+1));
			wr.newLine();
		}
		wr.flush();

	}
	static class sd implements Comparable<sd> {
		int num;
		int sw;
		public sd(int a, int b) {
			this.num = a;
			this.sw = b;
		}
		@Override
		public int compareTo(sd o) {
			if(o.num == this.num) {
				return o.sw < this.sw ? -1 : 1;
			}
			return o.num > this.num ? -1 : 1;
		}
	}
//	public static void solution() throws Exception {
//		int n = Integer.parseInt(rd.readLine());
//		int count = 0;
//		for(int i=0;i<n;i++) {
//			String s = rd.readLine();
//			count += s.length();
//		}
//		wr.write(count+"");
//		wr.flush();;
//	} 
//	public static void solution() throws Exception {
//		int[] xCov = {1, 0, -1, 0};
//		int[] yCov = {0, -1, 0, 1};
//		// r / d / l / u
//		int dir = 0;
//		
//		tok = new StringTokenizer(rd.readLine());
//		int n = Integer.parseInt(tok.nextToken());
//		int time = Integer.parseInt(tok.nextToken());
//		int[] arrTime = new int[n];
//		String[] arrDir = new String[n];
//		for(int i=0;i<n;i++) {
//			tok = new StringTokenizer(rd.readLine());
//			arrTime[i] = Integer.parseInt(tok.nextToken());
//			arrDir[i] = tok.nextToken();
//		}
//		
//		int x=0, y=0;
//		for(int i=0;i<n;i++) {
//			int c = arrTime[i];
//			if(i>0) c -= arrTime[i-1];
//			x += (c*xCov[dir]);
//			y += (c*yCov[dir]);
//			if(arrDir[i].equals("right")) dir = dir+1 > 3 ? 0 : dir+1;
//			else dir = dir-1 == -1 ? 3 : dir-1;
//		}
//		int c = time;
//		if(n>0) {
//			c -= arrTime[n-1];
//		}
//		x += (c*xCov[dir]);
//		y += (c*yCov[dir]);
//		wr.write(x+" "+y);
//		wr.flush();
//	}
//	public static void solution() throws Exception {
//		int n = Integer.parseInt(rd.readLine());
//		wr.write((int)(n*0.78)+" "+(int)(n-((n*0.2)*0.22)));
//		wr.flush();
//	}
}