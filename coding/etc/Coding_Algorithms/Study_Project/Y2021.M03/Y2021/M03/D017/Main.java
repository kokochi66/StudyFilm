package Y2021.M03.D017;
import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		solution2();
	}
	static int[] arr;
	public static void solution2() throws Exception {
		tok = new StringTokenizer(rd.readLine());
		int n = Integer.parseInt(tok.nextToken());
		int m = Integer.parseInt(tok.nextToken());
		arr = new int[n];
		sol2_rec(0, 0, 1, m, n);
		for(int i=0;i<n;i++) {
			wr.write(arr[i]+" ");
		}
		wr.flush();
	}
	
	public static void sol2_rec(int index, int num, int tar, int m, int n) { 
		if(index == m) {
			boolean[] chk = new boolean[n+1];
			for(int i=0;i<num;i++) {
				arr[i] = n-i;
				chk[n-i] = true;
			}
			arr[num] = tar;
			chk[tar] = true;
			int ind = num+1;
			for(int i=1;i<=n;i++) {
				if(!chk[i]) {
					chk[i] = true;
					arr[ind++] = i;
				}
			}
			return;
		}
		if(tar+1 >= n-num) {
			num++;
			tar = 1;
		} else tar++;
		sol2_rec(index+1, num, tar, m, n);
	}
	
	public static void solution() throws Exception {
		tok = new StringTokenizer(rd.readLine());
		int n = Integer.parseInt(tok.nextToken());
		int m = Integer.parseInt(tok.nextToken());
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i=0;i<n;i++) {
			String str = rd.readLine();
			if(str.length() >= m) {
				if(map.containsKey(str)) {
					map.replace(str, map.get(str)+1);
				}
				else map.put(str, 1);
			}
		}	// 입력된 값들을 해시 맵에 넣는다. 반복되는 값이 있으면 반복숫자만큼 더해준다. 길이 m이상인값만 넣어준다.
		
		Iterator<String> iter = map.keySet().iterator();
		PriorityQueue<word> pq = new PriorityQueue<word>();
		
		while(iter.hasNext()) {
			StringBuilder k = new StringBuilder(iter.next());
			int f = map.get(k.toString());
			pq.add(new word(k,f));
		}	//해시맵에서 값을 꺼내서 우선순위큐에 넣어준다.
		
		while(!pq.isEmpty()) {
			wr.write(pq.poll().word.toString());
			wr.newLine();
		}	// 우선순위큐에서 단어를 꺼내 출력한다.
		wr.flush();
	}
	
	static class word implements Comparable<word>{
		StringBuilder word;
		int freq;
		public word(StringBuilder w, int f) {
			this.word = w;
			this.freq = f;
		}
		@Override
		public int compareTo(word o) {
			if(o.freq == this.freq) {
				if(o.word.length() == this.word.length()) {
					return this.word.compareTo(o.word);
				}
				return Integer.compare(o.word.length(),this.word.length());
			}
			return Integer.compare(o.freq, this.freq);
		}
		
	}
}