package D27;

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
		int k = Integer.parseInt(tok.nextToken());
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] arr = new int[k+5];
		for(int TT=0;TT<n;TT++) {
			list.add(Integer.parseInt(rd.readLine()));
		}
		Collections.sort(list);
		arr[0] = 1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<=k;j++) {
				if(j-list.get(i)>=0) {
					arr[j] += arr[j-list.get(i)];
				}
			}
		}
		wr.write(arr[k]+"");
		wr.flush();
	}
//	public static void solution() throws Exception {
//		int n = Integer.parseInt(rd.readLine());
//		long[][] arr = new long[n+5][10];
//		for(int i=0;i<10;i++) arr[1][i] = 1;
//		for(int i=2;i<=n;i++) {
//			for(int j=0;j<10;j++) {
//				for(int k=j;k<10;k++) {
//					arr[i][j] = (arr[i][j] + arr[i-1][k])%10007;
//				}
//			}
//		}
//		System.out.println(Arrays.stream(arr[n]).sum()%10007);
////		for(int i=98;i<=n;i++) 
////			System.out.println(Arrays.toString(arr[i]) +" "+Arrays.stream(arr[i]).sum());
//	}
}