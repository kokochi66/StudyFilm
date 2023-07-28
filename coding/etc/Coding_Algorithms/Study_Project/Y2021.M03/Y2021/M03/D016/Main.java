package Y2021.M03.D016;
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
		int n = Integer.parseInt(rd.readLine());
		sal = new int[n][n];
		chk = new boolean[n][n];
		for(int i=0;i<n;i++) {
			tok = new StringTokenizer(rd.readLine());
			chk[i][i] = true;
			for(int j=0;j<n;j++) {
				sal[i][j] = Integer.parseInt(tok.nextToken());
			}
			rec.add(new Integer[] {i+1, i+1, sal[i][i]});		// 재귀함수 값에 현재 Leaf 노드의 데이터 저장, Leaf위치값, 현재위치값, 현재Sal값을 저장함
			num_sal.add(sal[i][i]);
		} // 입력부
		int root = sol_rec(n+1);
		System.out.println(root);
		for(int i=0;i<num_sal.size();i++) System.out.print(num_sal.get(i)+" ");
		System.out.println();
		System.out.println(root);
		for(int i=0;i<edge.size();i++) {
			Integer[] c = edge.get(i);
			System.out.println(c[0]+" "+c[1]);
		}
	}
	static ArrayList<Integer[]> rec = new ArrayList<Integer[]>();			// 재귀함수를 위한 리스트
	static ArrayList<Integer> num_sal = new ArrayList<Integer>();		// 출력1, 각 직원의 번호당 월급을 저장 
	static ArrayList<Integer[]> edge = new ArrayList<Integer[]>();		// 출력2, 직원의 관계도를 저장
	static int[][] sal;
	static boolean[][] chk;
	
	public static int sol_rec(int indexing) {
		if(rec.size() <= 2) return rec.get(0)[1];
		System.out.println("재귀" +" "+rec.size());
		int n = rec.size();
		int m = sal.length;
		Integer[][] rec_save = new Integer[n][3];
		int[][] data = new int[m][3];
		boolean[] chs = new boolean[m];
		for(int i=0;i<n;i++) {
			Integer[] c = rec.remove(0);
			for(int j=0;j<3;j++) rec_save[i][j] = c[j];
			int min = min_sal(c[0]-1);			//  Leaf 위치값에서 가장 sal이 낮은값을 찾는다.
			data[c[0]-1][0] = min;						// 위치값을 0번에 저장
			data[c[0]-1][1] = sal[c[0]-1][min];		//해당 sal값을 1번에 저장
			data[c[0]-1][2] = i;							//인덱싱 값을 2번에 저장
			chs[c[0]-1] = true;						// 처리체크를 위한 불리언
		}	// O(m^2) = 25000 연산
		
		for(int i=0;i<m;i++) {
			System.out.println("data :: " + Arrays.toString(data[i]));
			if(chs[i] && i == data[data[i][0]][0] && data[i][1] == data[data[i][0]][1]) {
				chs[i] = false;
				chs[data[i][0]] = false;
				chk[i][data[i][0]] = true;
				chk[data[i][0]][i] = true;
				rec.add(new Integer[] {Math.min(data[i][0]+1 , data[data[i][0]][0]+1) , indexing, data[i][1]});
				num_sal.add(data[i][1]);
				edge.add(new Integer[] {rec_save[data[i][2]][1], indexing});
				edge.add(new Integer[] {rec_save[data[data[i][0]][2]][1], indexing});
				indexing++;
			}
		} // O(m) = 500 연산
		
		for(int i=0;i<m;i++) {
			if(chs[i]) {
				rec.add(rec_save[data[i][2]]);
			}
		} // O(m) = 500 연산
		
		return sol_rec(indexing);
	}	// O(log m) * O(m^2) = 25000 * 8 연산
	
	public static int min_sal(int a) {
		int index = 0, minsal = 9999;
		for(int i=0;i<sal.length;i++) {
			if(!chk[a][i] && minsal > sal[a][i]) {
				index = i;
				minsal = sal[a][i];
			}
		}
		return index;
	}	// 입력된 a번째와 연결된 값에서 서칭되지 않았으며, 가장 sal이 낮은값의 index를 리턴한다. O(n) 연산
}