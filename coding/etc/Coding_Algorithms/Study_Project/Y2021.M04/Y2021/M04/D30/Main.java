package Y2021.M04.D30;
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
			int m  = Integer.parseInt(tok.nextToken());
			int n = Integer.parseInt(tok.nextToken());
			int x = Integer.parseInt(tok.nextToken());
			int y = Integer.parseInt(tok.nextToken());
			int temp;
			
			boolean moncheck = m > n;
			if(moncheck) {
				temp = m;
				m = n;
				n = temp;
				temp = x;
				x = y;
				y = temp;
			}
			int cx = 1, cy=1, res  = 1;
			
			boolean cant = false;
			while(x - cx != (y >= cy ?  y - cy : (y+n) - cy)) {
				res += m;
				cy = (cy + m) > n ? (cy+m)%n : cy+m;
//				wr.write(cx+" "+cy+" "+x+" "+y+" "+res);
//				wr.newLine();
				if(cy == 1) {
					cant = true;
					break;
				}
			}
			if(cant) res = -1;
			else {
				res += (x - cx); 
			}
			wr.write(res+"");
			wr.newLine();
		}
		wr.flush();
	}
}