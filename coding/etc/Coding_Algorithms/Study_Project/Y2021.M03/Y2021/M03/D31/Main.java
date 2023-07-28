package Y2021.M03.D31;
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
		int song =  Integer.parseInt(tok.nextToken());
		int avg = Integer.parseInt(tok.nextToken());
		int sum = (song*avg)-1;
		while(sum % song != 0) {
			sum--;
		}
		System.out.println(sum+1);
	}
	
	public static void solution() throws Exception {
		int n = Integer.parseInt(rd.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=3;i<=1000000;i+=2) {
			if(isPrime(i)) list.add(i);
		}
		while(n != 0) {
			for(int i=0;i<list.size();i++) {
				int c = list.get(i);
				if(n-c <= 0) break;
				int r = Collections.binarySearch(list, n-c);
				if(r>=0) {
					wr.write(n+" = "+c+" + "+list.get(r));
					wr.newLine();
					break;
				}
			}
			
			n = Integer.parseInt(rd.readLine());
		}
		wr.flush();
	}
	public static boolean isPrime(int n) {
		for(int i=3;i<=Math.sqrt(n);i++) {
			if(n%i == 0) return false;
		}
		return true;
	}
}