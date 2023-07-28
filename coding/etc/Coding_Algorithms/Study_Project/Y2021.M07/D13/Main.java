package D13;
import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		
		System.out.println("res = " + solution("aAbAbAbAa"));
		
//		System.out.println(solution("gHaEaLaLaOgbWORLDb"));
//		System.out.println(solution("SpIpGpOpNpGaJqOqAa"));
//		System.out.println(solution("AxAxAxAoBoBoB"));
	}
	
	static boolean[] checkArr;
	static ArrayList<String> words;
	public static String solution(String sentence) {
		// 프로그래머스 브라이언의 고민 문제
		// 신고받은 글이 광고글인지를 운영자가 판단하여 차단, 
		// 1. 특정 단어를 선택하여 글자 사이마다 같은 기호를 넣음
		// 2. 특정 단어를 선택하여 단어 앞뒤에 같은 기호를 넣음
		// 두가지 규칙이 한 단어에 모두 적용될 수 있으나, 같은 규칙이 두번 적용되지 않음.
		// 한번 쓰인 소문자(특수기호)는 다시 쓰이지 않음. -> 특수기호는 소문자로만 표시되며, 일반 문자는 대문자, 특수기호는 소문자로 취급한다.
		// 예제를 통해서, 규칙이 적용되지 않은 단어가 있을 수도 있다.
		
		
		// 소문자의 개수가 3개 이상이거나 1개라면 무조건 첫번째 조건으로 처리된다. 여기서 첫번째 조건으로 처리가 불가능하다면 invalid를 출력한다.
		// 개수가 두개라면 두번째로 우선처리한다. 여기서 우선처리 조건은 첫번째 조건을 처리한 부분과 완전히 겹치거나, 완전히 겹치지 않아야한다. (걸쳐서 겹치면 invalid를 출력한다.)
		// 마지막으로 두번째 처리가 안된 나머지 두개짜리를 첫번째 조건으로 처리한다. 여기서 이미 첫번째 조건으로 처리되었거나, 위치가 겹치거나, 첫번째 초건 처리가 불가능하면 invalid를 출력한다.
		StringBuffer str = new StringBuffer(sentence);
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0;i<str.length();i++) {
			if(isLower(str.charAt(i))) {
				if(map.containsKey(str.charAt(i))) {
					map.replace(str.charAt(i), map.get(str.charAt(i)) + 1);
				}
				else map.put(str.charAt(i), 1);
			}
		} // map으로 각각 개수세기.
		
		words = new ArrayList<>();
		checkArr = new boolean[str.length()];
		// 출력되는 단어를 넣을 리스트와 체크배열
		
		Iterator<Character> iter = map.keySet().iterator();
		while(iter.hasNext()) {
			char key = iter.next();
			int cnt = map.get(key);
			if(cnt >=3 || cnt == 1) {
				// 첫번째 조건 처리
				map.remove(key);
				int finalIdx = check_one(str, key, cnt);
				System.out.println("finalIdx = " + finalIdx+" "+str+" "+str.substring(finalIdx-(cnt*2), finalIdx+1));
				if(finalIdx == -1 || hasLower(str.substring(finalIdx-(cnt*2), finalIdx+1), key)) return "invalid";
				// 첫번째 조건을 처리하면서 만약, 첫번째 조건을 처리하였는데 맨 앞뒤에 소문자가 붙은 것 이외에 다른 소문자가 아직 존재한다면, invalid를 출력해야한다.
				// 혹은 함수에서 올바르지 않은 처리방식이 존재하면 finalIdx가 -1이 된다. 이 경우에도 invalid를 출력한다.
				
				if(finalIdx-(cnt*2)-1 >= 0 && finalIdx+1 < str.length() && str.charAt(finalIdx-(cnt*2)-1) == str.charAt(finalIdx+1) 
						&& isLower(str.charAt(finalIdx+1)) && map.get(str.charAt(finalIdx+1)) == 2) {
					map.remove(str.charAt(finalIdx+1));
					Arrays.fill(checkArr, finalIdx-(cnt*2)-1, finalIdx+2, true);
				}
				else Arrays.fill(checkArr, finalIdx-(cnt*2), finalIdx+1, true);
				// 맨 앞과 맨 뒤에 소문자가 붙어있으며, 해당 소문자의 개수가 두개라면, 두번째 조건으로 처리해준다.
				// 맨 앞이나 맨 뒤에 소문자가 하나만 붙은 경우에는 그냥 무시한다.
				
				addWord(str.substring(finalIdx-(cnt*2), finalIdx+1));
			}
		}
		
		iter = map.keySet().iterator();
		while(iter.hasNext()) {
			char key = iter.next();
			int cnt = map.get(key);
			// 두번째 조건을 우선처리한다.
			// 참고로 여기서 첫번째 처리 조건에 한번 걸렀기 때문에, 첫번째 처리한 위치에 두번째 조건의 일부가 남아있는 경우는 없으므로 검증할 필요가 없다.
			// 두번째 조건을 처리할 때, 두번째 조건을 처리한 결과의 맨앞과 뒤에 마찬가지로 두개짜리 소문자가 남아있다면 해당 조건을 두번째 조건으로 간주하여 처리해주면 된다.
			// 이를 통해 세번째를 별도로 조사하지 않고 처리가 가능하다.
			
			// 마지막으로 값이 남아있을 때, 두번째 조건 처리가 아예 불가능한 경우(소문자 두 개가 서로 붙어있거나, 더이상 처리할 수 있는 단어가 남아있지 않은경우) invalid를 출력한다.
			
		}
		
		for(int i=0;i<words.size();i++) {
			System.out.println(words.get(i));
		}
		
		System.out.println(Arrays.toString(checkArr));
		
	    return str.toString();
    }
	
	public static boolean isLower(char c) {
		if(c >= 'a' && c <= 'z') return true;
		return false;
	}
	public static boolean hasLower(String str, char c) {
		for(int i=0;i<str.length();i++) {
			if(isLower(str.charAt(i)) && str.charAt(i) != c) return true;
		}
		return false;
	}
	
	public static int check_one(StringBuffer str, char c, int count) {
		int startidx = str.indexOf(Character.toString(c));
		int finalidx = startidx;
		if(finalidx == 0) return -1; 
		
		for(int i=0;i<count;i++) {
			if(finalidx >= str.length()-1 || str.charAt(finalidx) != c) return -1;
			else finalidx += 2;
		}
		finalidx--;
		if(!check_arr(startidx, finalidx)) return -1;
		
		return finalidx;
	}
	
	public static int check_two(StringBuffer str, char c) {
		int finalidx = str.indexOf(Character.toString(c));
		str.deleteCharAt(finalidx);
		finalidx = str.indexOf(Character.toString(c));
		str.deleteCharAt(finalidx);
		
		return finalidx-1;
	}
	
	public static void addWord(String strs) {
		StringBuffer str = new StringBuffer(strs);
		for(int i=0;i<str.length();i++) {
			if(isLower(str.charAt(i))) {
				str.deleteCharAt(i);
				i--;
			}
		}
		words.add(str.toString());
	}
	
	public static boolean check_arr(int start, int end) {
		for(int i=start;i<end;i++) {
			if(checkArr[i]) return false;
		}
		return true;
	}

	
}