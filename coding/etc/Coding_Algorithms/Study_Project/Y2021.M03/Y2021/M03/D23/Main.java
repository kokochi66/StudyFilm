package Y2021.M03.D23;
import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		solution();
	}
	static LinkedList<Integer> doq;
	static LinkedList<Integer> suq;
	static Queue<Integer> dogr;
	static Queue<Integer> sugr;
	public static void solution() throws Exception {
		tok = new StringTokenizer(rd.readLine());
		int n = Integer.parseInt(tok.nextToken());
		int m = Integer.parseInt(tok.nextToken());
		doq = new LinkedList<Integer>();
		suq = new LinkedList<Integer>();
		dogr = new LinkedList<Integer>();
		sugr = new LinkedList<Integer>();
		for(int i=0;i<n;i++) {
			tok = new StringTokenizer(rd.readLine());
			doq.add(0, Integer.parseInt(tok.nextToken()));
			suq.add(0, Integer.parseInt(tok.nextToken()));
		}
		
		int dodo = -1;
		int susu = -1;
		for(int i=0;i<m;i++) {
			int c = -1;
			if(i%2 == 0) {
				c = doq.isEmpty() ? -1 : doq.remove(0);
				dogr.offer(c);
				dodo = c;
				// i°¡ Â¦¼ö¶ó¸é do°¡ ³¾ Â÷·Ê
			} else {
				c = suq.isEmpty() ? -1 : suq.remove(0);
				sugr.offer(c);
				susu = c;
			}
			if(c == -1 || doq.isEmpty() || suq.isEmpty()) break;
			if(dodo == 5 || susu == 5) {
				dodo = -1;
				susu = -1;
				dowin();
			}
			if(dodo + susu == 5) {
				dodo = -1;
				susu = -1;
				suwin();
			}
		}
		System.out.println(doq.size() > suq.size() ? "do" : doq.size() == suq.size() ? "dosu" : "su");
	}
	public static void dowin() {
		while(!sugr.isEmpty()) doq.add(sugr.poll());
		while(!dogr.isEmpty()) doq.add(dogr.poll());
	}
	public static void suwin() {
		while(!dogr.isEmpty()) suq.add(dogr.poll());
		while(!sugr.isEmpty()) suq.add(sugr.poll());
	}
}