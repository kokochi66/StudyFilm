import java.util.*;

public class pro_Level1_10 {
    public static int[] solution(int[] arr, int divisor) {
        int[] output = Arrays.stream(arr).filter(i->i%divisor==0).sorted().toArray();
        if(output.length==0) return new int[]{-1};
        else return output;
    }
    public static void main(String[] args){
    }
}
