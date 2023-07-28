import java.util.*;

public class pro_Level1_25 {
    public static long solution(long a) {
        char[] temp = (a+"").toCharArray();
        Arrays.sort(temp);
        return Long.parseLong(new StringBuilder(new String(temp)).reverse().toString());
    }
}
