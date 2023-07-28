import java.util.stream.*;

public class pro_Level1_32 {
    public static double solution(int[] arr) {
        return (double)((double)IntStream.range(0,arr.length).map(i->arr[i]).sum()/(double)arr.length);
    }
}
