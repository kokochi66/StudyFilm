package javaSpeedcoding;

public class longestWord {
	String longestWord(String text) {
	    boolean start = false, end = false;
	    String tempString = "";
	    String maxString = "";
	    for(int i=0;i<text.length();i++){
	        if(text.charAt(i)>='a'&&text.charAt(i)<='z'||text.charAt(i)>='A'&&text.charAt(i)<='Z'){
	            start = true;
	            end = false;
	            tempString += text.charAt(i);
	            if(i==text.length()-1){
	                if(maxString.length()<tempString.length()) maxString = tempString;
	                return maxString;
	            }
	        }
	        else if(start) {
	            start = false;
	            end = true;
	            if(maxString.length()<tempString.length()) maxString = tempString;
	            tempString = "";
	        }
	    }
	    return maxString;
	}


}
