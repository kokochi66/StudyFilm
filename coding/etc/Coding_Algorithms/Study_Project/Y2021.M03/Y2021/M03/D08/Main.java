package Y2021.M03.D08;
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
			tok = new StringTokenizer(rd.readLine());
			int n = Integer.parseInt(tok.nextToken());
			int m = Integer.parseInt(tok.nextToken());
			tok = new StringTokenizer(rd.readLine());
			ArrayList<Integer> box = new ArrayList<>();
			ArrayList<Integer> spp = new ArrayList<>();
			int NegBoxPoint = -1;
			int NegSboxPoint = -1;
			
			for(int i=0;i<n;i++) {
				box.add(Integer.parseInt(tok.nextToken()));
				if(NegBoxPoint == -1 && box.get(i) > 0) NegBoxPoint = i;
			}
			
			
			if(NegBoxPoint == -1) NegBoxPoint = n;
			int[] posBox = new int[n-NegBoxPoint];
			int[] negBox = new int[NegBoxPoint];
			int[] POSspd = new int[n-NegBoxPoint];
			int[] NEGspd = new int[NegBoxPoint];
			
			for(int i=0;i<n;i++) {
				if(i<NegBoxPoint) negBox[NegBoxPoint-i-1] = -box.get(i);
				else posBox[i-NegBoxPoint] = box.get(i);
			}
			
			tok = new StringTokenizer(rd.readLine());
			for(int i=0;i<m;i++) {
				spp.add(Integer.parseInt(tok.nextToken()));
				if(NegSboxPoint == -1 && spp.get(i) > 0) NegSboxPoint = i;
			}
			if(NegSboxPoint == -1) NegSboxPoint = m;
			int[] posPos = new int[m-NegSboxPoint];
			int[] negPos = new int[NegSboxPoint];
			for(int i=0;i<m;i++) {
				if(i<NegSboxPoint) negPos[NegSboxPoint-i-1] = -spp.get(i);
				else posPos[i-NegSboxPoint] = spp.get(i);
			}
			solution_count(posBox,posPos,POSspd);
			solution_count(negBox,negPos,NEGspd);
//			System.out.println(Arrays.toString(POSspd));
//			System.out.println(Arrays.toString(NEGspd));
//			System.out.println(solution_s(negBox, negPos,NEGspd, 0));
////			System.out.println(pos+" "+neg);
			System.out.println(Math.max((POSspd.length>0 ? POSspd[0] : 0), solution_s(posBox, posPos,POSspd,0))+
					Math.max((NEGspd.length>0 ? NEGspd[0] : 0), solution_s(negBox, negPos,NEGspd,0)));
		}
	}
	public static int solution_s(int[] p, int[] t, int[] spd, int TargetPoint) {
		if(p.length<1 || t.length < 1) return 0;		// 해당 부분이 존재하지 않는다면 반환
		if(TargetPoint == t.length) return 0;		// 검사위치가 t범위를 벗어나면 반환
		else if(t[TargetPoint] < p[0]) return solution_s(p,t,spd,TargetPoint+1); 	// 검사위치가 기존값보다 작다면 다음값으로 이동
		if(p[0] == t[t.length-1]) return 1;				// 검사위치가 마지막과 일치하면다면 1반환
		
		int leftPoint = 0;
		int rightPoint = 0;
		
		// 1. 왼쪽 끝값은 TargetPoint로 지정된다. leftPoint 정의할 필요가 없음.
		// 2. 오른쪽 끝값은 이진탐색 반복문을 통해 찾아냄 O(N log N)
		// 끝값의 위치를 p배열에서 찾아내며, 수가 늘어나면 한번 더 찾기를 반복한다.
		boolean pass = false;
		int temp = 0;
		while(!pass) {
			int tt = Arrays.binarySearch(p, t[TargetPoint] + temp);		// p배열에서 t[TargetP]의 현 끝값의 위치를 찾는다.
			temp = tt < 0 ? -tt-2 : tt;											// 해당 위치를 특정시킨다. >> 개수가 된다.
			if(rightPoint == t[TargetPoint] + temp) break;							// 해당 위치가 현재의 끝값과 일치한다면 반복문을 종료한다.
			else rightPoint = t[TargetPoint] + temp;
		}
		int tt = Arrays.binarySearch(t , rightPoint);
		rightPoint = tt < 0 ? -tt-1 : tt+1;
		int ts = temp+1 < spd.length ? spd[temp+1] : 0;
		int plsPoint = rightPoint - TargetPoint + ts;
//		System.out.println("TP = "+TargetPoint+" / rP = "+rightPoint+" / pP = "+plsPoint +" / ts = "+ts);
		return Math.max(plsPoint, solution_s(p,t,spd,TargetPoint+1));
	}
	
	public static void solution_count(int[] p, int[] t, int[] spd) {
		if(p.length<1 || t.length < 1) return;		// 해당 부분이 존재하지 않는다면 반환
		int i = p.length-1, j = t.length-1;
		spd[i] = Arrays.binarySearch(t, p[i]) >= 0 ? 1 : 0;		// 끝값이 같은지 확인
		i--;
		while(i>=0) {
			spd[i] = spd[i+1];		// dp적용을 통해 현재 값을 다음값만큼 정의
			if(j>=0 && p[i] == t[j]) {
				spd[i--]++;				// 수가 같다면 dp값 증가
				j--;
			} else if(j>=0 && p[i] < t[j]) j--;
			else i--;
		}
	}
}