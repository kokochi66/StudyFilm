package Y2021.M04.D12;
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
			int n = Integer.parseInt(rd.readLine());
			tok = new StringTokenizer(rd.readLine());
			int[] origin = new int[n];
			for(int i=0;i<n;i++) origin[i] = Integer.parseInt(tok.nextToken());
			// 입력부
			
			// greedy형식문제 -> 리스트로 입력받아서 끝의값부터 현재 꺼낼 수 있는 최댓값까지 꺼내야함.
			int max = n, maxTemp = n-1; 	// 현재의 최댓값을 max에 저장하고, maxTemp에 다음 최댓값이 될 예정값을 미리 담아둔다.
			int pos = n;	// 결과 리스트에 넣어야 되는 위치를 저장함.
			boolean[] maxbox = new boolean[n+1];	// 현재 최댓값이 나왔는지를 체크해줄 boolean 배열을 선언한다.
			maxbox[n] = true;
			for(int i=n-1;i>=0;i--) {
				maxbox[origin[i]] = true;
				while(maxbox[maxTemp]) maxTemp--;	// 현재까지 아직 나오지 않은 값들로 다음 최댓값을 지정한다.
				if(origin[i] != max) { 
				} // 최댓값이 아니라면 결과리스트의 pos위치에 origin의 끝값들을 하나씩 넣어준다.
				else {
					for(int j=i;j<pos;j++) wr.write(origin[j]+" ");
					pos = i;
					max = maxTemp;
				} // 최댓값이라면, pos위치에 최댓값을 넣어준 후, pos위치를 현재 res리스트의 끝위치로 조정한다.
			}
			
			// 리스트는 생각보다 Log N 때문에 시간복잡도상 문제가 발생할 일이 많기 때문에 가능하면 배열구현이 좋다.
			wr.newLine();
		}
		wr.flush();
	}
}