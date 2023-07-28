package Exploring_the_Waters;

import java.util.Arrays;

public class Exploring_the_Waters_5_palindromeRearranging {
	static boolean palindromeRearranging(String inputString) {
		int asc[] = new int[127];
		Arrays.fill(asc, 0); //배열의 모든값을 0으로 초기화
		boolean err = false;
		for(int i=0;i<inputString.length();i++) asc[inputString.charAt(i)]++;
		for(int i=0;i<127;i++) {
			if(asc[i]%2!=0) {
				if(err==true) return false;
				else err=true;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String a = "aabbbgggeeg";
		System.out.println(palindromeRearranging(a));

	}

}
