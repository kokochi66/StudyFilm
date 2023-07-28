package Y2021.M03.D25;
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
		tok = new StringTokenizer(rd.readLine());
		int n = Integer.parseInt(tok.nextToken());
		int m = Integer.parseInt(tok.nextToken());
		int INF = 1000000000;
		
		int[] point = new int[n];
		int[] dis = new int[n];
		int[] grd = new int[m];
		Arrays.fill(grd, INF);
		boolean ini = false;
		
		tok = new StringTokenizer(rd.readLine());
		for(int i=0;i<n;i++) point[i] = Integer.parseInt(tok.nextToken());
		tok = new StringTokenizer(rd.readLine());
		for(int i=0;i<n;i++) dis[i] = Integer.parseInt(tok.nextToken());
		
		for(int c = n-1;c>=0;c--) {
			
			if(point[c] + dis[c] >= m) {
				int index = point[c];
				while(index < m && grd[index] > 1) {
					grd[index] = 1;
					index++;
				}
			} else {
				int index = point[c];
				int count = grd[point[c] + dis[c]] + 1;
				while(index < m && grd[index] > count) {
					grd[index] = count;
					index++;
				}
			}
		}
//		System.out.println(Arrays.toString(grd));
		if(m < point[0]) System.out.println(-1);
		else if(m ==  point[0]) System.out.println(0);
		else System.out.println(grd[point[0]] >= INF ? -1 : grd[1]-1);
		
	}
	
	public static void solution() throws Exception {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		for(int i=0;i<7;i++) {
			int c = Integer.parseInt(rd.readLine());
			if(c%2==1) {
				sum += c;
				list.add(c);
			}
		}
		if(list.size() > 0) {
			System.out.println(sum);
			Collections.sort(list);
			System.out.println(list.get(0));
		} else {
			System.out.println(-1);
		}
	}
}