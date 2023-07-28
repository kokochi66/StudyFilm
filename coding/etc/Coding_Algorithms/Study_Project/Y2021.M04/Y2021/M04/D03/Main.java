package Y2021.M04.D03;
import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		solution4();
	}
	public static void solution4() throws Exception {
		int n = Integer.parseInt(rd.readLine());
		boolean[][][] check = new boolean[n][n][3];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int c = sol4_query();
			}
		}
	}
	
	public static void sol4_BFScheck(int y, int x) {
		
	}
	
	public static int sol4_findc(int color, int y, int x) {
		
		return 0;
	}
	
	public static int sol4_query() throws Exception {
		System.out.flush();
		return Integer.parseInt(rd.readLine());
	}
	
	public static void solution3() throws Exception {
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			int n = Integer.parseInt(rd.readLine());
			char[] s = rd.readLine().toCharArray();
			StringBuilder a = new StringBuilder("");
			StringBuilder b = new StringBuilder("");
			boolean pass = false;
			
			
			if(s[0] == s[n-1] && s[0] == '1') {
				// 맨 앞과 맨 뒤가 1이 아니라면, 각 문자열에서 시작과 끝의 괄호가 같지 않게된다.
				// 여기서 시작과 끝의 괄호는 ( 와 ) 로 각각 정해져있기 때문에, 이 값이 달라지면 둘 중 하나의 밸런스가 무너지게 되므로 NO이다.
				int[] cnt = new int[2];
				for(int i=1;i<n-1;i++) cnt[s[i] - '0']++;
				// 맨 앞과 맨 뒤를 제외한 0과 1의 개수를 세준다.
				if(cnt[0]%2 == 0 && cnt[1]%2 == 0) pass = true;
				// 0과 1의 개수가 모두 짝수여야한다.
				// 일단 길이 자체가 홀수이면 성립하지 않으므로 길이는 무조건 짝수이다.
				// 여기서 둘 중 하나가 홀수라면 나머지 하나도 홀수가 된다.
				// 그런데 둘다 홀수이면, 1개라도 존재하는 1을 통해 같은 괄호를 0을 통해서 맞춰줄수가 없다.
				// 그러므로 0과 1의 개수가 모두 짝수여야 성립한다.
				
				if(pass) {
					char c = ')';
					a.append('(');
					b.append('(');
					// 초기값을 여는 괄호로 설정한다.
					int cntOne = 0;
					
					for(int i=1;i<n-1;i++) {
						if(s[i] == '0') {	// 배열값이 0이라면 서로 다른값을 주어야한다.
							// 여기서 위의 조건을 이미 달성했다면 사실 두 괄호는 번갈아가면서 적용하면 된다.
							// 번갈아가면서 적용하기 위해서 c값을 초기화한뒤 적용한다.
							a.append(c);	// a에 c값을 적용하고
							b.append(c == ')' ? '(' : ')'); // b에는 c값의 반대 괄호를 적용한다.
							c = c == ')' ? '(' : ')';	// 번갈아가면서 적용해주기 위해서 c값은 반대값으로 바꿔준다.
						} else if(s[i] == '1') {
							char oc = '(';		// 1의 경우에는 왼쪽절반은 여는괄호, 오른쪽 절반은 닫는괄호로 적용해준다.
							if(cntOne < cnt[1]/2) oc = '(';	// 카운트를 해주며, 카운트가 절반보다 적으면 여는괄호를 적용
							else oc = ')';	// 카운트가 절반보다 많으면 닫는괄호를 적용해준다.
							a.append(oc);
							b.append(oc);
							cntOne++;
						}	// 두 값을 적용해주고 카운트를 늘려주면 된다.
 					}
					a.append(')');
					b.append(')');
					// 마지막으로 닫는괄호로 끝낸다.
				}
			}
			if(pass) {
				wr.write("YES");
				wr.newLine();
				wr.write(a.toString());
				wr.newLine();
				wr.write(b.toString());
				wr.newLine();
			} else {
				wr.write("NO");
				wr.newLine();
			}
		}
		wr.flush();
	}
	
	public static void solution2() throws Exception {
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			int n = Integer.parseInt(rd.readLine());
			char[] a = rd.readLine().toCharArray();
			char[] b = rd.readLine().toCharArray();
			
			boolean start = false;
			boolean chgau = true;
			boolean pass = true;
			int[] cnt = new int[2];
			for(int i=n-1;i>=0;i--) {
				if(!start && a[i] == b[i]) continue;	// 끝의값부터 이미 같은 값들은 패스한다.
				else if(!start) start = true;
				
				if(chgau) {
					if(cnt[0] != cnt[1] && a[i] == b[i]) {
						pass = false;
						break;	// 0의 개수와 1의 개수가 같지 않은데 같은값이 나왔으면 NO
					}
					else if(a[i] == b[i]) {
						chgau = false;
//						wr.write(Arrays.toString(a)+" "+Arrays.toString(cnt) +" "+i);
//						wr.newLine();
						i++;
						cnt[0] = 0;
						cnt[1] = 0;
						continue;
					} // 0의 개수와 1의 개수가 같으며 같은값이 나오면 다시 돌려서 같은 값을 체크하도록 한다.
					else {
						cnt[a[i]-'0']++;
					}	// 그냥 다른값이 나온 경우 카운트를 올려준다.
				} else {
					if(cnt[0] != cnt[1] && a[i] != b[i]) {
						pass = false;
						break;	// 0의 개수와 1의 개수가 같지 않은데 다른값이 나왔으면 NO
					}
					else if(a[i] != b[i]) {
						chgau = true;
//						wr.write(Arrays.toString(a)+" "+Arrays.toString(cnt) +" "+i);
//						wr.newLine();
						i++;
						cnt[0] = 0;
						cnt[1] = 0;
						continue;
					} // 0의 개수와 1의 개수가 같으며 다른값이 나오면 다시 돌려서 같은 값을 체크하도록 한다.
					else {
						cnt[a[i]-'0']++;
					}	// 그냥 같은 값이 나온 경우 카운트를 올려준다.
				}
				
				if(i == 0 && cnt[0] != cnt[1]) pass = false;		// 맨앞에서 또한 카운트의 개수가 같지 않으면 NO
			}
			wr.write(pass ? "YES" : "NO");
			wr.newLine();
		}
		wr.flush();
	}
	
	public static void solution() throws Exception {
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			StringBuilder str = new StringBuilder(rd.readLine());
			int n = str.length();
			boolean yes = false;
			for(int i=0;i<n;i++) {
				if(str.charAt(i) != 'a') {
					str.insert(n-i, 'a');
					yes = true;
					break;
				}
			}
			if(yes) {
				System.out.println("YES");
				System.out.println(str);
			} else System.out.println("NO");
		}
	}
}