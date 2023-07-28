package D12;
import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		System.out.println(solution(3,	3, new String[] { "DBA", 
														  "C*A", 
														  "CDB" }	)); // ABCD
		
//		System.out.println(solution(2,	4, new String[] { "NRYN", 
//														  "ARYA"}	)); // RYAN
//		
//		System.out.println(solution(4,	4, new String[] { ".ZI.", 
//														  "M.**", 
//														  "MZU.", 
//														  ".IU."})); // MUZI
//		
//		System.out.println(solution(2,	2, new String[] { "AB", 
//														  "BA"})); // IMPOSSIBLE
	}
	
    public static String solution(int m, int n, String[] board) {
    	// 입력값에서 .은 빈칸, *은 장애물(막힌칸), 알파벳 대문자는 각 타일을 나타내며, 같은 타일끼리 제거해주어야한다. 여기서 타일이 없는 입력은 주어지지 않는다.
    	// 출력에서, 해가 존재하는 경우(모든 타일을 제거할 수 있는 경우), 타일을 제거하는 순서대로 한 글자씩 이루어진 문자열을, 해가 여러가지 인 경우,알파벳 순으로 가장 먼저인 문자열을 리턴한다.
    	// 해가 존재하지 않으면 IMPOSSIBLE을 리턴한다.
    	// 보드의 크기 M * N 은 각각 100 이하이다 (n^3 가능)
    	
    	// 1. 각 보드에서, 알파벳 순으로 문자의 위치 한 곳을 저장하고 있는 배열을 정렬하여 구성한다.
    	// 2. 여기서 한 턴 동안 배열을 돌면서 처음부터 끝까지, 너비우선 탐색(BFS)을 이용하여, 해당 문자가 다른 문자와 매치가 가능한 상태인지를 체크한다.
    	// 3. 만약 매치가 가능하다면, 매치 상태를 체크하며, 해당 문자 두 위치를 빈 공간(.)으로 변경하고, 다시 배열의 처음으로 돌아가 처음부터 반복한다.
    	// 4. 매치 상태 체크는 check boolean 배열을 이용하여 이미 체크한 값은 다시 체크하지 않도록 해준다.
    	
    	cboard = new char[m][n];
    	tm = m;
    	tn = n;
    	// 사용편의를 위한 전역변수화
    	for(int i=0;i<m;i++) cboard[i] = board[i].toCharArray();	// 사용하기 간편하게 char 배열로 변경해줌
    	
    	
    	//1. 배열구성(각 문자는 하나만 체크해야 하므로, 이를 간편하게 연산하기 위해서 HashSet을 이용한다. n^2 연산이 든다.)
    	HashSet<Character> set = new HashSet<>();
    	ArrayList<boardPOS> list = new ArrayList<boardPOS>();	// 개수 세는게 어려우므로, 배열이 아닌 리스트로 구현한다.
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			if(cboard[i][j] != '.' && cboard[i][j] != '*' && !set.contains(cboard[i][j])) {
    				set.add(cboard[i][j]);
    				list.add(new boardPOS(cboard[i][j], i, j));
    			}
    		}
    	}
    	Collections.sort(list); // 넣어준 값을 정렬해준다.
