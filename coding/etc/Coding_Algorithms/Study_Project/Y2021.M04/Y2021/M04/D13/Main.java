package Y2021.M04.D13;
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
		int m = Integer.parseInt(tok.nextToken());
		String s = rd.readLine();
		String t = rd.readLine();
		Seq[] pos = new Seq[m]; 	// 모든 값들의 현재 위치와 각 max값들을 저장할 Seq 배열
		int i=0, j=0, k=m-1; 	// 인덱스
		while(s.charAt(j) != t.charAt(i)) j++; // 먼저 첫번째 위치를 찾는다.
		pos[0] = new Seq(0,j); // 첫번째 문자위치 적용, 첫번째값은 i-1을 뺄수 없으므로 최댓값이 존재하지 않음.
		for(i=n-1;i>j;i--) {
			if(k > 0 && s.charAt(i) == t.charAt(k)) {
				pos[k] = new Seq(0,i); 	// 최댓값은 배열 완성된 후에 다시 계산함.
				k--;
			}
		} // 첫번째 값을 제외한 나머지 문자들을 오른쪽 끝에서부터 찾아놓는다.
		for(i=1;i<m;i++) pos[i].setMax(pos[i].cindex - pos[i-1].cindex);	 // 배열완성된 후 초기 최댓값을 계산하여 적용함.
		i =1;		// i인덱스는 반복문에서 현재 t문자열의 위치를 의미함.
		j++; 	// j인덱스는 반복문에서 현재 s문자열의 위치를 의미함.
		while(i < m-1 && j < n) {
			if(s.charAt(j) == t.charAt(i)) {
				pos[i].setIndex(j);
				pos[i].setMax(pos[i].cindex - pos[i-1].cindex);
				pos[i+1].setMax(pos[i+1].cindex - pos[i].cindex); 	// 최댓값을 바뀐값과 현재값중 더 큰값으로 설정한다.
				i++;
			}	// s문자열에서 이번에는 왼쪽으로 붙이면서  t문자열의 위치를 찾아낸다.
			j++;
		}
		Arrays.sort(pos);
		System.out.println(pos[0].max);
//		System.out.println(Arrays.toString(pos));
	}
	static class Seq implements Comparable<Seq> {
		int max;
		int cindex;
		public Seq(int m, int c) {
			this.max = m;
			this.cindex=c;
		}
		public void setMax(int m) {
			this.max = Math.max(this.max, m);
		}
		public void setIndex(int c) {
			this.cindex = c;
		}
		@Override
		public String toString() {
			return "{max=" + max + ", cindex=" + cindex + "}";
		}
		@Override
		public int compareTo(Seq o) {
			return o.max - this.max;
		}
		
	}
}