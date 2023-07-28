package javaSpeedCoding20200901;

import java.util.Arrays;

public class fileNaming {
	// 파일이름이 같은 것이 남아있는지를 확인하는 boolean 함수
	static int checkEqualNone(String[] n) {
		for(int i=0;i<n.length-1;i++) {
			for(int j=i+1;j<n.length;j++) {
				if(n[i].equals(n[j])) return i;
			}
		}
		return -1;
	}
	// 파일이름이 같은 것이 있으면 그 다음수, 그 다음수를 계속해서 반환함.
	static String StringCount(String[] n, String comp, int count, int swit) {
		String temp = comp + '(' + Integer.toString(count) + ')';
		for(int i=0;i<swit;i++) {
			if(temp.equals(n[i])) return StringCount(n, comp, count+1, swit);
		}
		return temp;
	}
	// 파일 이름이 같은 파일이 있으면, (1), (2)등 번호를 차례차례 매겨나가는 함수.
	static String[] fileNaming(String[] names) {
		int count = 0, temp = checkEqualNone(names);
		while(temp!=-1) {
			count = 1;
			for(int i=temp+1;i<names.length;i++) {
				if(names[temp].equals(names[i])) {
					names[i] = StringCount(names,names[i],count, i);
				}
			}
			temp = checkEqualNone(names);
		}
		return names;
	}

	public static void main(String[] args) {
		String[] input = {"a", 
				 "b", 
				 "cd", 
				 "b ", 
				 "a(3)"};
		input = fileNaming(input);
		System.out.println(Arrays.toString(input));

	}

}
