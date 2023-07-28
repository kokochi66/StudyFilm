import java.util.*;

public class pro_Level1_12 {
    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings);
        final Comparator<String> comp = (p1,p2) -> Integer.compare(p1.charAt(n), p2.charAt(n));
        return Arrays.stream(strings).sorted(comp).toArray(size -> new String[size]);
    }
    
}
