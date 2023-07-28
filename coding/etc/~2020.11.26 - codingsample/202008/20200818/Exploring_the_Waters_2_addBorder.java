package Exploring_the_Waters;

public class Exploring_the_Waters_2_addBorder {
	static String[] addBorder(String[] picture) {
		long start = System.currentTimeMillis();
	    String[] output = new String[picture.length+2];
	    int len = picture[0].length()+2,i;
	    String temp = "*";
	    for(i=1;i<len;i++) temp+='*';
	    for(i=0;i<output.length;i++){
	        if(i==0||i==output.length-1) output[i] = temp;
	        else output[i] = '*'+picture[i-1]+'*';
	    }
	    long end = System.currentTimeMillis();
	    System.out.println( "addBorder 실행 시간 : " + ( end - start )/1000.0 );
	    return output;
	}
	static //나의 답안
	String[] addBorder2(String[] picture) {
		long start = System.currentTimeMillis();
	    String[] framedPicture = new String[picture.length + 2];
	    for(int i = 0 ; i < picture.length ; i++) {
	        framedPicture[i+1] = '*' + picture[i] + '*';
	    }
	    framedPicture[0] = framedPicture[picture.length + 1] = framedPicture[1].replaceAll(".","*");
	    long end = System.currentTimeMillis();
	    System.out.println( "addBorder2 실행 시간 : " + ( end - start )/1000.0 );
	    return framedPicture;
	}
	//모범답안
	//첫번째값과 마지막값에 스트링개수를 맞춘 뒤, 그 모두른 *로 바꾸는 replaceAll을 사용함.
	public static void main(String[] args) {
		String[] picture = 
		{"abcde", 
			 "fghij", 
			 "klmno", 
			 "pqrst", 
			 "uvwxy"};
		addBorder(picture);
		addBorder2(picture);

	}

}
