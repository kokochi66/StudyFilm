package Y2021.M03.D019;
import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		solution();
	}
	static int[] p;
	static int count;
	static int[][] sal;
	static boolean[][] salchk;
	static Emp[] emp;
	static boolean[] chk;
	static List<String> print;
	public static void solution() throws Exception {
		int n = Integer.parseInt(rd.readLine());
		sal = new int[n][n];
		salchk = new boolean[n][n];
		emp = new Emp[1024];
		chk = new boolean[1024];
		p = new int[1024];
		for(int i=0;i<1024;i++) p[i] = i;
		count = 0;
		print = new ArrayList<>();
		for(int i=0;i<n;i++) {
			tok = new StringTokenizer(rd.readLine());
			for(int j=0;j<n;j++) {
				sal[i][j] = Integer.parseInt(tok.nextToken());
			}
			count++;
			salchk[i][i] = true;
			chk[i] = true;
			emp[i] = new Emp(i,i,sal[i][i]);
		}// 입력부
		sol_rec();
//		for(int i=0;i<count;i++) {
//			System.out.println(emp[i]);
//		}
		wr.write(count+"");
		wr.newLine();
		for(int i=0;i<count;i++) {
			wr.write(emp[i].salary+" ");
		}
		wr.newLine();
		wr.write(count+"");
		wr.newLine();
		for(int i=0;i<print.size();i++) {
			wr.write(print.get(i));
			wr.newLine();
		}
		wr.flush();
	}
	
	public static void sol_rec() {
		int thisC = count;
		int endCondition = 0;
		for(int i=0;i<thisC;i++) {
			if(chk[i]) {
				int len = emp[i].minNode.size();
				for(int j=0;j<len;j++) {
					int comp = findp(emp[i].minNode.get(j));
					int len2 = emp[ comp ].minNode.size();
					for(int k=0;k<len2;k++) {
						if(emp[i].min == emp[ comp ].min && emp[i].Leaf ==  emp[ comp ].minNode.get(k)) {
							chk[emp[i].Node] = false;
							chk[ emp[ comp ].Node ]  = false;
							chk[count] = true;
							salchk[emp[i].Leaf][emp[ comp ].Leaf] = true;
							salchk[emp[ comp ].Leaf][emp[i].Leaf] = true;
							for(int m=0;m<salchk[0].length;m++) {
								if(salchk[emp[ comp ].Leaf][m]) salchk[emp[i].Leaf][m] = true;
							}
							System.out.println(emp[i].Node+" "+comp+" "+count);
							p[emp[i].Node] = count;
							p[emp[comp].Node] = count;
							emp[count] = new Emp(emp[i].Leaf, count, emp[i].min);
							print.add((emp[i].Node+1) +" "+(count+1));
							print.add((emp[comp].Node+1) +" "+(count+1));
							count++;
						}	// 현재 번호와 비교값의 최솟값 번호가 일치하며, 현재의 최솟값과 비교값의 최솟값이 일치하면 두 값은 동일한 루트의 자식이다.
					}
				}
				endCondition++;
				System.out.println(emp[i]);
			}
		}
//		System.out.println("endc " + endCondition);
		if(endCondition > 2) sol_rec();
	}
	public static int findp(int n) {
		if(p[n] == n) return n;
		return findp(p[n]);
	}
	
	static class Emp {
		int Leaf = -1;
		int Node;
		List<Integer> minNode;
		int min;
		int salary;
		public Emp (int L, int N, int s) {
			this.Leaf = L;
			this.Node = N;
			this.salary = s;
			this.minNode = new ArrayList<>();
			this.min = 9999;
			findMin();	// 초기화 후에 현재 값에서 자동으로 최솟값을 찾도록 한다.
		}
		public void findMin() {
			for(int i=0;i<sal[0].length;i++) {
				if(!salchk[Leaf][i] && this.min > sal[Leaf][i]) this.min = sal[Leaf][i];
			}	// 최솟값 찾기
			for(int i=0;i<sal[0].length;i++) {
				if(sal[Leaf][i] == this.min) this.minNode.add(i);
			} // 최솟값의 위치를 리스트에 넣기
		}
		
		public void clearNode() {
			while(this.minNode.size() > 0) this.minNode.remove(0);
			this.min = 9999;
		} // 리스트를 초기화, 최솟값 역시 초기화한다.
		
		@Override
		public String toString() {
			int[] str = new int[minNode.size()];
			for(int i=0;i<str.length;i++) {
				str[i] = minNode.get(i);
			}
			return "Emp [Leaf=" + Leaf + ", Node=" + Node + ", minNode=" + Arrays.toString(str) + ", min=" + min + ", salary="
					+ salary + "]";
		}
		
		
	}
}