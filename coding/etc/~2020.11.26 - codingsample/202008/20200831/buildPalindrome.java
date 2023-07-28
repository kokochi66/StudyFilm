package javaSpeedcoding;

public class buildPalindrome {
	boolean chkcanPalin(String st , int cen, int com) {
	    if(cen>=st.length() || com<0) return false;
	    if(st.charAt(cen) == st.charAt(com)) {
	        if(cen == st.length()-1) return true;
	        else return chkcanPalin(st,cen+1,com-1);
	    }
	    return false;
	}

	String buildString(String st , int com){
	    if(com<0) return st;
	    st+=st.charAt(com);
	    return buildString(st,com-1);
	}

	String buildPalindrome(String st) {
	    int len = st.length(), center;
	    if(len%2==0) center = len/2;
	    else center = (len/2)+1;
	    if(chkcanPalin(st, center, center-1)) return st;
	    while(true){
	        if(chkcanPalin(st, center, center-1)) {
	            return buildString(st,(center*2)-len-1);
	        }
	        else if(chkcanPalin(st, center, center-2)) {
	            return buildString(st,(center*2)-len-2);
	        }
	        else if(center == len-1) {
	            System.out.println("all not");
	            return buildString(st,len-2);
	        }
	        center++;
	    }
	}

}
