package D30;

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
		System.out.println(TestCase);
		for(int TT=0;TT<TestCase;TT++) {
			int n = Integer.parseInt(rd.readLine());
			int[] arr = new int[(n*2)+10];
			Arrays.fill(arr, 100000000);
			arr[0] = 0; 
			arr[1] = 1;
			int curr = 1, index = 2;
			while(curr<n) {
				curr += index;
				arr[curr] = index;
				int cd = index+1, cr = curr;
				while(cr<n) {
					cr += (index-1);
					arr[cr] = cd;
					cd++;
				}
				index++;
			}
			for(int i=arr.length-2;i>=n;i--) {
				if(arr[i-1] > arr[i]+1) arr[i-1] = arr[i]+1;
			}
			
//			System.out.println(Arrays.toString(arr));
			System.out.println(arr[n]);
		}
	}
//	public static void solution() throws Exception {
//		int TestCase = Integer.parseInt(rd.readLine());
//		for(int TT=0;TT<TestCase;TT++) {
//			String s = rd.readLine();
//			System.out.println(s.length());
//		}
//	}
}