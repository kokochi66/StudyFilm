package Y2020.M12.D21;
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
			tok = new StringTokenizer(rd.readLine());
			int n = Integer.parseInt(tok.nextToken());
			int m = Integer.parseInt(tok.nextToken());
			int[][] rooks = new int[m][2];
			int[] edge = new int[n+1];
			int count = 0;
			for(int i=0;i<m;i++) {
				tok = new StringTokenizer(rd.readLine());
				rooks[i][0] = Integer.parseInt(tok.nextToken());
				rooks[i][1] = Integer.parseInt(tok.nextToken());
				edge[rooks[i][0]] = rooks[i][1];
			}
			// insert
			ArrayList<ArrayList<Integer>> grp = new ArrayList<>();
			for(int i=1;i<=n;i++) {
				boolean chk = false;
				if(edge[i] != 0 && i != edge[i]) {
					for(int j=0;j<grp.size();j++) {
						if(grp.get(j).get(grp.get(j).size()-1) == i) {
							grp.get(j).add(edge[i]);
							chk = true;
							if(grp.get(j).get(0) == edge[i]) {
								grp.get(j).remove(grp.get(j).size()-1);
								grp.get(j).add(-1);
							}
							break;
						} else if (grp.get(j).get(0) == edge[i]) {
							grp.get(j).add(0,i);
							chk = true;
							break;
						}
					}
					if(!chk) {
						grp.add(new ArrayList<Integer>());
						grp.get(grp.size()-1).add(i);
						grp.get(grp.size()-1).add(edge[i]);
					}
				}
			}
			for(int i=0;i<grp.size();i++) {
				if(grp.get(i).size() == 2) count += 1;
				else if(grp.get(i).get(grp.get(i).size()-1) == -1) count += grp.get(i).size();
				else count += grp.get(i).size()-1;
			}
			System.out.println(count);
//			for(int i=0;i<grp.size();i++) {
//				for(int j=0;j<grp.get(i).size();j++) {
//					wr.write(grp.get(i).get(j)+" ");
//				}
//				wr.newLine();
//			}
			wr.flush();
		}
	}
//	public static void solution() throws Exception {
//		int TestCase = Integer.parseInt(rd.readLine());
//		for(int TT=0;TT<TestCase;TT++) {
//			String s = rd.readLine();
//			long n = Long.parseLong(s);
//			boolean pass = false;
//			while(!pass) {
//				char[] str = (n+"").toCharArray();
//				boolean[] check = new boolean[10];
//				for(int i=0;i<str.length;i++) check[str[i]-'0'] = true;
//				for(int i=1;i<10;i++) {
//					if(check[i] && n%i != 0) {
//						n++;
//						break;
//					}
//					else if(i==9) pass =true;
//				}
//			}
//			System.out.println(n);
//		}
//	}
//	public static void solution() throws Exception {
//		int TestCase = Integer.parseInt(rd.readLine());
//		for(int TT=0;TT<TestCase;TT++) {
//			int n = Integer.parseInt(rd.readLine());
//			char[] s = rd.readLine().toCharArray();
//			for(int i=n-1;i>=0;i--) {
//				if(s[i] != ')') {
//					if(i+1 < n-i-1) System.out.println("Yes");
//					else System.out.println("No");
//					break;
//				}
//				else if(i==0) System.out.println("Yes");
//			}
//		}
//	}
}