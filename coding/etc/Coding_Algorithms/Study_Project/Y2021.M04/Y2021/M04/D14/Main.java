package Y2021.M04.D14;
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
		int a = Integer.parseInt(tok.nextToken());
		int b = Integer.parseInt(tok.nextToken());
		int k = Integer.parseInt(tok.nextToken());
		if((k <= a+b-2 && a > 0 && b > 1) || (k == 0 && (a == 0 || b == 1))) {
			wr.write("Yes");
			wr.newLine();
			int n = a+b, cIndex = 0;
			char[] x = new char[n];
			char[] y = new char[n];
			for(int i=0;i<n;i++) {
				if(i < b) {
					x[i] = '1';
					y[i] = '1';
					cIndex = i;		//  가장끝에있는 1의 위치를 지정한다.
				} else {
					x[i] = '0';
					y[i] = '0';
				}
			} // 두 출력할 배열을 만든다. << 일단 최댓값으로 생성함.
			boolean[] pos = new boolean[n];
			for(int i=1;i<n;i++) if(x[i] == '1') pos[i] = true; 	// y의 1이 움직일 수 있는 위치를 표현하기위한 pos 배열을 초기화 
			
			int kCount = 0 ,nIndex = cIndex; // 현재 kCount가 목표값 k에 맞을때까지 알고리즘을 반복해야함.
			while(kCount < k) {
//				System.out.println(Arrays.toString(y) +" 라운드  :: " + kCount);
				if(y[n-1] != '1') {
					y[cIndex++] = '0';
					y[cIndex] = '1';
					if(cIndex == n-1) {
						cIndex = nIndex;
						nIndex--;
					}
				} // 초깃값이 아직 끝에 들어가지 않았다면 초깃값을 지정해주어야한다.
				else {
					if(y[cIndex+1] == '0' && pos[cIndex+1]) {
						y[cIndex++] = '0';
						y[cIndex] = '1';
					} // 아직 움직일 수 있는 공간이 남아있는 경우
					else {
						cIndex = nIndex;
						nIndex--;
						y[cIndex++] = '0';
						y[cIndex] = '1';
					} 	// 움직일 수 있는 공간이 없으면 nIndex로 현재위치를 조정한 후, 값을 적용해준다.
				} // 초깃값 지정이 끝나면 pos 위치에 따라서 내부조정이 필요하다.
				kCount++;
			}
			for(int i=0;i<n;i++) wr.write(x[i]);
			wr.newLine();
			for(int i=0;i<n;i++) wr.write(y[i]);
			wr.newLine();
		} else wr.write("No");
		wr.flush();
	}
}