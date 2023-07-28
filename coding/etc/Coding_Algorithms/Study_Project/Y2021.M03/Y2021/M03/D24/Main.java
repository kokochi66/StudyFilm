package Y2021.M03.D24;
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
		ArrayList<Integer> lst = new ArrayList<Integer>();
		int a = 3;
		int b = 4;
		int c = 5;
		while(c <= 1000000000) {
			lst.add(c);
			a += 2;
			b = (((int)Math.pow(a,2)) - 1) / 2;
			c = b+1;
		}
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			int n = Integer.parseInt(rd.readLine());
			int index = 0;
			while(index < lst.size() &&lst.get(index) <= n) index++;
			wr.write(index+"");
			wr.newLine();
		}
		wr.flush();
	}
	public static void solution() throws Exception {
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			int n = Integer.parseInt(rd.readLine());
			// 입력
			
			// 총 대결 수가 n으로 나누어 떨어지는지, 떨어지지 않는지 체크한다.
			// 떨어지지 않으면 나머지가 n/2이므로, 모든 팀이 각각 한번의 무승부와 playCount번의 승리를 갖도록 해야한다.
			int[] arr = new int[n+1]; 		// 0을 포함하지 않고, 1~n의 포인트를 저장할 배열
			int playCount = (n * (n-1)) / 2 ;
			int tarPoint = 0;
			if(playCount % n == 0) tarPoint = (playCount / n)*3;
			else tarPoint = ((playCount / n)*3) + 1;
			
			for(int i=1;i<n;i++) {
				for(int j=i+1;j<=n;j++) {
					if(arr[i] <= tarPoint - 3) {
						wr.write("1 ");
						arr[i] += 3;
					} else if(arr[i] < tarPoint) {
						wr.write("0 ");
						arr[i] += 1;
						arr[j] += 1;
					} else {
						wr.write("-1 ");
						arr[j] += 3;
					}
				}
			}
			wr.newLine();
		}
		wr.flush();
	}
}