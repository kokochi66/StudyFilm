package javaSpeedcoding;

public class lineEncoding {
	int concount(String s, int swit){
	    int count = 0;
	    while(s.charAt(swit+count)==s.charAt(swit)) {
	        count++;
	        if(swit+count>s.length()-1) return count;
	    }
	    return count;
	}

	String lineEncoding(String s) {
	    String output = "";
	    int i=0, contemp;
	    while(i<s.length()){
	        contemp = concount(s,i);
	        if(contemp<=1) output+=s.charAt(i);
	        else {
	            output+=Integer.toString(concount(s, i));
	            output+=s.charAt(i);
	        }
	        i+=contemp;
	    }
	    return output;
	}

}
