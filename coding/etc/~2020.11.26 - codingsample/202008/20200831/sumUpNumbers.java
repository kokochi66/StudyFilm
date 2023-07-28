package javaSpeedcoding;

public class sumUpNumbers {
	
	static int pointtoString(String a, int start, int end){
	    String temp = "";
	    for(int i=start;i<=end;i++) temp += a.charAt(i);
	    System.out.println("point " + temp);
	    return Integer.parseInt(temp);
	}
	static int sumUpNumbers(String a) {
		int sum = 0;
		int start = 0;
		boolean search = false;
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i)>='0'&&a.charAt(i)<='9'&&!search) {
				search = true;
				start = i;
			}
			else if((!(a.charAt(i)>='0'&&a.charAt(i)<='9'))&&search) {
				search = false;
				sum += pointtoString(a,start,i-1);
			}
			if(i==a.length()-1&&search) {
				search = false;
				return sum + pointtoString(a,start,i);
			}
		}
		return sum;
	}
	public static void main(String[] args0) {
		String a = "2 apples, 12 oranges";
		System.out.println(sumUpNumbers(a));
	}

}
