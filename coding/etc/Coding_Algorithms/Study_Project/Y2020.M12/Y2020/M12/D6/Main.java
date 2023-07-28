package Y2020.M12.D6;
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
			char[][] crr = new char[n][n];
			for(int i=0;i<n;i++) {
				crr[i] = rd.readLine().toCharArray();
			}
			int[][] arr = new int[n][n];
			int[][] pos = new int[4][10];
			for(int i=0;i<n;i++) {
				pos[i][0] = i;
				pos[n-1+i][0] = n-1;
				pos[n-1+i][1] = i;
			}
			if(n>2) {
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						check(crr, arr, i,j);
					}
				}
//				for(int i=0;i<n;i++) System.out.println(Arrays.toString(arr[i]));
				btk(crr,arr,pos,n);
			}
			
//			for(int i=0;i<pos.length;i++) System.out.println(Arrays.toString(pos[i]));
//			for(int i=0;i<n;i++) System.out.println(Arrays.toString(crr[i]));
//			for(int i=0;i<n;i++) System.out.println(Arrays.toString(arr[i]));
			
		}
	}
	public static void btk(char[][] crr, int[][] arr, int[][] pos, int n) {
		char[][] crr1 = new char[n][n];
		char[][] crr2 = new char[n][n];
		char[][] crr3 = new char[n][n];
		int[][] arr1 = new int[n][n];
		int[][] arr2 = new int[n][n];
		int[][] arr3 = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				crr1[i][j] = crr[i][j];
				crr2[i][j] = crr[i][j];
				crr3[i][j] = crr[i][j];
				arr1[i][j] = arr[i][j];
				arr2[i][j] = arr[i][j];
				arr3[i][j] = arr[i][j];
			}
		}
		int count = 0;
		int min = n*n, minc = 0;
		
		for(int q=0;q<pos.length;q+=3) {
			int i = pos[q][0], j = pos[q][1];
			while(i<n && j<n && i>=0 && j>= 0) {
				if(arr[i][j]>0) {
					char c = crr1[i][j];
					crr1[i][j] = c=='O' ? 'X' : 'O';
					count++;
					check(crr1,arr1,i,j);
					if(i-1>=0) check(crr1,arr1,i-1,j);
					if(i-2>=0) check(crr1,arr1,i-2,j);
					if(i+1<n) check(crr1,arr1,i+1,j);
					if(i+2<n) check(crr1,arr1,i+2,j);
					
					if(j-1>=0) check(crr1,arr1,i,j-1);
					if(j-2>=0) check(crr1,arr1,i,j-2);
					if(j+1<n) check(crr1,arr1,i,j+1);
					if(j+2<n) check(crr1,arr1,i,j+2);
				}
				i--;
				j++;
			}
		}
		if(min > count) {
			minc = 1;
			min = count;
		}
		count = 0;
		for(int q=1;q<pos.length;q+=3) {
			int i = pos[q][0], j = pos[q][1];
			while(i<n && j<n && i>=0 && j>= 0) {
				if(arr[i][j]>0) {
					char c = crr2[i][j];
					crr2[i][j] = c=='O' ? 'X' : 'O';
					count++;
					check(crr2,arr2,i,j);
					if(i-1>=0) check(crr2,arr2,i-1,j);
					if(i-2>=0) check(crr2,arr2,i-2,j);
					if(i+1<n) check(crr2,arr2,i+1,j);
					if(i+2<n) check(crr2,arr2,i+2,j);
					
					if(j-1>=0) check(crr2,arr2,i,j-1);
					if(j-2>=0) check(crr2,arr2,i,j-2);
					if(j+1<n) check(crr2,arr2,i,j+1);
					if(j+2<n) check(crr2,arr2,i,j+2);
				}
				i--;
				j++;
			}
		}
		if(min > count) {
			minc = 2;
			min = count;
		}
		
		count = 0;
		for(int q=2;q<pos.length;q+=3) {
			int i = pos[q][0], j = pos[q][1];
			while(i<n && j<n && i>=0 && j>= 0) {
				if(arr[i][j]>0) {
					char c = crr3[i][j];
					crr3[i][j] = c=='O' ? 'X' : 'O';
					count++;
					check(crr3,arr3,i,j);
					if(i-1>=0) check(crr3,arr3,i-1,j);
					if(i-2>=0) check(crr3,arr3,i-2,j);
					if(i+1<n) check(crr3,arr3,i+1,j);
					if(i+2<n) check(crr3,arr3,i+2,j);
					
					if(j-1>=0) check(crr3,arr3,i,j-1);
					if(j-2>=0) check(crr3,arr3,i,j-2);
					if(j+1<n) check(crr3,arr3,i,j+1);
					if(j+2<n) check(crr3,arr3,i,j+2);
				}
				i--;
				j++;
			}
		}
		if(min > count) {
			minc = 3;
			min = count;
		}
		
		if(minc == 1) {
			for(int i=0;i<n;i++) {
				System.out.println(new String(crr1[i]));
			}
		} else if(minc == 2) {
			for(int i=0;i<n;i++) {
				System.out.println(new String(crr2[i]));
			}
		} else if(minc == 3) {
			for(int i=0;i<n;i++) {
				System.out.println(new String(crr3[i]));
			}
		}
	}
	public static void check(char[][] crr, int[][] arr, int i, int j) {
		int count = 0, n = arr.length;
		char c = crr[i][j];
		if(c == '.') return;
		if(i-2>=0 &&crr[i-1][j] == c && crr[i-2][j] == c ) {
			count++;
		}
		if(i-1>=0 && i+1<n && crr[i-1][j] == c && crr[i+1][j] == c ) {
			count++;
		}
		if(i+2<n && crr[i+1][j] == c && crr[i+2][j] == c ) {
			count++;
		}
		
		if(j-2>=0 &&crr[i][j-1] == c && crr[i][j-2] == c ) {
			count++;
		}
		if(j-1>=0 && j+1<n && crr[i][j-1] == c && crr[i][j+1] == c ) {
			count++;
		}
		if(j+2<n && crr[i][j+1] == c && crr[i][j+2] == c ) {
			count++;
		}
		arr[i][j] = count;
	}
