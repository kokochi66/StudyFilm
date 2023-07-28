package Smooth_Sailing;

public class reverseInParentheses {
	static String reverseInParentheses(String inputString) {
	    StringBuilder str = new StringBuilder(inputString);
	    int start, end;
	    while(str.indexOf("(") != -1){
	        start = str.lastIndexOf("(");
	        end = str.indexOf(")", start);
	        str.replace(start, end + 1, new StringBuilder(str.substring(start+1, end)).reverse().toString());
	    }
	    return str.toString();
	}
	//새로운 기능 -> StringBuilder
	public static void main(String[] args) {
		String input = "(abc)d(efg)";
		StringBuilder str = new StringBuilder(input);
		int a = str.lastIndexOf("(");
		System.out.println(str.lastIndexOf("("));
		// '('문자 중 가장 마지막에 나오는 위치가 출력되는 lastIndexof 함수
		System.out.println(str.indexOf(")",a));
		// '('문자 중 가장 최초에 나오는 위치가 출력되는 lastIndexof 함수
		// 두번째값을 주면서 해당 위치부터 검색이 가능함
		// 문자열 반전시키는 replace를 통해 해당부분을 반전시키는 함수적용.
	}

}
