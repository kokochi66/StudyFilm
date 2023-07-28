package N6_Rains_of_Reason;

import java.util.Arrays;

public class Rains_of_Reason_2_evenDigitsOnly {
	static boolean evenDigitsOnly(int n) {
		int temp;
		while(n!=0) {
			temp = n;
			if(temp%2!=0) return false;
			n/=10;
		}
		return true;
	}
	static boolean evenDigitsOnly2(int n) {
		String temp = String.valueOf(n);
		for(char s : temp.toCharArray())  {
			if((s-'0') % 2 != 0) return false;
		}
		return true;
	}
	
	static boolean evenDigitsOnly3(int n) {
	    return Arrays.stream(Integer.toString(n).split("")).allMatch(i -> Integer.parseInt(i) % 2 ==0);}
	
	static boolean evenDigitsOnly4(int n) {
	    return Integer.toString(n).matches("(0|2|4|6|8)*");}
	
	static boolean evenDigitsOnly5(int n) {
	        return (n + "").matches("[02468]+");}

	public static void main(String[] args) {
		int a = 248622;
		int b = 42608;
		System.out.println((b+"").matches("(0|2|4|6|8)"));
	}

}
