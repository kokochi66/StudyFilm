package Y2021.M04.D29;
import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		solution3();
	}
	
	public static void solution3() throws Exception {
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			tok = new StringTokenizer(rd.readLine());
			int lx = Integer.parseInt(tok.nextToken());
			int ly = Integer.parseInt(tok.nextToken());
			int rx = Integer.parseInt(tok.nextToken());
			int ry = Integer.parseInt(tok.nextToken());
			
			int cle = Integer.parseInt(rd.readLine());
			int res = 0;
			for(int i=0;i<cle;i++) {
				tok = new StringTokenizer(rd.readLine());
				int cx = Integer.parseInt(tok.nextToken());
				int cy = Integer.parseInt(tok.nextToken());
				int cr = Integer.parseInt(tok.nextToken());
				boolean lcon = sol3_contain(lx,ly,cx,cy,cr);
				boolean rcon = sol3_contain(rx,ry,cx,cy,cr);
				if(lcon ^ rcon) res++;
			}
			wr.write(res+"");
			wr.newLine();
		}
		wr.flush();
	}
	
	public static boolean sol3_contain(int tx, int ty, int cx, int cy, int cr) {
		int tdis = Math.abs(tx - cx);	// x 축 거리
		if(!(cx - cr <= tx && cx + cr >= tx)) return false;	//x축이 포함되지 않으면 원이 포함되지 않음
		int ydis = (int) Math.sqrt(Math.pow(cr, 2) - Math.pow(tdis, 2));	// x축에 대비한 y축 범위를 잰다.
		if(!(cy - ydis <= ty && cy + ydis >= ty)) return false;	// y축이 포함되지 않으면 원이 포함되지 않음
		return true;
	}
	
	public static void solution2() throws Exception {
		HashSet<Integer> set = new HashSet<Integer>();
		int n = Integer.parseInt(rd.readLine());
		for(int i=0;i<n;i++) {
			tok = new StringTokenizer(rd.readLine());
			String str = tok.nextToken();
			if(str.equals("all")) {
				for(int j=1;j<=20;j++) set.add(j);
			} else if(str.equals("empty")) {
				set.clear();
			} else {
				int num = Integer.parseInt(tok.nextToken());
				
				if(str.equals("add")) {
					set.add(num);
				} else if(str.equals("remove")) {
					set.remove(num);
				} else if(str.equals("check")) {
					wr.write(set.contains(num) ? 1+"" : 0+"");
					wr.newLine();
				} else if(str.equals("toggle")) {
					if(set.contains(num)) set.remove(num);
					else set.add(num);
				}
			}
		}
		wr.flush();
	}
	public static void solution() throws Exception {
		System.out.println("고려대학교");
	}
}