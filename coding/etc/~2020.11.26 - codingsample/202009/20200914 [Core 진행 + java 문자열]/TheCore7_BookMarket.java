import java.util.Arrays;

public class TheCore7_BookMarket {
    private static String encloseInBrackets(String inputString) {
        return "(" + inputString + ")";
    }
    //입력된 문자열을 괄호안에 넣기
    private static String properNounCorrection(String noun) {
        return noun.substring(0,1).toUpperCase() + noun.substring(1).toLowerCase();
    }
    //입력된 문자열을 첫글자만 대문자, 나머지는 소문자로 바꾸기.
    private static boolean isTandemRepeat(String inputString) {
        System.out.println(inputString.matches("(\\w+)\\1"));   //나중에 분석이 필요하다. 이게모냐
        return inputString.substring(0,inputString.length()/2).equals(inputString.substring(inputString.length()/2));
    }
    //입력된 문자열의 앞 절반과 뒤의 절반이 같은지
    private static boolean isCaseInsensitivePalindrome(String inputString) {
        // String output = inputString.substring(0).toLowerCase();
        // for(int i=0;i<output.length()/2;i++) if(output.charAt(i) != output.charAt(output.length()-1-i)) return false;
        // return true;
        return new StringBuilder(inputString).reverse().toString().equalsIgnoreCase(inputString);
    }
    //문자열의 대문자, 소문자를 조정하여 회문이 될 수 있는지 출력.
    private static String findEmailDomain(String address) {
        return new StringBuilder(address).substring(address.lastIndexOf('@')+1);
    }
    //입력된 문자열의 이메일주소 부분을 출력
    private static String htmlEndTagByStartTag(String startTag) {
        // int end = startTag.indexOf(" ")!=-1 ? startTag.indexOf(" ") : startTag.indexOf(">");
        // return "</" + new StringBuilder(startTag).substring(startTag.indexOf('<')+1,end) + ">";
        return "</" + startTag.split("[< >]")[1] + ">";
    }
    //입력된 HTML 시작태그에 맞는 종료태그를 출력
    private static boolean isMAC48Address(String inputString) {
        // for(int i=0;i<inputString.length();i++){
        //     if((i+1)%3 == 0) {
        //         if (inputString.charAt(i) != '-' || i==inputString.length()-1) {
        //             System.out.println(inputString.charAt(i) + " " + (i+1)%3 + " " + i);
        //             return false;
        //         }
        //     }
        //     else {
        //         if(!(inputString.charAt(i) >= '0' && inputString.charAt(i) <= '9') && !(inputString.charAt(i) >= 'A' && inputString.charAt(i) <= 'F')) {
        //             System.out.println(inputString.charAt(i) + " " + (i+1)%3);
        //             return false;
        //         }
        //     }
        // }
        // return true;
        return inputString.matches("[0-9A-F]{2}-{5}[0-9A-F]{2}");
    }

    private static boolean isUnstablePair(String filename1, String filename2) {
        int len = Math.min(filename1.length(),filename2.length());
        boolean leftOne = filename1.length() > filename2.length();
        boolean lefttwo = leftOne;
        for(int i=0;i<len;i++){
            if(filename1.charAt(i) != filename2.charAt(i)){
                System.out.println(filename1.charAt(i) + " " + filename2.charAt(i));
                leftOne = filename1.charAt(i) > filename2.charAt(i);
                break;
            }
        }
        filename1 = filename1.toLowerCase();
        filename2 = filename2.toLowerCase();
        for(int i=0;i<len;i++){
            if(filename1.charAt(i) != filename2.charAt(i)){
                System.out.println(filename1.charAt(i) + " " + filename2.charAt(i));
                lefttwo = filename1.charAt(i) > filename2.charAt(i);
                break;
            }
        }
        System.out.println(leftOne + " " + lefttwo);
        return leftOne != lefttwo;
    }
    // 버러지같은 문제

    
    public static void main(String[] args){
        // System.out.println(encloseInBrackets("What the Fuck"));
        // System.out.println(properNounCorrection("pARiS"));
        // System.out.println(isTandemRepeat("aaaaaa"));
        // System.out.println(isCaseInsensitivePalindrome("AaBba"));
        // System.out.println(findEmailDomain("kokochikochi@gmail.com"));
        // System.out.println(htmlEndTagByStartTag("<i>"));
        // System.out.println(isMAC48Address("00-1B-63-84-45-E6"));
        System.out.println(isUnstablePair("yyyyyy","Azzzzzzzzz"));
        
    }
    
}
