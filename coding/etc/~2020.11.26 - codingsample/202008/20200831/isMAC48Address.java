package javaSpeedcoding;

public class isMAC48Address {
	boolean isMAC48Address(String inputString) {
	    int len = inputString.length();
	    if(len%3!=2) return false;
	    for(int i=0;i<len;i++){
	        if(i%3==0 || i%3==1) {
	            if(!(inputString.charAt(i)>='0'&&inputString.charAt(i)<='9'||inputString.charAt(i)>='A'&&inputString.charAt(i)<='F')) return false;
	        }
	        else if(inputString.charAt(i)!='-'||i==0) return false;
	    }
	    return true;
	}


}
