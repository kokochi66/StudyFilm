import java.util.*;

public class pro_Level1_14 {
    public static String solution(String s) {
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        return new StringBuilder(new String(temp)).reverse().toString();
    }
}
