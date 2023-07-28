package D14;
import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(rd.readLine());
		List<String> list = new ArrayList<String>();
		for(int i=0;i<n;i++) {
			list.add(rd.readLine());
		}
		String encoded = rd.readLine();
		System.out.println(decode(list, encoded));
		
//		StringBuffer str = new StringBuffer("abc");
//		str.append("\n");
//		str.append("abcd");
//		System.out.println(str);
	}
	
    public static String decode(List<String> codes, String encoded) {
    	// 허프만 코드는 높은 빈도수의 문자를 짧게 압축하는 역할을 한다.
    	// 허프만 코드의 길이는 서로 다를 수 있으나, 앞글자가 일치하는 값은 존재하지 않는다. 즉 01이 a라고 정해져있으면 b는 011이 될 수 없다.
    	// 허프만 코드 매핑 배열과 인코딩된 허프만 문자열이 주어졌을 떄, 해당 문자열의 해독값을 찾아라.
    	// 각 값은 탭으로 분리되어있다. 새로운 라인은 [newline]으로 표시되어있다.
    	
    	// 문자열 자체를 리스트에 저장, 이진탐색을 통해서 찾도록 한다.
    	// 문자열은 비교에 시간이 많이들기 때문에 StringBuffer를 사용해준다.
    	int n = codes.size();
    	ArrayList<StringBuffer> list = new ArrayList<>();
    	HashMap<StringBuffer, String> map = new HashMap<StringBuffer, String>();
    	for(int i=0;i<n;i++) {
    		tok = new StringTokenizer(codes.get(i), "\t");
    		String s = tok.nextToken();
    		StringBuffer code = new StringBuffer(tok.nextToken());
    		list.add(code);
    		map.put(code, s);
    	}
    	
    	Collections.sort(list, (a,b) -> compareBuff(a,b)); // 이진탐색을 위해서 리스트를 정렬해준다.
    	
    	char[] encode = encoded.toCharArray();
    	StringBuffer c = new StringBuffer("");
    	StringBuffer res = new StringBuffer("");
    	for(int i=0;i<encode.length;i++) {
    		c.append(encode[i]);
//    		System.out.println("c = " +c +" bin ="+bin);
    		int search = Collections.binarySearch(list, c, (a,b) -> compareBuff(a,b));
    		
    		if(search < 0) continue;	// 이진탐색에 값이 존재하지 않으면 다음으로 넘어간다.
    		else {
    			c = new StringBuffer("");
    			String op = map.get(list.get(search));
//    			System.out.println("decode :: " + op);
    			if(op.equals("[newline]")) res.append("\n");
    			else res.append(op);
    			
    		}
    	}
    	
    	
    	return res.toString();
    }
    
    public static int compareBuff(StringBuffer a, StringBuffer b) {
    	if(a.length() != b.length()) return a.length() < b.length() ? -1 : 1;
    	for(int i=0;i<a.length();i++) {
    		if(a.charAt(i) != b.charAt(i)) return a.charAt(i) < b.charAt(i) ? -1 : 1;
    	}
    	return 0;
    }
	
    public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
    	// 회사의 도착시간과 진행시간이 주어졌을 때, 작업이 진행되는 프레젠테이션의 최대치를 계산하라
    	
    	// n = 1000
    	// 1. 작업을 늘어놓고, 다른 작업과 시간대가 겹치지 않는 작업을 먼저 추가시킨다. (n)
    	// 2. 겹치는 작업 중, 겹치는 개수가 많은 작업을 순서대로 제외시키고, 제외시키는 대로, 작업을 새로 계산해준다.
    	// 3. 겹치는 작업이 없을때까지 반복하고, 겹치는 작업이 없어지면 해당 작업 개수를 출력한다.
    	
    	int cntJob = 0;
    	ArrayList<Job> jobs = new ArrayList<>();
    	for(int i=0;i<arrival.size();i++) {
    		jobs.add(new Job(arrival.get(i), duration.get(i)));
    	} // 편의상 클래스 리스트로 변환
    	
    	int n = jobs.size();
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<n;j++) {
    			if(i != j) {
    				jobs.get(i).calconf(jobs.get(j));
    			}
    		}
    	}
    	
    	while(!notConf(jobs)) {	// 겹치는 작업이 1개라도 있다면 반복한다. = 50
    		
    		removeMost(jobs);	// 가장 많이 겹치는 작업을 제거해준다.
    		n = jobs.size();
        	for(int i=0;i<n;i++) {
        		jobs.get(i).resetConf();
        		for(int j=0;j<n;j++) {
        			if(i != j) {
        				jobs.get(i).calconf(jobs.get(j));
        			}
        		}
        	}
    		
//        	for(int i=0;i<jobs.size();i++) System.out.println(jobs.get(i).toString());
//        	System.out.println("====");
    	}
    	
    	return jobs.size();
    }
    
    static class Job {
    	int arr, dur, end, conf;
    	
    	public Job(int a,int d) {
    		this.arr = a;
    		this.dur = d;
    		this.end = a+d;
    		this.conf = 0;
    	}
    	
    	public void resetConf() {
    		this.conf = 0;
    	}
    	
    	public void calconf(Job j) {
    		if(isconf(j)) this.conf++;
    	}
    	
    	public boolean isconf(Job j) {
    		if(this.arr <= j.arr && this.end > j.arr || this.arr < j.end && this.end > j.end) {
//    			System.out.println("conf == "+ this.toString() +" "+j.toString());
    			return true;
    		}
    		return false;
    	}

		@Override
		public String toString() {
			return "Job [arr=" + arr + ", dur=" + dur + ", end=" + end + ", conf=" + conf + "]";
		}
    	
    }

    public static boolean notConf(ArrayList<Job> jobs) {
    	for(int i=0;i<jobs.size();i++) {
    		if(jobs.get(i).conf >= 1) return false;
    	}
    	return true;
    }
    
    public static void removeMost(ArrayList<Job> jobs) {
    	int maxconf = 0, maxidx = 0, maxdur = 0;
    	for(int i=0;i<jobs.size();i++) {
    		if(maxconf < jobs.get(i).conf) {
    			maxconf = jobs.get(i).conf;
    			maxidx = i;
    		} 
    	}
    	jobs.remove(maxidx);
    }
	
    public static String reachTheEnd(List<String> grid, int maxTime) {
    	// 2차원 배열이 존재, 블락된 곳은 #, 블락되지 않은곳은 .로 표현됨
    	// 시작위치는 가장 위 왼쪽임. 시작위치는 블락되지 않음을 보장한다. 또한 가장 오른쪽 아래도 블락되지 않음을 보장한다.
    	// 각 초마다 인접한 셀(상하좌우)로 움직일 수 있다. k초안에 오른쪽 아래로 도착할 수 있다면 Yes, 아님녀 No를 출력하라.
    	
    	// 최단거리를 찾는문제, BFS를 이용하여 풀 것임.
    	int n = grid.size(), m = grid.get(0).length();
    	char[][] gridr = new char[n][m];
    	for(int i=0;i<n;i++) {
    		gridr[i] = grid.get(i).toCharArray();
    	}	// 편의상 char[]로 변환해줌.
    	if(n-1 == 0 && m-1 == 0) return "Yes";
    	
    	Queue<Integer[]> q = new LinkedList<>();
    	q.add(new Integer[] {0,0,0});	// 초기위치 큐에 입력
    	boolean[][] check = new boolean[n][m];	// 이미 이동한 곳은 다시 가지 않게 체크.
    	check[0][0] = true;
    	int[][] op = { {1,0}, {-1,0}, {0,1}, {0,-1} };
    	
    	while(!q.isEmpty()) {
    		Integer[] c = q.poll();
    		if(c[2] > maxTime) return "No";
    		for(int i=0;i<4;i++) {
    			if(move3(c[0] + op[i][0], c[1] + op[i][1], c[2], n, m, gridr, check, q)) return "Yes";
    		}
    	}
    	
    	
    	return "No";
    }
    
    public static boolean move3(int ch, int cw, int cnt, int n, int m, char[][] grid, boolean[][] check, Queue<Integer[]> q) {
    	if(ch < 0 || ch >= n || cw < 0 || cw >= m || grid[ch][cw] == '#' || check[ch][cw]) return false;
    	else if(ch == n-1 && cw == m-1) return true;
    	q.add(new Integer[] {ch,cw,cnt+1});
    	check[ch][cw] = true;
    	return false;
    }
	
    public static int getMinDeletions(String s) {
    	char[] str = s.toCharArray(); // 편의상 char[]로 변환
    	Arrays.sort(str);
    	int cnt = 1;
    	for(int i=1;i<str.length;i++) {
    		if(str[i] != str[i-1]) cnt++;
    	}	// 각 알파벳의 개수를 세준다.
    	
    	return str.length - cnt;	// 총 문자의 개수 - 알파벳의 개수 만큼 제거해주어야 한다.
    }
	
    static int maxTickets(List<Integer> tickets) {
    	Collections.sort(tickets);
    	int maxCnt = 1, cnt = 1;
    	for(int i=1;i<tickets.size();i++) {
    		if(tickets.get(i) - tickets.get(i-1) <= 1) {
    			cnt++;
    		} else {
    			if(maxCnt < cnt) maxCnt = cnt;
    			cnt = 1;
    		}
    	}
    	return maxCnt;
    }
    
    
}