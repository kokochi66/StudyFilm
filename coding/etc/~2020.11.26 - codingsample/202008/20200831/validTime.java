package javaSpeedcoding;

public class validTime {
	boolean validTime(String time) {
	    if(time.charAt(0)>='3'||time.charAt(0)<'0'||time.charAt(2)!=':'||time.charAt(3)>='6'||time.charAt(3)<'0') return false;
	    else if(time.charAt(0)=='2'&&(time.charAt(1)<'0'||time.charAt(1)>='4')) return false;
	    else if(time.charAt(4)<'0'&&time.charAt(4)>'9') return false;
	    return true;
	}

}
