import java.util.Arrays;

public class pro_Level1_38 {
    public static int solution(int[] d, int budget) {
        Arrays.sort(d);
        int i=0;
        while(budget > 0 && i<d.length){
            if(budget>= d[i]) budget -= d[i];
            else return i;
            i++;
        }
        return i;
    }
}
