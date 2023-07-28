package Y2021.M03.D28;
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
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			int n = Integer.parseInt(rd.readLine());
			int[] arr = new int[n];
			tok = new StringTokenizer(rd.readLine());
			HashMap<Integer, Parci> map = new HashMap<Integer, Parci>();
			for(int i=0;i<n;i++) {
				arr[i] = Integer.parseInt(tok.nextToken());
				if(map.containsKey(arr[i])) {
					Parci p = map.get(arr[i]);
					p.addMem(i);
					map.replace(arr[i], p);
				} else {
					map.put(arr[i], new Parci(arr[i], i));
				}
			}	// 입력된 값들을 정리하여 Map안에 넣음
			
			ArrayList<Parci> list = new ArrayList<Parci>();
			ArrayList<Long> dp = new ArrayList<Long>();
			
			Iterator<Integer> iter = map.keySet().iterator();
			while(iter.hasNext()) {
				int k = iter.next();
				Parci p = map.get(k);
				list.add(p);
			}	// Map안에 넣은 값들을 꺼내서 리스트에 넣음
			
			Collections.sort(list);
			dp.add(list.get(0).token * list.get(0).number.size());
			for(int i=1;i<list.size();i++) {
				dp.add(dp.get(i-1) + (list.get(i).token * list.get(i).number.size()));
			}	// 리스트를 정렬하고, dp로 각 토큰수의 인원수만큼을 설정함.
			
			boolean[] win = new boolean[list.size()];
			HashSet<Integer> winner = new HashSet<Integer>();
			int printsize = 0;
			win[win.length-1] = true;
			winner.add((int) list.get(list.size()-1).token);
			printsize += list.get(list.size()-1).number.size();
			for(int i=list.size()-2;i>=0;i--) {
				if(dp.get(i) >= list.get(i+1).token && win[i+1]) {
					win[i] = true;
					winner.add((int) list.get(i).token);
					printsize += list.get(i).number.size();
				}
			}	// dp값이 다음값보다 크다면 그 다음값을 각각확인, 그 다음값이 우승값이라면 현재 dp값도 우승으로 판정
			
			wr.write(printsize+" ");
			wr.newLine();
			for(int i=0;i<n;i++) {
				if(winner.contains(arr[i])) wr.write((i+1)+" ");
			}
			wr.newLine();
			
		}
		wr.flush();
	}
	
	static class Parci implements Comparable<Parci> {
		long token;
		ArrayList<Integer> number = new ArrayList<>();
		public Parci(long t, int n) {
			this.token = t;
			this.number.add(n);
		}
		
		public void printMem() {
			System.out.print(token+" :::: ");
			for(int i=0;i<number.size();i++) System.out.print(number.get(i)+" ");
			System.out.println();
		}
		
		public void addMem(int n) {
			this.number.add(n);
		}
		@Override
		public int compareTo(Parci o) {
			return (int) (this.token - o.token);
		}
		
	}
	
	public static void solution() throws Exception {
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			int n = Integer.parseInt(rd.readLine());
			int[] arr = new int[n];
			int[] printweight = new int[n];
			tok = new StringTokenizer(rd.readLine());
			for(int i=0;i<n;i++) arr[i] = Integer.parseInt(tok.nextToken());
			
			Queue<Node> que = new LinkedList<>();
			que.add(new Node(0,n-1,0));
			while(!que.isEmpty()) {
				Node c = que.poll();
				int mp = findMax(c.pos, arr);
				printweight[mp] = c.weight;
				if(mp-1 >= c.pos[0]) que.add(new Node(c.pos[0],mp-1,c.weight+1));
				if(mp+1 <= c.pos[1]) que.add(new Node(mp+1,c.pos[1],c.weight+1));
			}
			for(int i=0;i<n;i++) wr.write(printweight[i]+" ");
			wr.newLine();
		}
		wr.flush();
	}
	
	public static int findMax(int[] pos, int[] arr) {
		int max = 0;
		int index = -1;
		for(int i=pos[0];i<=pos[1];i++) {
			if(max < arr[i]) {
				max = arr[i];
				index = i;
			}
		}
		return index;
	}
	
	static class Node {
		int[] pos = new int[2];
		int weight;
		public Node(int l, int r, int w) {
			this.pos[0] = l;
			this.pos[1] = r;
			this.weight = w;
		}
	}
}