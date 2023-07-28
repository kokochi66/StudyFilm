package D29;

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
		tok = new StringTokenizer(rd.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = (Integer.parseInt(tok.nextToken()));
		}
		int bitcount=0, bit = 0;
		for(int i=0;i<n;i++) {
			int index = 0;
			int c = arr[i];
			while(c!=0) {
				c/=2;
				index++;
			}
			if(bit != index) {
				bitcount = 1;
				bit = index;
			} else bitcount++;
			if(bitcount>=3) {
				System.out.println("1");
				return;
			}
		}
		
		int min = Integer.MAX_VALUE;
		boolean pass = false;
		for(int i=0;i<n-1;i++) {
			int c = arr[i];
			for(int j=i+1;j<n;j++) {
				c ^= arr[j];
				if(i>0 && c < arr[i-1] && min > j-i) {
					min = j-i;
					pass = true;
				}
				if(j+1<n && c > arr[j+1] && min > j-i) {
					min = j-i;
					pass = true;
				}
			}
		}
		if(pass) System.out.println(min);
		else System.out.println(-1);
		
	}
//	public static void solution() throws Exception {
//		int TestCase = Integer.parseInt(rd.readLine());
//		for(int TT=0;TT<TestCase;TT++) {
//			tok = new StringTokenizer(rd.readLine());
//			int n = Integer.parseInt(tok.nextToken());
//			int p = Integer.parseInt(tok.nextToken());
//			int k = Integer.parseInt(tok.nextToken());
//			int[][] arr = new int[3][n+1];
//			String str = rd.readLine();
//			for(int i=1;i<=n;i++) {
//				arr[0][i] = i;
//				arr[1][i] = str.charAt(i-1)-'0';
//			}
//			tok = new StringTokenizer(rd.readLine());
//			int x = Integer.parseInt(tok.nextToken());
//			int y = Integer.parseInt(tok.nextToken());
//			// Insert O
//			
//			int min = Integer.MAX_VALUE;
//			for(int i=p;i<=n;i++) {
//				if(arr[0][i] == i) {
//					Stack<Integer> st = new Stack<Integer>();
//					int index = i;
//					arr[2][index] += (i-p)*y;
//					st.push(index);
//					while(index+k <= n) {
//						index +=k;
//						st.push(index);
//						arr[0][index] = i;
//						arr[2][index] += (index-p)*y;
//					}
//					int sum = 0;
//					while(!st.isEmpty()) {
//						index = st.pop();
//						sum += arr[1][index]==0 ? x : 0;
//						arr[2][index] += sum;
////						System.out.println(i+" "+index+" "+arr[2][index] +" "+sum);
//					}
//				}
//				if(arr[2][i] < min) min = arr[2][i];
//			}
////			System.out.println(Arrays.toString(arr[0]));
////			System.out.println(Arrays.toString(arr[1]));
////			System.out.println(Arrays.toString(arr[2]));
//			System.out.println(min);
//		}
//	}
//	public static void solution() throws Exception {
//		int TestCase = Integer.parseInt(rd.readLine());
//		for(int TT=0;TT<TestCase;TT++) {
//			tok = new StringTokenizer(rd.readLine());
//			int n = Integer.parseInt(tok.nextToken());
//			int k = Integer.parseInt(tok.nextToken());
//			tok = new StringTokenizer(rd.readLine());
//			int[] arr = new int[n];
//			for(int i=0;i<n;i++) arr[i] = Integer.parseInt(tok.nextToken());
//			int[] count = new int[105];
//			int min = Integer.MAX_VALUE;
//			for(int i=1;i<=100;i++) {
//				int index = 0;
//				int sum = 0;
//				while(index < n) {
//					if(arr[index] != i) {
//						sum++;
//						index += k;
//					} else index++;
//				}
//				if(min > sum) min = sum;
//			}
//			System.out.println(min);
//		}
//	}
//	public static void solution() throws Exception {
//		int TestCase = Integer.parseInt(rd.readLine());
//		for(int TT=0;TT<TestCase;TT++) {
//			tok = new StringTokenizer(rd.readLine());
//			int n = Integer.parseInt(tok.nextToken());
//			int m = Integer.parseInt(tok.nextToken());
//			int[] pir = new int[2];
//			pir[0] = Integer.parseInt(tok.nextToken());
//			pir[1] = Integer.parseInt(tok.nextToken());
//			// Insert O
//			
//			int[] corN = {1,1,n,n};
//			int[] corM = {1,m,1,m};
//			int maxcor = 0, sumcor = 0;;
//			for(int i=0;i<4;i++) {
//				int sum = 0;
//				sum += Math.abs(pir[0]-corN[i]) + Math.abs(pir[1]-corM[i]);
//				if(sumcor < sum) {
//					maxcor = i;
//					sumcor = sum;
//				}
//			}
//			System.out.println(sumcor);
//		}
//	}
}