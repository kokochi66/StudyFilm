import java.util.stream.*;

public class pro_Level1_15 {
    public static boolean solution(String a) {
        return IntStream.range(0, a.length()).map(i->a.charAt(i)).filter(q-> q>='0' && q<='9').toArray().length == a.length() && (a.length() == 4 || a.length() == 6);
    }
}
