package Y2021.M03.D018;
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
		tok = new StringTokenizer(rd.readLine());
		int n = Integer.parseInt(tok.nextToken());
		int k = Integer.parseInt(tok.nextToken());
		tok = new StringTokenizer(rd.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(tok.nextToken());
		}// 입력부
		
		int left = -1; // 현재 최좌단값을 저장한다. 처음에는 최좌단값이 없으므로 -1로 초기화
		int max = 0; // 최장연속부분수열의 가장 긴 값을 저장할 max를 0으로 초기화한다.
		panel[] pan = new panel[100001];	//모든 수를 확인해줄 클래스배열을 생성한다.
		for(int i=0;i<=100000;i++) {
			pan[i] = new panel();	// 각 배열의 값들을 초기화해준다.
		}
		
		for(int i=0;i<n;i++) {
			int f = pan[arr[i]].addpan(i, left, k);
			if(f != -1) {
				left = f;
			}
//			System.out.println(i+" "+max+" "+(i-left));
			max = Math.max(max, i - left);
		}
		System.out.println(max);
	}
	
	static class panel {
		List<Integer> pos;
		public panel() {
			pos = new ArrayList<Integer>();
		}
		
		public int addpan(int n, int left, int k) {
			 while(pos.size()>0 && pos.get(0) <= left) {
				 pos.remove(0);
			 } // 현재의 최좌단 포지션값보다 적은값들을 제거하고 값을 넣어준다.
			 pos.add(n);
			 
			 if(pos.size() > k) {
				 return pos.remove(0);		// 원소가 k를 초과한다면 가장 끝값을 제거하고, 해당 제거한 값이 최좌단값이 되어, 리턴한다.
			 }
			 return -1; 	// 초과하지 않는다면, -1을 리턴한다. 이 때, -1은 정상적인 제거를 의미하게 된다.
		} 	
	}
}