import java.util.Arrays;
import java.util.stream.IntStream;

public class Intro3_Smooth_Sailing {
    private static String[] allLongestStrings(final String[] inputArray) {
        return Arrays.stream(inputArray).filter(i -> i
                .length() == (IntStream.range(0, inputArray.length).map(j -> inputArray[j].length()).max().getAsInt()))
                .toArray(String[]::new);
    }

    // 입력된 문자열 배열에서 길이가 가장 큰 것만 남기고 출력
    // Array에 stream -> filter를 이용해서 걸르고, 최대길이는 IntStream을 통해서 간단하게 확인가능
    private static int commonCharacterCount(final String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s2.contains(String.valueOf(s1.charAt(i)))) {
                count++;
                s2 = s2.replaceFirst(String.valueOf(s1.charAt(i)), "");
            }
        }
        return count;
    }
    // 입력된 두 문자열간에 겹치는 문자 수를 출력
    //문자열을 이용하는 함수 contains와 replace를 유용하게 사용할 수 있음을 모범답안으로 확인할 것
    private static boolean isLucky(int n){
        String temp = n+"";
        return IntStream.range(0,temp.length()/2).map(i->temp.charAt(i)-temp.charAt(temp.length()-1-i)).sum() == 0;
    }
    //입력된 정수의 앞의 절반값과 뒤의 절반값이 합이 같은지를 출력
    //n+"" 를 통해 문자열로 만들어주고, 절반값과 절반값의 차이가 0인지를 출력하면 간단하게 구현가능
    private static String reverseInParentheses(String inputString) {
        StringBuilder s = new StringBuilder(inputString);
        int start, end;
        while(s.indexOf("(")!=-1){
            start = s.indexOf("(");
            end = s.indexOf(")",start);
            s.replace(start, end + 1, new StringBuilder(s.substring(start+1, end)).reverse().toString());
        }
        return s.toString();
    }
    //입력된 문자열에서 괄호안의 부분만 뒤집어서 출력
    // StringBuilder를 이용, indexof와 replace, substring의 reverse를 통해 구현

    public static void main(final String[] args){
        final String[] a = {"aba", "aa", "ad", "vcd", "aba"};
        System.out.println(Arrays.toString(allLongestStrings(a)));
        System.out.println(commonCharacterCount("adbcc","adcaa"));
        System.out.println(isLucky(134009));
        System.out.println(reverseInParentheses("a(abc)b"));
    }
    
}
