package Y2020.M12.D3a;
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
		ArrayList<Integer> list = new  ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			list.add(Integer.parseInt(tok.nextToken()));
		}
		Collections.sort(list);
		if(list.size()>1) {
			wr.write((list.get(0)*list.get(list.size()-1))+"");
		} else {
			wr.write((list.get(0)*list.get(0))+"");
		}
		wr.flush();
	}
//	public static void solution() throws Exception {
//		String str = rd.readLine();
//		int[] alp = new int[26];
//		for(int i=0;i<str.length();i++) {
//			alp[str.charAt(i)-'a']++;
//		}
//		for(int a : alp) {
//			wr.write(a+" ");
//		}
//		wr.flush();
//	}
//	public static void solution() throws Exception {
//		String str = rd.readLine();
//		System.out.println(str.length());
//	}
//	public static void solution() throws Exception {
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		int n = Integer.parseInt(rd.readLine());
//		for(int i=0;i<n;i++) {
//			tok = new StringTokenizer(rd.readLine());
//			String str = tok.nextToken();
//			if(str.equals("push_front")) {
//				int c = Integer.parseInt(tok.nextToken());
//				list.add(0,c);
//			} else if(str.equals("push_back")) {
//				int c = Integer.parseInt(tok.nextToken());
//				list.add(c);
//			} else if(str.equals("pop_front")) {
//				if(list.isEmpty()) wr.write("-1");
//				else wr.write(list.remove(0)+"");
//				wr.newLine();
//			} else if(str.equals("pop_back")) {
//				if(list.isEmpty()) wr.write("-1");
//				else wr.write(list.remove(list.size()-1)+"");
//				wr.newLine();
//			} else if(str.equals("size")) {
//				wr.write(list.size()+"");
//				wr.newLine();
//			} else if(str.equals("empty")) {
//				if(list.isEmpty()) wr.write("1");
//				else wr.write("0");
//				wr.newLine();
//			} else if(str.equals("front")) {
//				if(list.isEmpty()) wr.write("-1");
//				else wr.write(list.get(0)+"");
//				wr.newLine();
//			}else if(str.equals("back")) {
//				if(list.isEmpty()) wr.write("-1");
//				else wr.write(list.get(list.size()-1)+"");
//				wr.newLine();
//			}
//		}
//		wr.flush();
//	}
}