//    	for(int i=0;i<list.size();i++) System.out.println(list.get(i).toString());
    	
    	
    	boolean[] check = new boolean[list.size()];
    	int checkCnt = 0;
    	String answer = "";
    	
    	// 2. 턴을 돌면서, 너비우선탐색을 진행한다.
    	for(int k=0;k<list.size();k++) {
        	for(int i=0;i<list.size();i++) {
        		if(check[i]) continue;
//        		System.out.println(list.get(i).tile);
        		if(boardBFS(list.get(i).h, list.get(i).w)) {
//        			System.out.println(list.get(i).tile);
        			cboard[list.get(i).h][list.get(i).w] = '.';
        			check[i] = true;
        			checkCnt++;
        			answer += list.get(i).tile;
//        			for(int q=0;q<m;q++) System.out.println(Arrays.toString(cboard[q]));
        			break;
        			// 3. 매치되었다면, 해당 공간 '.'으로 변경 후, 리스트의 처음부터 다시 반복한다.
        		}
        	}
    	}
    	if(checkCnt < list.size()) return "IMPOSSIBLE";
        return answer;
    }
    static char[][] cboard;
    static int tm, tn;
    
    public static boolean boardBFS(int ch, int cw) {
    	// 너비우선 탐색을 진행하면서, 타일간의 거리에서 방향이 두 번 이상 꺾이면 안되며, 중간에 다른 타일이나 장애물이 있어서는 안된다.
    	// 따라서 방향값을 넣어주고, 방향이 몇번 틀어졌는지에 대한 카운트값도 BFS에 포함되어야 한다.
    	// 각 방향에서 겹치는 부분이 있으면 결과값이 달라지므로, 방향마다 별도로 계산해주기 위해서 반복문을 돌린다.
    	// 계산 편의를 위해서 반복문에 맞게 배열을 생성한다.
    	
    	int[][] op = { {1,0}, {-1,0}, {0,1}, {0,-1} };
    	char target = cboard[ch][cw];
    	
    	for(int i=0;i<4;i++) {
        	Queue<Integer[]> q = new LinkedList<>();
        	boolean[][] check = new boolean[tm][tn];
        	check[ch][cw] = true;
        	
        	// 초기 이동값을 큐에 넣어준다. 큐에 들어가는 값은 각각, ch, cw, cd(현재방향), dcnt(방향카운트) 이다.
        	// 방향은 0(down), 1(up), 2(right), 3(left) 이다.
        	if(findTarget(ch + op[i][0], cw + op[i][1], i, 0, target, q, check)) return true;
        	
        	while(!q.isEmpty()) {
        		Integer[] c = q.poll();
//        		System.out.println(Arrays.toString(c));
        		
        		for(int j=0;j<4;j++) {
        			if(findTarget(c[0] + op[j][0], c[1] + op[j][1], j, c[2] == j ? c[3] : c[3]+1, target, q, check)) return true;
        		}
        	}
    	}

    	
    	
    	return false;
    }
    public static boolean findTarget(int ch, int cw, int cd, int dcnt, char target, Queue<Integer[]> q, boolean[][] check) {
    	if(ch >= tm || ch < 0 || cw >= tn || cw < 0 || dcnt >= 2 || check[ch][cw]) return false;
    	if(cboard[ch][cw] == target) {
    		cboard[ch][cw] = '.';
    		return true;
    	}
    	else if(cboard[ch][cw] == '.') {
    		q.add(new Integer[] {ch, cw, cd, dcnt}); 
    		check[ch][cw] = true;
    	}
    	
    	return false;
    }
    
    static class boardPOS implements Comparable<boardPOS> {
    	char tile;
    	int h, w;
    	public boardPOS(char t, int h, int w) {
    		this.tile = t;
    		this.h = h;
    		this.w = w;
    	}
		@Override
		public int compareTo(boardPOS o) {
			return this.tile < o.tile ? -1 : 1;
		}
		@Override
		public String toString() {
			return "boardPOS [tile=" + tile + ", h=" + h + ", w"
					+ "=" + w + "]";
		}
		
    }
	
    public static int solution3(int n, int[][] computers) {
    	// 각 컴퓨터간 연결관계가 존재하면 서로 연결되어있다고 할 수 있고, 정보를 교환할 수 있다. = 같은 네트워크상에 있다고 할 수 있다
    	// 연결관계를 확인하여 총 분리된 네트워크가 몇개 존재하는지를 확인한다.
    	// 컴퓨터 개수인 n 은 200이하임 (3제곱 가능)
    	// 자기 자신과는 항상 연결되어있다고 표시한다.
    	
    	int[] parent = new int[n];	// 각 컴퓨터의 루트값을 체크
    	for(int i=0;i<n;i++) parent[i] = i; 	// 기본 루트값은 자기 자신으로 설정
    	
    	for(int i=0;i<n;i++) {
    		for(int j=i+1;j<n;j++) {
    			if(computers[i][j] == 1) {
    				unip(parent, i, j);
    			}
    		}
    	} // n^2
    	
    	
    	// 각 부모값을 지정해주어서, 얻게된 결과 루트배열을 확인하여, 루트값이 서로 다른 것의 개수를 세면 네트워크의 개수가 된다.
    	// 간편하게 계산하기 위해서 HashSet을 이용한다.
    	HashSet<Integer> set = new HashSet<Integer>();
    	for(int i=0;i<n;i++) {
    		if(!set.contains(getp(parent, i))) {
    			set.add(getp(parent, i));
    		}
    	}
    	
    	System.out.println(Arrays.toString(parent));
    	
        return set.size();
    }
    public static int getp(int[] p, int x){
        if(p[x] == x) return x;
        return p[x] = getp(p,p[x]);
    }
    public static void unip(int[] p, int a, int b){
        a = getp(p, a);
        b = getp(p, b);
        if(a<b) p[b] = a;
        else p[a] = b;
    }
	
    public static int solution2(int[][] jobs) {
    	// 하드디스크는 한번에 하나의 작업만 수행 가능 -> 가장 일반적인 방법은 요청이 들어온 순서대로 처리
    	// 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지를 리턴해야한다.
    	// 가장 요청 수를 줄이는 방법을 찾아야함 -> 모든 방법 고려? -> 시간오버남
    	// jobs의 길이는 1 이상 500 이하 (제곱 가능)
    	// 작업을 선택하는 단계와 작업 진행하는 단계가 별도로 나뉘어야함.
    	// 작업을 선택하는 단계에서, 현재 대기중인 작업 중에서 작업 시간이 가장 짧은 것을 먼저 진행해야함.
    	// 가장 짧은것을 선택하기 위해서 우선순위큐를 이용함.
    	
    	int n = jobs.length, answer = 0;
    	Arrays.sort(jobs, (a,b) -> a[0] > b[0] ? 1 : -1); // 입력되는 배열을 요청되는 시간 순서대로 정렬한다. log N
    	
    	int CurrTime = 0, CurrIndex = 0;
    	PriorityQueue<Job> pq = new PriorityQueue<Job>();
    	// 여기서 우선순위 큐에서 작업이 들어간 시간을 넣어줌으로써, 작업의 걸린시간 평균을 계산할 수 있도록 해야함.
    	
    	
    	while(CurrIndex < n || !pq.isEmpty()) {
    		if(CurrIndex < n) {
    			// 아직 남아있는 작업이 있다면, 현재 시간을 체크하여, 작업을 큐 안에 넣어줄지를 파악함.
    			while(CurrIndex < n && jobs[CurrIndex][0] <= CurrTime) {
    				pq.add(new Job(jobs[CurrIndex][0], jobs[CurrIndex][1]));
    				CurrIndex++;
    			}	// 현재 시간 이후라면, 큐에 작업을 넣어준다.
    			if(pq.isEmpty()) {
    				// 만약 아직 작업이 더 남아있는데 큐에 작업이 들어가지 않는다면, 시간을 다음 작업의 시간만큼 흐르게 해준다.
    				CurrTime = jobs[CurrIndex][0];
    			}
    		}
    		
    		if(!pq.isEmpty()) {
    			// 큐에 들어온 작업을 하나씩 처리한다. 우선순위 큐에서 현재 대기중인 작업 중 가장 작업 시간이 짧은것을 꺼내서 진행한다.
    			Job j = pq.poll();
//    			System.out.println(j.toString());
    			CurrTime += j.time;
    			answer += CurrTime - j.start;
    		}
    	}

        return answer/n;
    } 
    static class Job implements Comparable<Job> {
    	int start;
    	int time;
    	
    	public Job(int s, int t) {
    		this.start = s;
    		this.time = t;
    	}

		@Override
		public int compareTo(Job o) {
			// TODO Auto-generated method stub
			return this.time < o.time ? -1 : 1;
		}

		@Override
		public String toString() {
			return "Job [start=" + start + ", time=" + time + "]";
		}
		
    }
    
}