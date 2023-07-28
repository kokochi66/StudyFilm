import java.util.stream.*;

public class pro_Level1_13 {
    public static boolean solution(String s) {
        return (IntStream.range(0, s.length()).filter(i->s.toLowerCase().charAt(i)=='p').toArray().length) == (IntStream.range(0, s.length()).filter(q->s.toLowerCase().charAt(q)=='y').toArray().length);
    }
}
