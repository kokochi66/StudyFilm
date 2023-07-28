package javaSpeedcoding;

public class deleteDigit {
	int DigitNum(int a,int b){
	    if(b==1) return a/10;
	    int temp = (a/(int)(Math.pow(10,b)))*(int)(Math.pow(10,b-1));
	    a = a - ((a/(int)Math.pow(10,b-1))*(int)Math.pow(10,b-1));
	    System.out.println(a);
	    System.out.println(temp);
	    a += temp;
	    return a;
	}

	int deleteDigit(int n) {
	    int max = n/10, temp;
	    int len = Integer.toString(n).length();
	    for(int i=2;i<=len;i++){
	        temp = DigitNum(n, i);
	        if(temp>max) max = temp;
	    }
	    return max;
	}


}
