package Y2020.M12.D20;
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
		int[][] arr = new int[n][n];
		ArrayList<Integer[]> house = new ArrayList<>();
		ArrayList<Integer[]> chicken = new ArrayList<>();
		for(int i=0;i<n;i++) {
			tok = new StringTokenizer(rd.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(tok.nextToken());
				if(arr[i][j] == 1) house.add(new Integer[] {i,j});
				else if(arr[i][j] == 2) chicken.add(new Integer[] {i,j});
			}
		}

		min = Integer.MAX_VALUE;
		int[] oper = new int[m];
		btk(0,m,0,chicken,house,oper);
		System.out.println(min);
//		for(int i=0;i<chicken.size();i++) {
//			System.out.println(Arrays.toString(chicken.get(i)));
//		}
	}
	static int min;
	public static void btk(int k, int m, int ci, ArrayList<Integer[]> chicken, ArrayList<Integer[]> house, int[] oper) {
		if(k==m) {
			int[] c = new int[house.size()];
			for(int i=0;i<house.size();i++) {
				Integer[] ho = house.get(i);
				c[i] = Math.abs(ho[0]-chicken.get(oper[0])[0]) + Math.abs(ho[1]-chicken.get(oper[0])[1]);
				for(int j=1;j<m;j++) {
					Integer[] ch = chicken.get(oper[j]);
					c[i] = Math.min(Math.abs(ho[0]-ch[0]) + Math.abs(ho[1]-ch[1]) , c[i]);
				}
			}
			min = Math.min(min, Arrays.stream(c).sum());
		} else {
			for(int i=ci;i<chicken.size()-(m-k-1);i++) {
				oper[k] = i;
				btk(k+1,m,i+1,chicken,house,oper);
			}
		}
	}

}