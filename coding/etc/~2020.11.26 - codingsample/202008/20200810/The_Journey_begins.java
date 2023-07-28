package The_Journey_Begins;

public class The_Journey_begins {
	int add(int param1, int param2) {
		return param1+param2;
	}
	
	int centuryFromYear(int year) {
		return --year/100 +1;
	}
	boolean checkPalindrome(String inputString) {
	    return inputString.equals(new StringBuilder(inputString).reverse().toString());
	}

}
