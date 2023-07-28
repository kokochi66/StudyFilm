package Y2021.M1.D20;
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
			int d = Integer.parseInt(rd.readLine());
			if(d == 1) wr.write("6");
			else {
				int sec = (d+1)%2==0 ? d+2 : d+1;
				boolean pass = false;
				while(!pass) {
					boolean tt = true;
					for(int i=2;i<=Math.sqrt(sec);i++) if(sec%i==0) tt = false;
					if(tt) break;
					sec+=2;
				}
				int thr = (sec+d)%2==0 ? sec+d+1 : sec+d;
				pass = false;
				while(!pass) {
					long c = sec * thr;
					boolean tt = true;
					for(int i=2;i<sec;i++) if(c%i==0) tt = false;
					if(tt) {
						wr.write(sec+" "+thr+" "+c+"");
						break;
					}
					thr+=2;
				}
			}
			wr.newLine();
		}
		wr.flush();
	}
//	public static void solution() throws Exception {
//		int TestCase = Integer.parseInt(rd.readLine());
//		for(int TT=0;TT<TestCase;TT++) {
//			int n = Integer.parseInt(rd.readLine());
//			String b = rd.readLine();
//			StringBuilder st = new StringBuilder();
//			for(int  i=0;i<n;i++) st.append('1');
//			for(int i=1;i<n;i++) {
//				char prev = sumc(b.charAt(i-1), st.charAt(i-1));
//				char curr = sumc(b.charAt(i), st.charAt(i));
//				if(prev == curr) {
//					st.setCharAt(i, '0');
//				}
//			}
//			System.out.println(st);
//		}
//	}
//	public static char sumc(char a , char b) {
//		return (char)(a+b-'0');
//	}
}