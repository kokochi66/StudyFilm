package N6_Rains_of_Reason;

public class Rains_of_Reason_4_alphabeticShift {
	static String alphabeticShift(String inputString) {
		char[] output = inputString.toCharArray();
		int len = output.length,i;
		for(i=0;i<len;i++) {
			if(inputString.charAt(i)=='z') output[i] = 'a';
			else output[i] = (char)(int)(inputString.charAt(i)+1);
		}
		return String.copyValueOf(output);
	}
	public static void main(String[] args) {
		String input = "crazy";
		System.out.println(alphabeticShift(input));
	}

}