//	public static void solution() throws Exception {
//		int TestCase = Integer.parseInt(rd.readLine());
//		for(int TT=0;TT<TestCase;TT++) {
//			tok = new StringTokenizer(rd.readLine());
//			int n = Integer.parseInt(tok.nextToken());
//			int m = Integer.parseInt(tok.nextToken());
//			int[][] drr = new int[n][2];
//			for(int i=0;i<n;i++) {
//				tok = new StringTokenizer(rd.readLine());
//				drr[i][0] = Integer.parseInt(tok.nextToken());
//				drr[i][1] = Integer.parseInt(tok.nextToken());
////				System.out.println(Arrays.toString(drr[i]));
//			}
//			
//			int[] wgt = new int[n];
//			for(int i=0;i<n;i++) {
//				for(int j=0;j<n;j++) {
//					if(Math.abs(drr[j][0]-drr[i][0])+Math.abs(drr[j][1]-drr[i][1])<=m) {
//						wgt[i]++;
//					}
//				}
//			}
//			int max = Arrays.stream(wgt).max().getAsInt();
//			if(max>=n) System.out.println("1");
//			else System.out.println("-1");
//		}
//	}
//	public static void solution() throws Exception {
//		int TestCase = Integer.parseInt(rd.readLine());
//		for(int TT=0;TT<TestCase;TT++) {
//			int n = Integer.parseInt(rd.readLine());
//			String str = rd.readLine();
//			int[] count = new int[26];
//			for(int i=0;i<n;i++) count[str.charAt(i)-'a']++;
//			StringBuilder temp = new StringBuilder("");
//			for(int i=0;i<26;i++) {
//				for(int j=0;j<count[i];j++) {
//					temp.append((char)('a'+i)+"");
//				}
//			}
//			System.out.println(temp.toString());
//		}
//	}
}