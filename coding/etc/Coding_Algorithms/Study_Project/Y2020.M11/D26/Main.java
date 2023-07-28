package D26;

import java.util.*;
import java.util.stream.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
//		solution();
	}
//	public static void solution() throws Exception {
//		StringBuilder str = new StringBuilder(rd.readLine());
//		int[] counter = new int[10];
//		for(int i=0;i<str.length();i++) {
//			int c = str.charAt(i)-'0';
//			if(c==9) c=6;
//			counter[c]++;
//		}
//		if(counter[6]%2==0) counter[6] /= 2;
//		else counter[6] = (counter[6]/2) +1;
////		wr.write(Arrays.toString(counter));
//		wr.write(Arrays.stream(counter).max().getAsInt()+"");
//		wr.flush();
//	}
//	public static void solution() throws Exception {
//		for(int TT=0;TT<3;TT++) {
//			tok = new StringTokenizer(rd.readLine());
//			int c1=0, c0 = 0;
//			for(int i=0;i<4;i++) {
//				if(Integer.parseInt(tok.nextToken()) == 1) c1++;
//				else c0++;
//			}
//			switch(c1) {
//			case 0:
//				wr.write("D");
//				break;
//			case 1:
//				wr.write("C");
//				break;
//			case 2:
//				wr.write("B");
//				break;
//			case 3:
//				wr.write("A");
//				break;
//			case 4:
//				wr.write("E");
//				break;
//			default:
//				break;
//			}
//			wr.newLine();
//		}
//		wr.flush();
//	}
//	public static void solution() throws Exception {
//		int n = Integer.parseInt(rd.readLine());
//		for(int i=n;i>=1;i--) {
//			for(int j=0;j<n-i;j++) wr.write(" ");
//			for(int j=0;j<(2*i)-1;j++) wr.write("*");
//			wr.newLine();
//		}
//		wr.flush();
//	}
//	public static void solution() throws Exception {
//		int TestCase = Integer.parseInt(rd.readLine());
//		for(int TT=0;TT<TestCase;TT++) {
//			int n = Integer.parseInt(rd.readLine());
//			int[][] arr = new int[2][n+5];
//			tok = new StringTokenizer(rd.readLine());
//			for(int i=0;i<n;i++) arr[0][i] = Integer.parseInt(tok.nextToken());
//			tok = new StringTokenizer(rd.readLine());
//			for(int i=0;i<n;i++) arr[1][i] = Integer.parseInt(tok.nextToken());
//			
//			int[][] div = new int[2][n+5];
//			div[0][0] = arr[0][0];
//			div[1][0] = arr[1][0];
//			div[0][1] = div[1][0] + arr[0][1];
//			div[1][1] = div[0][0] + arr[1][1];
//			long max = Math.max(div[0][1], div[1][1]);
//			for(int i=2;i<n;i++) {
//				div[0][i] = Math.max(div[1][i-1], div[1][i-2])+arr[0][i];
//				div[1][i] = Math.max(div[0][i-1], div[0][i-2])+arr[1][i];
//				if(max < Math.max(div[0][i], div[1][i])) max = Math.max(div[0][i], div[1][i]);
//			}
//			wr.write(max+"");
////			wr.write(Arrays.toString(div[0])+"");
////			wr.newLine();
////			wr.write(Arrays.toString(div[1])+"");
//			wr.newLine();
//		}
//		wr.flush();
//	}
//	public static void solution() throws Exception {
//		int n = Integer.parseInt(rd.readLine());
//		for(int i=1;i<=n;i++) {
//			for(int j=0;j<i;j++) wr.write("*");
//			for(int j=0;j<(2*(n-i));j++) wr.write(" ");
//			for(int j=0;j<i;j++) wr.write("*");
//			wr.newLine();
//		}
//		for(int i=n-1;i>=1;i--) {
//			for(int j=0;j<i;j++) wr.write("*");
//			for(int j=0;j<(2*(n-i));j++) wr.write(" ");
//			for(int j=0;j<i;j++) wr.write("*");
//			wr.newLine();
//		}
//		wr.flush();
//		
//	}
//	public static void solution() throws Exception {
//		int n = Integer.parseInt(rd.readLine());
//		
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n-i-1;j++) wr.write(" ");
//			for(int j=0;j<1+(2*i);j++) wr.write("*");
//			wr.newLine();
//		}
//		for(int i=n-2;i>=0;i--) {
//			for(int j=n;j>i+1;j--) wr.write(" ");
//			for(int j=0;j<1+(2*i);j++) wr.write("*");
//			wr.newLine();
//		}
//		wr.flush();
//	}
//	public static void solution() throws Exception {
//		int n = Integer.parseInt(rd.readLine());
//		tok = new StringTokenizer(rd.readLine());
//		int[] arr = new int[n+5];
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		for(int i=1;i<=n;i++) {
//			arr[i] = Integer.parseInt(tok.nextToken());
//		}
//		int[] div = new int[n+5];
//		div[0] = 0;
//		div[1] = arr[1];
//		for(int i=2;i<=n;i++) {
//			div[i] = arr[i];
//			for(int j=i-1;j>=1;j--) {
//				div[i] = Math.max(div[j] + div[i-j], div[i]);
//			}
//		}
//		wr.write(div[n]+"");
////		wr.newLine();
////		wr.write(Arrays.toString(div));
////		for(double a : list) {
////			wr.write(a+" ");
////		}
//		wr.flush();
//		
//	}
//	public static void solution() throws Exception {
//		int n = Integer.parseInt(rd.readLine());
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n-i-1;j++) {
//				wr.write(" ");
//			}
//			for(int j=0;j<1+(2*(i));j++) {
//				wr.write("*");
//			}
//			wr.newLine();
//		}
//		wr.flush();
//	}
//	public static void solution() throws Exception {
//		int[] arr = new int[9];
//		for(int TT=0;TT<9;TT++) {
//			arr[TT] = Integer.parseInt(rd.readLine());
//		}
//		boolean[] used = new boolean[9];
//		int[] oper = new int[7];
//		bfs(0,0,used,oper,arr);
//		wr.flush();
//	}
//	public static boolean bfs(int k, int ci, boolean[] used, int[] oper, int[] arr) throws Exception {
//		if(k==7) {
//			if(Arrays.stream(oper).sum() == 100) {
//				Arrays.sort(oper);
//				for(int i=0;i<7;i++) {
//					wr.write(oper[i]+" ");
//					wr.newLine();
//				}
//				return true;
//			}
//		} else {
//			for(int i=ci;i<9;i++) {
//				if(!used[i]) {
//					used[i] = true;
//					oper[k] = arr[i];
//					if(bfs(k+1,ci+1,used,oper,arr)) return true;
//					used[i] = false;
//				}
//			}
//		}
//		return false;
//	}
//	public static void solution() throws Exception {
//		tok = new StringTokenizer(rd.readLine());
////		ArrayList<Integer> list = new ArrayList<Integer>();
////		for(int i=0;i<8;i++) list.add(Integer.parseInt(tok.nextToken()));
//		StringBuilder res = new StringBuilder("");
//		for(int i=0;i<8;i++) res.append(tok.nextToken());
//		if(res.toString().equals("12345678")) wr.write("ascending");
//		else if(res.toString().equals("87654321")) wr.write("descending");
//		else wr.write("mixed");
//		wr.flush();
//	}
//	public static void solution() throws Exception {
//		tok = new StringTokenizer(rd.readLine());
//		int n = Integer.parseInt(tok.nextToken());
//		int m = Integer.parseInt(tok.nextToken());
//		tok = new StringTokenizer(rd.readLine());
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		for(int i=0;i<n;i++) {
//			list.add(Integer.parseInt(tok.nextToken()));
//		}
//		Collections.sort(list);
//		int index = list.size()-1;
//		int max = list.get(index);
//		int getTree = 0;
//		while(getTree < m) {
//			max--;
//			while(index-1 >=0 && list.get(index-1) > max) index--;
//			getTree += list.size()-index;
////			System.out.println(max +" "+ index +" "+getTree +" "+ m);
//		}
//		System.out.println(max);
////		for(int a : list) System.out.print(a+" ");
//	}
//	public static void solution()1 throws Exception {
//		int n = Integer.parseInt(rd.readLine());
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		tok = new StringTokenizer(rd.readLine());
//		for(int i=0;i<n;i++) {
//			list.add(Integer.parseInt(tok.nextToken()));
//		}
//		Collections.sort(list);
//		int m = Integer.parseInt(rd.readLine());
//		tok = new StringTokenizer(rd.readLine());
//		for(int i=0;i<m;i++) {
//			int c = Integer.parseInt(tok.nextToken());
//			if(Collections.binarySearch(list, c)>=0)
//				wr.write("1");
//			else wr.write("0");
//			wr.newLine();
//		}
//		wr.flush();
//	}
}